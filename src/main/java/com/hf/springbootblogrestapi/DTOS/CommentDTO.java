package com.hf.springbootblogrestapi.DTOS;

import com.hf.springbootblogrestapi.entity.Post;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private long id;
    @NotEmpty
    @Size(max = 255,min = 5 ,message = "Name should be between 5 and 255 characters")
    private String name;
    @NotEmpty
    @Size(max = 255,min = 10 ,message = "Body should be between 10 and 255 characters")
    private String body;
    @NotEmpty
    @Email
    @Size(max = 255,message = "Email shouldn't exceed 255 characters")
    private String email;
    private Post post;

}
