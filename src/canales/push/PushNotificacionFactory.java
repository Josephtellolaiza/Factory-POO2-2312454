package canales.push;

import core.Notificacion;
import core.NotificacionFactory;

public class PushNotificacionFactory implements NotificacionFactory {

    @Override
    public Notificacion crearNotificacion(String destinatario, String mensaje) {
        return new PushNotificacion(destinatario, mensaje);
    }
}
