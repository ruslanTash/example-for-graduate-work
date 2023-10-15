package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.service.CommentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CommentController {
//    private final CommentService commentService;

    @GetMapping("/{id}/comments")
    public Comments getComments(Authentication authentication, @PathVariable int id) {
        var CommentListList = List.of(
                new Comment(2, "Avatar", "Ivan", 100000, 10, "Слишком дёшево")
        );
        return new Comments((ArrayList<Comment>) CommentListList);
//        return commentService.getComments(authentication, id);
    }

    @PostMapping("/{id}/comments")
    public Comment addComment(Authentication authentication, @PathVariable int id, @RequestBody CreateOrUpdateComment createOrUpdateComment) {
//        return commentService.addComment(authentication, id, createOrUpdateComment);
        return null;
    }

    @DeleteMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<Comment> deleteComment(Authentication authentication, @PathVariable int adId, @PathVariable int commentId) {
//        return commentService.deleteComment(authentication, adId, commentId);
        return null;
    }

    @PatchMapping("/{adId}/comments/{commentId}")
    public Comment updateComment(Authentication authentication, @PathVariable int adId, @PathVariable int commentId, @RequestBody CreateOrUpdateComment createOrUpdateComment) {
//        return commentService.updateComment(authentication, adId, commentId, createOrUpdateComment);
        return null;
    }
}