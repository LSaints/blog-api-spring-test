package br.com.lsants.blog.api.controllers;

import br.com.lsants.blog.api.mappers.PostMapper;
import br.com.lsants.blog.api.requests.PostRequestBody;
import br.com.lsants.blog.domain.models.Post;
import br.com.lsants.blog.domain.services.PostServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostServices services;
    private final PostMapper mapper;

    @GetMapping
    public ResponseEntity<List<PostRequestBody>> findAll() {
        return new ResponseEntity<>(mapper.toPostRequestBodies(services.findAll()), HttpStatus.OK);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<List<PostRequestBody>> findByUserId(@PathVariable Long id) {
        return new ResponseEntity<>(mapper.toPostRequestBodies(services.findByUserId(id)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostRequestBody> findById(@PathVariable Long id) {
        return new ResponseEntity<>(mapper.toPostRequestBody(services.findById(id)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Post> save(@RequestBody PostRequestBody postRequestBody) {
        return new ResponseEntity<>(services.save(
                mapper.toPost(postRequestBody)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@RequestBody PostRequestBody postRequestBody, @PathVariable Long id) {
        postRequestBody.setId(id);
        return new ResponseEntity<>(services.update(mapper.toPost(postRequestBody)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        PostRequestBody postRequestBody = mapper.toPostRequestBody(services.findById(id));
        services.delete(postRequestBody.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
