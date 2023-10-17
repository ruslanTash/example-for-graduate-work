package ru.skypro.homework.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.dto.CommentDTO.Comments;
import ru.skypro.homework.dto.CommentDTO.CreateOrUpdateComment;

public interface CommentService {
    Comments getComments(Authentication authentication, int id);

    Comment addComment(Authentication authentication, int id, CreateOrUpdateComment createOrUpdateComment);

    ResponseEntity<Comment> deleteComment(Authentication authentication, int adId, int commentId);

    Comment updateComment(Authentication authentication, int adId, int commentId, CreateOrUpdateComment createOrUpdateComment);
}
