package cl.unaccess.notificaciones.service;

import cl.unaccess.notificaciones.model.Notificacion;
import cl.unaccess.notificaciones.dto.NotificacionDTO;
import cl.unaccess.notificaciones.repository.NotificacionRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificacionService {

    private final NotificacionRepository repo;

    public NotificacionService(NotificacionRepository repo) {
        this.repo = repo;
    }

    public Notificacion enviarNotificacion(NotificacionDTO dto) {
        Notificacion n = new Notificacion();
        n.setPacienteRut(dto.getPacienteRut());
        n.setMensaje(dto.getMensaje());
        n.setTipoCanal(dto.getTipoCanal().toUpperCase());
        n.setFechaEnvio(LocalDateTime.now()); 
        return repo.save(n);
    }

    public List<Notificacion> listarPorPaciente(String rut) {
        return repo.findByPacienteRut(rut);
    }
}