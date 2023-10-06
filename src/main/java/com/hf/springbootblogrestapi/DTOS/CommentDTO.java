package com.hf.springbootblogrestapi.DTOS;

import com.hf.springbootblogrestapi.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO { private long id;
    private String name;
    private String body;
    private String email;
    private Post post;

}
