package pe.edu.cibertec.evaluacionfinal_dawII_springcloud.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class PersonalService {

    @CircuitBreaker(name = "personalService", fallbackMethod = "fallbackErrorPersonal")
    public String verificarPersonas(String nomPersonal) {
        if (nomPersonal.length() > 50) {
            throw new RuntimeException("Fallo en la verificación de seguridad, posible intrusión detectada.");
        }
        return "Persona llamada: " + nomPersonal + " podria ser un intruso, verifique su identidad o informe a un superior sobre la persona.";
    }

    public String fallbackErrorPersonal(String nomPersonal, Throwable t) {
        return "Alerta: No se pudo verificar si la persona está o no dentro de la empresa. " +
                "El nombre de la persona es: " + nomPersonal + ". " +
                "Se ha detectado un posible intento de intrusión. " +
                "Por favor, intente contactarlo o informar a un superior.";
    }
}
