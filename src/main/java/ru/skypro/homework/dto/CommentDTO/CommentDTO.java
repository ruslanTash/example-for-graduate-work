package ru.skypro.homework.dto.CommentDTO;

import lombok.Data;


@Data

public class CommentDTO {
    private Integer author;
    private String authorImage;
    private String authorFirstName;
    private long createdAt;
    private int pk;
    private String text;
}