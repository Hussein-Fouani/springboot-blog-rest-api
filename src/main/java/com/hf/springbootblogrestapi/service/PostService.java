package com.hf.springbootblogrestapi.service;

import com.hf.springbootblogrestapi.DTOS.PostDTO;
import com.hf.springbootblogrestapi.entity.Post;

import java.util.List;

public interface PostService {
    PostDTO creatPost(PostDTO postDTO);

    List<PostDTO> getAllPosts();

    PostDTO getPostbyId(long Id);

}
