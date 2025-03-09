package bo.edu.ucb.collas_learning.core.ms_cursos.dto;

import java.security.Timestamp;

public class UsuarioDTO {
    private int codUsuario;
    private String nombreUsuario;
    private String email;
    private String contrasena;
    private String rol;
    private Timestamp createdAt;

    // Constructor
    public UsuarioDTO(int codUsuario, String nombreUsuario, String email, String contrasena, String rol, Timestamp createdAt) {
        this.codUsuario = codUsuario;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.contrasena = contrasena;
        this.rol = rol;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}