package com.hf.springbootblogrestapi.controller;


import com.hf.springbootblogrestapi.DTOS.PostDTO;
import com.hf.springbootblogrestapi.DTOS.PostResponse;
import com.hf.springbootblogrestapi.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@AllArgsConstructor
@RequestMapping("/api/posts/")
public class PostController {

    private PostService postService;

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){
        return   new ResponseEntity<>(postService.creatPost(postDTO), HttpStatus.CREATED);

    }
    @GetMapping
    public PostResponse getallposts(@RequestParam(value = "pageNo",required = false,defaultValue = "0") int pageNo,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize,
                                    @RequestParam(value = "sortBy",required = false,defaultValue = "id")String sortBy){
        return postService.getAllPosts(pageNo,pageSize,sortBy);
    }
    @GetMapping("{Id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable(name = "Id") long Id){
        return ResponseEntity.ok(postService.getPostbyId(Id));
    }
    @PutMapping("{Id}")
    public ResponseEntity<PostDTO> updatePostbyId(@RequestBody  PostDTO postDTO,@PathVariable long Id){
        PostDTO postDTO1 = postService.UpdatePostById(Id,postDTO);
        return new ResponseEntity<>(postDTO1,HttpStatus.OK);
    }

    @DeleteMapping("{Id}")
    public ResponseEntity<String> deletebyId(@PathVariable("Id") long Id){
        postService.deletePost(Id);
        return new ResponseEntity<>("Post Entity was successfully Deleted",HttpStatus.OK);
    }

}
