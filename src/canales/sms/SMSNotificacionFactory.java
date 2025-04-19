package canales.sms;

import core.Notificacion;
import core.NotificacionFactory;

public class SMSNotificacionFactory implements NotificacionFactory {

    @Override
    public Notificacion crearNotificacion(String destinatario, String mensaje) {
        return new SMSNotificacion(destinatario, mensaje);
    }
}
