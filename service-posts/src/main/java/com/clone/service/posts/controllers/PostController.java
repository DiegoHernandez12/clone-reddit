package com.clone.service.posts.controllers;

import com.clone.service.posts.dtos.PostDTO;
import com.clone.service.posts.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDTO>> findAll(){
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(postService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PostDTO> create(@RequestBody PostDTO postDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.create(postDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> update(@PathVariable("id")Long id,
                                          @RequestBody PostDTO postDTO){
        return ResponseEntity.ok(postService.update(id,postDTO));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Long id) {postService.delete(id);}

}
