package br.com.lsants.blog.api.mappers;

import br.com.lsants.blog.api.requests.UserRequestBody;
import br.com.lsants.blog.domain.models.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserRequestBody toUserRequestBody(User user);
    List<UserRequestBody> toUserRequestBodies(List<User> users);


    @InheritInverseConfiguration
    User toUser(UserRequestBody userRequestBody);

}
