package com.api.employee.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //General validations for name added here
    @NotNull(message = "message should not be empty")
    @NotBlank(message = "name should not be blank")
    @Size(min=1, max = 5, message = "min size should be 1 and max 5")
    @Pattern(regexp = "^[A-Z].*", message = "Must start with a capital letter")
    private String name;

    //using custom validations for password here
    private String password;
}

