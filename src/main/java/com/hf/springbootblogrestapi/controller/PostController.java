package com.hf.springbootblogrestapi.controller;


import com.hf.springbootblogrestapi.DTOS.PostDTO;
import com.hf.springbootblogrestapi.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@AllArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
    private static final String API_POST_PATH ="/api/posts";

    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){
        return   new ResponseEntity<>(postService.creatPost(postDTO), HttpStatus.CREATED);

    }
}
