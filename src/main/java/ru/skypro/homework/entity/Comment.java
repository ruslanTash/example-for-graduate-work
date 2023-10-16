package ru.skypro.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    private Integer author;
    private String authorImage;
    private String authorFirstName;
    private long createdAt;

    @Id
    private int pk;
    private String text;
}
