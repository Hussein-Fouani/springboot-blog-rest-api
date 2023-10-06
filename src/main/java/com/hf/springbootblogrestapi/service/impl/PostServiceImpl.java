package com.hf.springbootblogrestapi.service.impl;

import com.hf.springbootblogrestapi.DTOS.PostDTO;
import com.hf.springbootblogrestapi.DTOS.PostResponse;
import com.hf.springbootblogrestapi.entity.Post;
import com.hf.springbootblogrestapi.exception.ResourceNotFoundException;
import com.hf.springbootblogrestapi.repository.PostRepository;
import com.hf.springbootblogrestapi.service.PostService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    PostRepository postRepository;
    private ModelMapper modelMapper;
    @Override
    public PostDTO creatPost(PostDTO postDTO) {
        Post post = mapToEntity(postDTO);
       Post newPost =  postRepository.save(post);
        return mapToDTO(newPost);

    }

    @Override

    public PostResponse getAllPosts(int pageNo, int pageSize,String sortBy,String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);
        Page<Post> list = postRepository.findAll(pageable);
        List<Post> listofPosts = list.getContent();
        List<PostDTO> content = listofPosts.stream().map(this::mapToDTO).collect(Collectors.toList());
        PostResponse  postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(list.getNumber());
        postResponse.setPageSize(list.getSize());
        postResponse.setTotalElements(list.getTotalElements());
        postResponse.setTotalPages(list.getTotalPages());
        return postResponse;
    }

    @Override
    public PostDTO getPostbyId(long Id) {
        Post post = postRepository.findById(Id).orElseThrow(()->
            new ResourceNotFoundException("Post","Id",Id))  ;
        return mapToDTO(post);
    }

    @Override
    public PostDTO UpdatePostById(long id, PostDTO postDTO) {
        Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setDescription(post.getDescription());

       Post post1 = postRepository.save(post);
         return mapToDTO(post1);
    }

    @Override
    public void deletePost(long id) {
        Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
        postRepository.deleteById(id);
    }

    private PostDTO mapToDTO(Post post){//map entity to dto
        return modelMapper.map(post,PostDTO.class);

    }
    private Post mapToEntity(PostDTO postDTO){ //map dto to entity
        return modelMapper.map(postDTO,Post.class);
    }
}
