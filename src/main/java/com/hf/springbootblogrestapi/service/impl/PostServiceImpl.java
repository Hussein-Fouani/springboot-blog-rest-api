package com.hf.springbootblogrestapi.service.impl;

import com.hf.springbootblogrestapi.DTOS.PostDTO;
import com.hf.springbootblogrestapi.entity.Post;
import com.hf.springbootblogrestapi.repository.PostRepository;
import com.hf.springbootblogrestapi.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    PostRepository postRepository;
    @Override
    public PostDTO creatPost(PostDTO postDTO) {
        Post post = maptoEntity(postDTO);
       Post newPost =  postRepository.save(post);
        return maptoDTO(newPost);

    }

    @Override

    public List<PostDTO> getAllPosts() {
        List<Post> list = postRepository.findAll();
        return list.stream().map(this::maptoDTO).collect(Collectors.toList());

    }

    @Override
    public PostDTO getPostbyId(Long Id) {
        PostDTO postDTO= postRepository.findById(Id).stream().map(this::maptoDTO).collect(Collectors.toList());
    }

    private PostDTO maptoDTO(Post post){//map entity to dto
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setTitle(post.getTitle());
        postDTO.setDescription(post.getDescription());
        postDTO.setContent(post.getContent());
        return postDTO;
    }
    private Post maptoEntity(PostDTO postDTO){ //map dto to entity
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
        return post;
    }
}
