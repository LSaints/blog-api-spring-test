package br.com.lsants.blog.api.mappers;

import br.com.lsants.blog.api.requests.PostRequestBody;
import br.com.lsants.blog.domain.models.Post;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostMapper INSTANCE =  Mappers.getMapper(PostMapper.class);

    PostRequestBody toPostRequestBody(Post post);

    List<PostRequestBody> toPostRequestBodies(List<Post> posts);

    @InheritInverseConfiguration
    Post toPost(PostRequestBody postRequestBody);
}
