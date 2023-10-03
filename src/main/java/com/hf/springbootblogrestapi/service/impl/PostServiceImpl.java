package com.hf.springbootblogrestapi.service.impl;

import com.hf.springbootblogrestapi.DTOS.PostDTO;
import com.hf.springbootblogrestapi.entity.Post;
import com.hf.springbootblogrestapi.repository.PostRepository;
import com.hf.springbootblogrestapi.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    PostRepository postRepository;
    @Override
    public PostDTO creatPost(PostDTO postDTO) {
        Post post = new Post();
        post.setContent(postDTO.getContent());
        post.setTitle(post.getTitle());
        post.setDescription(postDTO.getDescription());
         postRepository.save(post);
        PostDTO postDTO1 = new PostDTO();
        postDTO1.setId(post.getId());
        postDTO1.setContent(post.getContent());
        postDTO1.setTitle(post.getTitle());
        postDTO1.setDescription(post.getDescription());
        return postDTO1;
    }
}
