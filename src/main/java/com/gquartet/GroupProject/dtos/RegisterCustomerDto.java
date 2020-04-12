/*
 * Created on 12/04/2020 at 22:08:37 GMT+2
 */
package com.gquartet.GroupProject.dtos;

public class RegisterCustomerDto {

    private String username;
    private String email;
    private String password;
    private String password2;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

}
