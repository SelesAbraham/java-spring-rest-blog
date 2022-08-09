package com.pluralsight.blog.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.pluralsight.blog.model.Post;

@RestResource
public interface PostRepository extends JpaRepository<Post, Long> {

  // takes string and returns list
  // run the BlogAPplication.java class and go to https://localhost:8080/posts/search
  // http://localhost:8080/posts/search/findByTitleContaining?title=Smart
  // we can see all of the posts
  // annotations helps to serach with shortURL
  // e.g:http://localhost:8080/posts/search/containsTitle?title=Smart.

  @RestResource(rel = "contains-title", path = "containsTitle")
  public List<Post> findByTitleContaining(String title);
}
