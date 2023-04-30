package br.com.lsants.blog.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

import static br.com.lsants.blog.domain.models.Post.TABLE_NAME;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_NAME)
@Data
public class Post extends AbstractEntity {
    public static final String TABLE_NAME = "post";

    @Column(name = "title", nullable = false, length = 100)
    @NotEmpty
    @NotEmpty
    @Size(min = 10, max = 100)
    private String title;

    @Column(name = "post_content", nullable = false, length = 1000)
    @NotEmpty
    @NotEmpty
    @Size(min = 10, max = 100)
    private String postContent;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

}