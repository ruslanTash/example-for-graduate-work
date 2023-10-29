package ru.skypro.homework.mapper;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.comment.CommentDTO;
import ru.skypro.homework.dto.comment.CreateOrUpdateComment;
import ru.skypro.homework.entity.Comment;

@Service
public class CommentMapper {

    public Comment fromCommentDTO(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setPk(commentDTO.getPk());
        comment.setCreatedAt(commentDTO.getCreatedAt());
        comment.setText(commentDTO.getText());
        return comment;

    }

    public CommentDTO toCommentDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setPk(comment.getPk());
        commentDTO.setAuthorImage(comment.getUser().getImage().getImagePath());
        commentDTO.setAuthorFirstName(comment.getUser().getFirstName());
        commentDTO.setCreatedAt(comment.getCreatedAt());
        commentDTO.setText(comment.getText());
        return commentDTO;
    }

    public Comment fromCreateOrUpdateComment(CreateOrUpdateComment createOrUpdateComment) {
        Comment comment = new Comment();
        comment.setText(comment.getText());
        return comment;
    }
    public CreateOrUpdateComment toCreateOrUpdateComment(Comment comment){
        CreateOrUpdateComment createOrUpdateComment=new CreateOrUpdateComment();
        createOrUpdateComment.setText(createOrUpdateComment.getText());
        return createOrUpdateComment;
    }

}
