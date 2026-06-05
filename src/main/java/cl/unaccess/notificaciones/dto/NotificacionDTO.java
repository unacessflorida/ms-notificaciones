package cl.unaccess.notificaciones.dto;

public class NotificacionDTO {
    private String pacienteRut;
    private String mensaje;
    private String tipoCanal;

    public NotificacionDTO() {}

    public String getPacienteRut() { return pacienteRut; }
    public void setPacienteRut(String pacienteRut) { this.pacienteRut = pacienteRut; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getTipoCanal() { return tipoCanal; }
    public void setTipoCanal(String tipoCanal) { this.tipoCanal = tipoCanal; }
}