package ru.skypro.homework.entity;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    private Long pk;
//    private String authorImage;
//    private String authorFirstName;
//    private long createdAt;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Size(min = 8, max = 64)
    private String text;


    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "ad_id", nullable = false)
    private Ad ad;
}
