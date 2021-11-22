package com.veterinaria.account.models;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Account {

    @Id
    private String idUsuario;
    private String firstName;
    private String lastName;
    private String correo;
    private String telefono;
    private Date lastChange;

    public Account(String idUsuario, String firstName, String lastName, String correo, String telefono,
            Date lastChange) {
        this.idUsuario = idUsuario;
        this.firstName = firstName;
        this.lastName = lastName;
        this.correo = correo;
        this.telefono = telefono;
        this.lastChange = lastChange;

    }

    public String getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getDate() {
        return this.lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

}
