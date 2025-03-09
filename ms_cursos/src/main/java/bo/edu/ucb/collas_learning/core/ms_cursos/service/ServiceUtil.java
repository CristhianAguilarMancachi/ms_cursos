package bo.edu.ucb.collas_learning.core.ms_cursos.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceUtil {

    @Value("${server.port}")
    private String port;

    public String getServiceAddress() {
        // Se asume que el servicio se ejecuta en localhost.
        return "http://localhost:" + port;
    }
}
