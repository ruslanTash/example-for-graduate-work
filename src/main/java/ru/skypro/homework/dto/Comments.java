package ru.skypro.homework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Comments {
    private int count;
    private ArrayList<Comment> results;

    public Comments(ArrayList<Comment> results) {
        this.results = results;
        this.count = results.size();
    }
}
