package com.diy.e_commerce_app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JsonProperty("firstname") // Mapare JSON -> Java
    private String firstName;

    @NotNull
    @JsonProperty("lastname") // Mapare JSON -> Java
    private String lastName;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @Email
    @NotNull
    private String email;

    private String role; // Exemplu: "ADMIN" sau "USER"
}
