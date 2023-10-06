package com.hf.springbootblogrestapi.DTOS;

import lombok.Data;

import java.util.Set;

@Data
public class PostDTO {
    private Long Id;
    private String Title;
    private String description ;
    private String content;
    private Set<CommentDTO> comments;
}
