package com.example.jpa.dto;

import com.example.jpa.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class PostResponseDTO {
    private Integer id;
    private String title;
    private String content;
    private String writerUsername;

    public PostResponseDTO(PostEntity post) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writerUsername = writerUsername;
    }
}
