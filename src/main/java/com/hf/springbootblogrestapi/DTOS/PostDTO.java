package com.hf.springbootblogrestapi.DTOS;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Set;

@Data
public class PostDTO {
    private Long Id;
    @NotEmpty
    @Size(min = 4,message = "Post Title Should have at least 4 Characters")
    private String Title;
    @NotEmpty
    @Size(min = 10,message = "Post Title Should have at least 4 Characters")
    private String description ;
    @NotEmpty
    private String content;
    private Set<CommentDTO> comments;
}
