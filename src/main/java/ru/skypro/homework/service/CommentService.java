package ru.skypro.homework.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.dto.comment.Comments;
import ru.skypro.homework.dto.comment.CreateOrUpdateComment;

public interface CommentService {

    Comments getComments(Long adId);

    void addComment(Long id, CreateOrUpdateComment createOrUpdateComment, Authentication authentication);

    void deleteComment(Long adId, Long commentId, Authentication authentication);

    void updateComment(Long adId, Long commentId,CreateOrUpdateComment createOrUpdateComment, Authentication authentication);

}