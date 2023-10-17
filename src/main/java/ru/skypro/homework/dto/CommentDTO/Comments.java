package ru.skypro.homework.dto.CommentDTO;

import lombok.Data;
import ru.skypro.homework.entity.Comment;

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
