package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.comment.Comments;
import ru.skypro.homework.dto.comment.CreateOrUpdateComment;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.service.CommentService;

@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CommentController {
    private final CommentService commentService;

    //Получение комментариев объявления
    @GetMapping("/{id}/comments")
    public Comments getComments(@PathVariable("id") Long adId) {
        return commentService.getComments(adId);
    }

    //Добавление комментария к объявлению
    @PostMapping("/{id}/comments")
    public void addComment(@PathVariable("id") Long adId,
                           @RequestBody CreateOrUpdateComment createOrUpdateComment,
                           Authentication authentication) {
        commentService.addComment(adId, createOrUpdateComment, authentication);
    }

    //Удаление комментария
    @DeleteMapping("/{adId}/comments/{commentId}")
    public void deleteComment(@PathVariable("adId") Long adId,
                              @PathVariable("commentId") Long commentId,
                              Authentication authentication) {
        commentService.deleteComment(adId,commentId, authentication);
    }

    //Обновление комментария
    @PutMapping("/{adId}/comments/{commentId}")
    public void updateComment(@PathVariable("adId") Long adId,
                              @PathVariable("commentId") Long commentId,
                              @RequestBody CreateOrUpdateComment createOrUpdateComment,
                              Authentication authentication) {
        commentService.updateComment(adId,commentId, createOrUpdateComment,authentication);
    }
}