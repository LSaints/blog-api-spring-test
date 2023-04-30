package br.com.lsants.blog.api.mappers;

import br.com.lsants.blog.api.requests.CommentRequestBody;
import br.com.lsants.blog.domain.models.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentRequestBody toCommentRequestBody(Comment comment);
    List<CommentRequestBody> toCommentRequestBodies(List<Comment> comments);
    Comment toComment(CommentRequestBody commentRequestBody);
}
