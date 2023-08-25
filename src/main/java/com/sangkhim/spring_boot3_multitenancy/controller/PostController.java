package com.sangkhim.spring_boot3_multitenancy.controller;

import com.sangkhim.spring_boot3_multitenancy.model.dto.PostDTO;
import com.sangkhim.spring_boot3_multitenancy.model.entity.Post;
import com.sangkhim.spring_boot3_multitenancy.service.PostService;
import com.sangkhim.spring_boot3_multitenancy.utils.PageUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class PostController {

  private final PostService service;

  @GetMapping("/v1/posts")
  public ResponseEntity<Page<Post>> getAllPosts(
      Pageable pageable, @RequestParam(required = false) String title) {

    Page<Post> list = service.getAllPosts(PageUtils.pageable(pageable), title);
    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  @GetMapping("/v1/posts/{id}")
  public ResponseEntity<Post> getPostById(@PathVariable("id") Long id) {
    Post entity = service.getById(id);
    return new ResponseEntity<>(entity, HttpStatus.OK);
  }

  @PostMapping("/v1/posts")
  public ResponseEntity<Post> createOrUpdate(@Valid @RequestBody PostDTO postDTO) {
    Post updated = service.createOrUpdate(postDTO);
    return new ResponseEntity<>(updated, HttpStatus.OK);
  }

  @DeleteMapping("/v1/posts/{id}")
  public void deleteById(@PathVariable("id") Long id) {
    service.deleteById(id);
  }
}
