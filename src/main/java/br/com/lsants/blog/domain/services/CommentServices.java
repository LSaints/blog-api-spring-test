package br.com.lsants.blog.domain.services;

import br.com.lsants.blog.domain.models.Comment;
import br.com.lsants.blog.domain.repositories.CommentRepository;
import br.com.lsants.blog.domain.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServices {

    private final CommentRepository repository;

    public List<Comment> listAll() {
        return repository.findAll();
    }

    public List<Comment> findByPostId(Long id) {
        return repository.findByPostId(id);
    }

    public Comment findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        "Not found entity ID: " + id + ", Type: " + Comment.class.getName()
                ));
    }

    public Comment save(Comment comment) {
        comment.setIssueDate(new Date());
        return repository.save(comment);
    }

    public Comment update(Comment comment) {
        Comment newComment = repository.getById(comment.getId());
        newComment.setUpdateDate(new Date());
        newComment.setContentComment(comment.getContentComment());
        return repository.save(newComment);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Cannot delete this entity in application");
        }
    }

}
