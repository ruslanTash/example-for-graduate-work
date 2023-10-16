package ru.skypro.homework.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ad {
    private Integer author;
    private String image;
    @Id
    private Integer pk;
    private int price;
    private String title;
}
