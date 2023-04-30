package br.com.lsants.blog.api.requests;

import br.com.lsants.blog.domain.models.AbstractEntity;
import br.com.lsants.blog.domain.models.Comment;
import br.com.lsants.blog.domain.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostRequestBody extends AbstractEntity {

    private String title;
    private String postContent;
    private User author;
    private List<Comment> comments;
}
