package br.com.lsants.blog.api.requests;

import br.com.lsants.blog.domain.models.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestBody extends AbstractEntity {


    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}
