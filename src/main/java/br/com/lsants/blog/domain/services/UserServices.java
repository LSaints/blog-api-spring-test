package br.com.lsants.blog.domain.services;

import br.com.lsants.blog.domain.models.User;
import br.com.lsants.blog.domain.repositories.UserRepository;
import br.com.lsants.blog.domain.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServices {

    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        "User not found ID: " + id + ", Type: " + User.class.getName()
                ));
    }

    public User save(User user) {
        user.setIssueDate(new Date());
        return repository.save(user);
    }

    public User update(User user) {
        User newUser = findById(user.getId());
        newUser.setUpdateDate(new Date());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        return repository.save(newUser);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Cannot delete this entity in application");
        }
    }
}
