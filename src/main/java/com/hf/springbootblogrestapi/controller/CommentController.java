package com.hf.springbootblogrestapi.controller;

import com.hf.springbootblogrestapi.DTOS.CommentDTO;
 import com.hf.springbootblogrestapi.service.CommentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class CommentController {

    private CommentService commentService;

    @PostMapping("posts/{postId}/comment")
    public ResponseEntity<CommentDTO> createComment(@PathVariable long postId,@Valid @RequestBody  CommentDTO commentDTO){
        return new ResponseEntity<>(commentService.createComment(commentDTO,postId), HttpStatus.CREATED);
    }

    @GetMapping("posts/{postId}/comment")
    public List<CommentDTO> getCommentsByPostId(@PathVariable Long postId){
        return commentService.getCommentsByPostId(postId);
    }
    @GetMapping("posts/{postId}/comment/{commentId}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Long postId,@PathVariable Long commentId){
        CommentDTO commentDTO = commentService.getCommentByID(postId,commentId);
        return new ResponseEntity<>(commentDTO,HttpStatus.OK);
    }

    @PutMapping("posts/{postId}/comment/{commentId}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long postId,@PathVariable Long commentId,@Valid @RequestBody CommentDTO commentDTO){
        CommentDTO commentDTO1 =commentService.updateComment(postId,commentId,commentDTO);
        return new ResponseEntity<>(commentDTO1,HttpStatus.OK);
    }

    @DeleteMapping("posts/{postId}/comment/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long postId,@PathVariable Long commentId){
        commentService.deleteComment(postId,commentId);
         return new  ResponseEntity<>("comment Deleted Successfully",HttpStatus.OK);
    }

}
