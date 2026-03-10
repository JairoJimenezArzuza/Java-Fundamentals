package com.jairo.poo.OmnichannelNotificationSystem;

abstract class Notificacion{
    private String destinario;
    private String mensaje;

    public Notificacion(String destinario, String mensaje) {
        if(mensaje == null) 
            throw new IllegalArgumentException("El mensaje no puede ser nulo");

        if(destinario == null)
            throw new IllegalArgumentException("El destinario no puede ser nulo");

        this.destinario = destinario;
        this.mensaje = mensaje;
    }
    
    public String mostrarLog(){
        return "Enviando Mensaje a...";
    }
    public abstract String enviar();

    public String getDestinario() {
        return destinario;
    }

    public String getMensaje() {
        return mensaje;
    }
    
}