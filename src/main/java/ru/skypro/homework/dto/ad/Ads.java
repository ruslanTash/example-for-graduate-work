package ru.skypro.homework.dto.ad;

import lombok.Data;
import ru.skypro.homework.entity.Ad;

import java.util.List;

@Data

public class Ads {
    private Integer count;
    private List<AdDTO> results;

    public Ads(List<AdDTO> results) {
        this.count = results.size();
        this.results = results;
    }
}
