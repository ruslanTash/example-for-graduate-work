package ru.skypro.homework.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    private Integer pk;
    private String authorImage;
    private String authorFirstName;
    private long createdAt;
    @Size(min = 8, max = 64)
    private String text;


    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User user;
}
