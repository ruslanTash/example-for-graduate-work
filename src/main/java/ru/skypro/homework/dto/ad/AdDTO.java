package ru.skypro.homework.dto.ad;

import lombok.Data;


@Data
public class AdDTO {
    private Integer author;
    private String image;
    private Integer pk;
    private int price;
    private String title;
}

