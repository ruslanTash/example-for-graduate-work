package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.homework.dto.comment.Comments;
import ru.skypro.homework.dto.comment.CreateOrUpdateComment;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.CommentService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final AdRepository adsRepository;
    private final UserRepository usersRepository;


    @Override
    public Comments getComments(Long adId) {
        ArrayList<Comment> comments = commentRepository.findAllCommentsByAdId(adId);
        return new Comments(comments);
    }

    @Override
    public void addComment(Long id, CreateOrUpdateComment createOrUpdateComment, Authentication authentication) {
        String username = authentication.getName();

        Ad getAd = (Ad) adsRepository.findAdsByUserId(id);
        User meUsers = usersRepository.getUser(authentication);
        Comment newComment = new Comment();

        newComment.setUser(meUsers);
        newComment.setAd(getAd);
        newComment.setText(createOrUpdateComment.getText());
        newComment.setCreatedAt(LocalDateTime.now());

        commentRepository.save(newComment);
    }

    @Override
    public void deleteComment(Long adId, Long commentId, Authentication authentication) {
        Comment findComment = commentRepository.findById(commentId).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        });
        if (!adId.equals(findComment.getAd().getPk())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            commentRepository.delete(findComment);
        }
    }

    @Override
    public void updateComment(Long adId, Long commentId, CreateOrUpdateComment createOrUpdateComment, Authentication authentication) {
        Comment findComment = commentRepository.findById(commentId).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        });
        if (!adId.equals(findComment.getAd().getPk())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            commentRepository.save(findComment);
        }
    }


}

