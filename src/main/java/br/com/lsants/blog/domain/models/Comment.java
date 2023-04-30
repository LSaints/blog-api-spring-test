package br.com.lsants.blog.domain.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static br.com.lsants.blog.domain.models.Comment.TABLE_NAME;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_NAME)
@Data
public class Comment extends AbstractEntity {
    public static final String TABLE_NAME = "comment";

    @Column(name = "comment_content", length = 255)
    private String contentComment;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;
}
