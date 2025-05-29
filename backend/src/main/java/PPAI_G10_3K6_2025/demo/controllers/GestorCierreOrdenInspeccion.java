package PPAI_G10_3K6_2025.demo.controllers;


import PPAI_G10_3K6_2025.demo.dtos.OrdenesDeInspeccionDTO;
import PPAI_G10_3K6_2025.demo.dtos.SesionDTO;
import PPAI_G10_3K6_2025.demo.models.*;
import PPAI_G10_3K6_2025.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class GestorCierreOrdenInspeccion {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SesionRepository sesionRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private OrdenDeInspeccionRepository ordenDeInspeccionRepository;

    @Autowired
    private SismografoRepository sismografoRepository;

    @Autowired
    private EstacionSismologicaRepository estacionSismologicaRepository;

    private MotivoTipoRepository motivoTipoRepository;

    List<OrdenesDeInspeccionDTO> ordenesDeInspeccionDTOList = new ArrayList<>();

    List<OrdenesDeInspeccionDTO> ordenesDeInspeccionSelccionadas = new ArrayList<>();

    @GetMapping("/sesion/{id}")
    public Empleado getSesionById(@PathVariable Long id) {
        Sesion sesion = sesionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sesión no encontrada con ID: " + id));
        return buscarEmpleadoLogueado(sesion);
    }

    public Empleado buscarEmpleadoLogueado(Sesion sesion) {
        Empleado empleado = null;
        Usuario usuario = usuarioRepository.findByNombreUsuario(sesion.getUsuario().getNombreUsuario());
        if (usuario == null)
            throw new RuntimeException("Usuario no encontrado");
        if (sesion.conocerUsuario(sesion)){
            empleado = empleadoRepository.findById(usuario.getRILogueado(usuario.getEmpleado()));
        }
        if (empleado == null)
            throw new RuntimeException("Empleado no encontrado");

        return empleado;
    }


    @GetMapping("/ordenes/sesion/{id}")
    public List<OrdenesDeInspeccionDTO> buscarOrdenes(@PathVariable Long id) {
        this.getOrdenesDeInspeccionDTOList().clear();
        Optional<Sesion> sesion = sesionRepository.findById(id);
        Empleado empleado = this.buscarEmpleadoLogueado(sesion.get());
        List<OrdenDeInspeccion> ordenesDeInspecciones = this.ordenDeInspeccionRepository.findAll();
        if (!ordenesDeInspecciones.isEmpty()) {
            for (OrdenDeInspeccion orden : ordenesDeInspecciones) {
                if (orden.getEstado().sosCompletamenteRealizada() && orden.sosEmpleadoLogueado(empleado)) {
                    OrdenesDeInspeccionDTO ordenDTO = new OrdenesDeInspeccionDTO();
                    ordenDTO.setNumeroOrden(orden.getNumeroOrden());
                    ordenDTO.setFechaHoraFinalizacion(orden.getFechaHoraFinalizacion());
                    ordenDTO.getEstacionSismologica().setNombre(orden.getEstacionSismologica().getNombre());
                    List<Sismografo> sismografos = sismografoRepository.findAll();
                    int numerIdentificacion = 0;
                    for (Sismografo s : sismografos) {
                        numerIdentificacion = orden.getEstacionSismologica().obtenerIdentificadorSismografo(s);
                        if (numerIdentificacion != 0) {
                            ordenDTO.getEstacionSismologica().getSismografo().setIdentificadorSismografo(numerIdentificacion);

                        }
                    }
                    ordenesDeInspeccionDTOList.add(ordenDTO);
                }
            }
        }

        this.ordenarXFechaDeFinalizacion(this.ordenesDeInspeccionDTOList);
        return this.getOrdenesDeInspeccionDTOList();
    }


    @PostMapping("/ordenes")
    public ResponseEntity<Map<String, String>> tomarOrdenSelec(
            @RequestBody List<OrdenesDeInspeccionDTO> ordenes) {
        Map<String, String> respuesta = new HashMap<>();
        if (ordenes != null && !ordenes.isEmpty()) {
            respuesta.put("mensaje", "Recibido");
            buscarSelec(ordenes);
        } else {
          }

        return ResponseEntity.ok(respuesta);
    }


    public void ordenarXFechaDeFinalizacion(List<OrdenesDeInspeccionDTO> ordenes) {
        if (!ordenes.isEmpty()) {
            ordenes.sort(Comparator.comparing(OrdenesDeInspeccionDTO::getFechaHoraFinalizacion));
        }
    }

    public List<OrdenesDeInspeccionDTO> getOrdenesDeInspeccionDTOList() {
        return ordenesDeInspeccionDTOList;
    }

    public void setOrdenesDeInspeccionDTOList(List<OrdenesDeInspeccionDTO> ordenesDeInspeccionDTOList) {
        this.ordenesDeInspeccionDTOList = ordenesDeInspeccionDTOList;
    }

    public void buscarSelec(List<OrdenesDeInspeccionDTO> ordenes) {
        System.out.println(ordenes);
          for(OrdenesDeInspeccionDTO orden : ordenes) {
              OrdenDeInspeccion ordenDeInspeccion = this.ordenDeInspeccionRepository.findOrdenDeInspeccionsByNumeroOrden(orden.getNumeroOrden());

              if (ordenDeInspeccion != null) {
                  ordenDeInspeccion.setObservacionCierre(orden.getObservacionCierre());
                  System.out.println(ordenDeInspeccion);
                  ordenDeInspeccionRepository.save(ordenDeInspeccion);
              }

          }



    }

    public void habilitarBajaSismografo(){

    }

}
