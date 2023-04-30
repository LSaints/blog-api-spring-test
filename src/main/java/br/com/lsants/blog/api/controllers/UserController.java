package br.com.lsants.blog.api.controllers;

import br.com.lsants.blog.api.mappers.UserMapper;
import br.com.lsants.blog.api.requests.UserRequestBody;
import br.com.lsants.blog.domain.models.User;
import br.com.lsants.blog.domain.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServices services;
    private final UserMapper mapper;

    @GetMapping
    public ResponseEntity<List<UserRequestBody>> findAll() {
        return new ResponseEntity<>(mapper.toUserRequestBodies(services.findAll()),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRequestBody> findById(@PathVariable Long id){
        return new ResponseEntity<>(mapper.toUserRequestBody(services.findById(id)), HttpStatus.OK);
    }

   @PostMapping
   public ResponseEntity<User> save(@RequestBody UserRequestBody userRequestBody) {
        return new ResponseEntity<>(services.save(
                mapper.toUser(userRequestBody)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserRequestBody userRequestBody, @PathVariable Long id) {
        userRequestBody.setId(id);
        return new ResponseEntity<>(services.update(
                mapper.toUser(userRequestBody)), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        UserRequestBody userRequestBody = mapper.toUserRequestBody(services.findById(id));
        services.delete(userRequestBody.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
