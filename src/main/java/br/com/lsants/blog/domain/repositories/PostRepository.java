package br.com.lsants.blog.domain.repositories;

import br.com.lsants.blog.domain.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthorId(Long id);
}
