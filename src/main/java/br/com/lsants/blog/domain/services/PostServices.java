package br.com.lsants.blog.domain.services;

import br.com.lsants.blog.domain.models.Post;
import br.com.lsants.blog.domain.repositories.PostRepository;
import br.com.lsants.blog.domain.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServices {

    private final PostRepository repository;

    public List<Post> findAll() { return repository.findAll(); }

    public List<Post> findByUserId(Long id) {
        return repository.findByAuthorId(id);
    }

    public Post findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        "Post not found ID: " + id + ", Type: " + Post.class
                ));
    }

    public Post save(Post post) {
        post.setIssueDate(new Date());
        return repository.save(post);
    }

    public Post update(Post post) {
        Post newPost = findById(post.getId());
        newPost.setUpdateDate(new Date());
        newPost.setTitle(post.getTitle());
        newPost.setPostContent(post.getPostContent());
        return repository.save(newPost);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Cannot delete this entity in application");
        }
    }

}
