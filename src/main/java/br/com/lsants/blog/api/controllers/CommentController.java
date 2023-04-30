package br.com.lsants.blog.api.controllers;

import br.com.lsants.blog.api.mappers.CommentMapper;
import br.com.lsants.blog.api.requests.CommentRequestBody;
import br.com.lsants.blog.domain.models.Comment;
import br.com.lsants.blog.domain.services.CommentServices;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentServices services;
    private final CommentMapper mapper;

    @GetMapping
    public ResponseEntity<List<CommentRequestBody>> listAll() {
        return new ResponseEntity<>(mapper.toCommentRequestBodies(services.listAll()), HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<List<CommentRequestBody>> findByPostId(@PathVariable Long id) {
        return new ResponseEntity<>(mapper.toCommentRequestBodies(services.findByPostId(id)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentRequestBody> findById(@PathVariable Long id) {
        return new ResponseEntity<>(mapper.toCommentRequestBody(services.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Comment> save(@RequestBody CommentRequestBody commentRequestBody) {
        return new ResponseEntity<>(services.save(mapper.toComment(commentRequestBody)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> update(@RequestBody CommentRequestBody commentRequestBody, @PathVariable Long id) {
        commentRequestBody.setId(id);
        return new ResponseEntity<>(services.update(
                mapper.toComment(commentRequestBody)), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        CommentRequestBody commentRequestBody = mapper.toCommentRequestBody(services.findById(id));
        services.delete(commentRequestBody.getId());
        return new ResponseEntity<>((HttpStatus.NO_CONTENT));
    }
}
