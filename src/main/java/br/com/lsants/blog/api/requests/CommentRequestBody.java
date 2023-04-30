package br.com.lsants.blog.api.requests;

import br.com.lsants.blog.domain.models.AbstractEntity;
import br.com.lsants.blog.domain.models.Post;
import br.com.lsants.blog.domain.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestBody extends AbstractEntity {

    private String contentComment;
    private Post post;
    private User author;
}
