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
//    id автора комментария
    private Integer author;

//    ссылка на аватар автора комментария
    private String authorImage;

//    имя создателя комментария
    private String authorFirstName;

//    дата и время создания комментария в миллисекундах с 00:00:00 01.01.1970
    private long createdAt;

    @Id
//    id комментария
    private int pk;

//    текст комментария
    private String text;
}
