package com.example.day17.Moudle;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @NotNull(message = "name can not be null ")
    @Size(min = 5,message = "name can not be less than 5 ")
    private String name;
    @Size(min=5,message = "username can not be less than 5")
    @NotNull(message = "username can not be null")
    @Column(columnDefinition = "varchar(8) not null unique")
    private String username;
    @NotNull(message = "password can not be null ")
    private String password;
    @NotNull(message ="email can not be null " )
    @Email(message = "email is not valid ")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotNull(message = "role can not be null ")
    @Pattern(regexp = "\\b(user|admin)\\b",message = "role must be user or admin only")
    private String role;
    @NotNull(message ="age can not be null " )
    private int age;

}
