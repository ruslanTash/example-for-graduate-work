package ru.skypro.homework.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ad {
    @Id
    private Long pk;
    private String image;
    @Min(0)
    @Max(1000000)
    private Integer price;
    @Size(min = 4, max = 32)
    private String title;
    @Size(min = 8, max = 64)
    private String description;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User user;


}
