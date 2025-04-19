package futuro.sirena;

import core.Notificacion;
import core.NotificacionFactory;

public class SirenaNotificacionFactory implements NotificacionFactory {

    @Override
    public Notificacion crearNotificacion(String destinatario, String mensaje) {
        return new SirenaNotificacion(destinatario, mensaje);
    }
}
