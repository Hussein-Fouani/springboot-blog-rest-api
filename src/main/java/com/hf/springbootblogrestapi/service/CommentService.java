package com.hf.springbootblogrestapi.service;

import com.hf.springbootblogrestapi.DTOS.CommentDTO;
import com.hf.springbootblogrestapi.entity.Comment;

import java.util.List;

public interface CommentService {
    CommentDTO createComment(CommentDTO comment, long id);

    List<CommentDTO> getCommentsByPostId(long id);

    CommentDTO getCommentByID(Long postId,Long commentId);

    CommentDTO updateComment(Long postId,Long commentId,CommentDTO commentRequest);

    void deleteComment(Long postId,Long commentId);
}
