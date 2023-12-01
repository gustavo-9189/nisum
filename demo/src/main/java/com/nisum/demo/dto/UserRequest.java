package com.nisum.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import lombok.Data;

@Data
public class UserRequest {

    @NotNull(message = "El campo name es requerido")
    @NotBlank(message = "El campo name no puede estar vacio")
    private String name;

    @NotNull(message = "El campo email es requerido")
    @NotBlank(message = "El campo email no puede estar vacio")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "El email no tiene un formato correcto")
    private String email;

    @NotNull(message = "El campo password es requerido")
    @NotBlank(message = "El campo password no puede estar vacio")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "El password tiene un formato incorrecto")
    private String password;

    private List<PhoneRequest> phones;
}
