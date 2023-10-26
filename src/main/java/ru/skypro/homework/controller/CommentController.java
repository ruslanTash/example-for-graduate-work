package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.comment.Comments;
import ru.skypro.homework.dto.comment.CreateOrUpdateComment;
import ru.skypro.homework.entity.Comment;

@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CommentController {
//    private final CommentService commentService;

    @GetMapping("/{id}/comments")
    public Comments getComments(Authentication authentication, @PathVariable int id) {
//        return commentService.getComments(authentication, id);
        return null;
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