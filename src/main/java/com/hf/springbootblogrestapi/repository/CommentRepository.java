package com.hf.springbootblogrestapi.repository;

import com.hf.springbootblogrestapi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findPostById(long postId);
}
