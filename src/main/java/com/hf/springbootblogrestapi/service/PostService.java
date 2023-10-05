package com.hf.springbootblogrestapi.service;

import com.hf.springbootblogrestapi.DTOS.PostDTO;
import com.hf.springbootblogrestapi.DTOS.PostResponse;

public interface PostService {
    PostDTO creatPost(PostDTO postDTO);

    PostResponse getAllPosts(int pageNo, int pageSize,String sortBy,String sortDir);

    PostDTO getPostbyId(long Id);

    PostDTO UpdatePostById(long id, PostDTO postDTO);

    void deletePost(long id);

}
