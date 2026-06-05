package cl.unaccess.notificaciones.controller;

import cl.unaccess.notificaciones.model.Notificacion;
import cl.unaccess.notificaciones.dto.NotificacionDTO;
import cl.unaccess.notificaciones.service.NotificacionService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notificaciones")
public class NotificacionController {

    private final NotificacionService service;

    public NotificacionController(NotificacionService service) {
        this.service = service;
    }

   
    @PostMapping
    public ResponseEntity<Notificacion> crear(@RequestBody NotificacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.enviarNotificacion(dto));
    }

    
    @GetMapping("/paciente/{rut}")
    public ResponseEntity<List<Notificacion>> listarPorPaciente(@PathVariable String rut) {
        return ResponseEntity.ok(service.listarPorPaciente(rut));
    }
}