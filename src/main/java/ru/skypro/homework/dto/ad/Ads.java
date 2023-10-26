package ru.skypro.homework.dto.ad;

import lombok.Data;
import ru.skypro.homework.entity.Ad;

import java.util.List;

@Data

public class Ads {
    private int count;
    private List<Ad> results;

    public Ads(List<Ad> results) {
        this.count = results.size();
        this.results = results;
    }
}
