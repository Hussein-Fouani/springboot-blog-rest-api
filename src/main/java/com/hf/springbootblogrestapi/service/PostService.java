package com.hf.springbootblogrestapi.service;

import com.hf.springbootblogrestapi.DTOS.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO creatPost(PostDTO postDTO);

    List<PostDTO> getAllPosts();

    PostDTO getPostbyId(long Id);

    PostDTO UpdatePostById(long id, PostDTO postDTO);

    void deletePost(long id);

}
