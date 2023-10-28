package ru.skypro.homework.dto.ad;

import lombok.Data;


@Data
public class AdDTO {
    private Long author;
    private String image;
    private Long pk;
    private Integer price;
    private String title;
}

