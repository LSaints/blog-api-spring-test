package br.com.lsants.blog.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static br.com.lsants.blog.domain.models.User.TABLE_NAME;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_NAME)
@Data
public class User extends AbstractEntity {
    public static final String TABLE_NAME = "user";

    @Column(name = "username", unique = true, length = 100, nullable = false)
    @NotEmpty
    @NotNull
    @Size(min = 2, max = 100)
    public String username;

    @Column(name = "password", unique = false, length = 60, nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotEmpty
    @NotNull
    @Size(min = 8, max = 60)
    public String password;
}
