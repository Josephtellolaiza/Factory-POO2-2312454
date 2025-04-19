package core;

import canales.email.EmailNotificacionFactory;
import canales.push.PushNotificacionFactory;
import canales.sms.SMSNotificacionFactory;
import canales.voz.VozNotificacionFactory;

import futuro.sirena.SirenaNotificacionFactory;
import futuro.whatsapp.WhatsAppNotificacionFactory;


import java.util.HashMap;
import java.util.Map;

public class Notificador {
    private final Map<String, NotificacionFactory> factoryMap = new HashMap<>();

    public Notificador() {
        factoryMap.put("EMAIL", new EmailNotificacionFactory());
        factoryMap.put("SMS", new SMSNotificacionFactory());
        factoryMap.put("PUSH", new PushNotificacionFactory());
        factoryMap.put("VOZ", new VozNotificacionFactory());

        factoryMap.put("SIRENA", new SirenaNotificacionFactory());
        factoryMap.put("WHATSAPP", new WhatsAppNotificacionFactory());


        
    }

    public void registrarCanal(String tipo, NotificacionFactory factory) {
        factoryMap.put(tipo.toUpperCase(), factory);
    }

    public void enviarNotificacion(String tipo, String destinatario, String mensaje) {
        NotificacionFactory factory = factoryMap.get(tipo.toUpperCase());

        if (factory == null) {
            throw new IllegalArgumentException("Tipo de notificación desconocido: " + tipo);
        }

        Notificacion notificacion = factory.crearNotificacion(destinatario, mensaje);
        notificacion.enviar();
    }


}
