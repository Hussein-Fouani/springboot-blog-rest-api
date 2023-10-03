package com.hf.springbootblogrestapi.DTOS;

import lombok.Data;

@Data
public class PostDTO {
    private Long Id;
    private String Title;
    private String description ;
    private String content;
}
