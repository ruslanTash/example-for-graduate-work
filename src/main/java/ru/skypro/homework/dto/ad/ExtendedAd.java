package ru.skypro.homework.dto.ad;

import lombok.Data;

@Data
public class ExtendedAd {
    private Long pk;
    private String authorFirstName;
    private String authorLastName;
    private String description;
    private String login;
    private String image;
    private String phone;
    private Integer price;
    private String title;
}
