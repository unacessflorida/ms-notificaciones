package cl.unaccess.notificaciones.controller;

import cl.unaccess.notificaciones.model.Notificacion;
import cl.unaccess.notificaciones.dto.NotificacionDTO;
import cl.unaccess.notificaciones.service.NotificacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notificaciones")
@Tag(name = "Notificaciones", description = "Gestion de notificaciones a pacientes")
public class NotificacionController {

    private final NotificacionService service;

    public NotificacionController(NotificacionService service) {
        this.service = service;
    }

    @Operation(summary = "Enviar una notificacion a un paciente")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Notificacion enviada",
            content = @Content(examples = @ExampleObject(value = "{\"pacienteRut\":\"12345678-9\",\"mensaje\":\"Recordatorio de cita\",\"tipoCanal\":\"sms\"}")))
    })
    @PostMapping
    public ResponseEntity<Notificacion> crear(@RequestBody NotificacionDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.enviarNotificacion(dto));
    }

    @Operation(summary = "Listar notificaciones de un paciente por su RUT")
    @ApiResponse(responseCode = "200", description = "Lista de notificaciones del paciente")
    @GetMapping("/paciente/{rut}")
    public ResponseEntity<List<Notificacion>> listarPorPaciente(@PathVariable String rut) {
        return ResponseEntity.ok(service.listarPorPaciente(rut));
    }
}