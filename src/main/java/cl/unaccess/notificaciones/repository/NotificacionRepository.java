package cl.unaccess.notificaciones.repository;

import cl.unaccess.notificaciones.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    List<Notificacion> findByPacienteRut(String pacienteRut);
}