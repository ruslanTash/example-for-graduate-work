package ru.skypro.homework.mapper;

import ru.skypro.homework.dto.CommentDTO.CommentDTO;
import ru.skypro.homework.dto.CommentDTO.CreateOrUpdateComment;
import ru.skypro.homework.entity.Comment;

public class CommentMapper {

    public Comment commentFromCommentDTO(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setPk(commentDTO.getPk());
        comment.setAuthorImage(commentDTO.getAuthorImage());
        comment.setAuthorFirstName(commentDTO.getAuthorFirstName());
        comment.setCreatedAt(commentDTO.getCreatedAt());
        comment.setText(commentDTO.getText());
        return comment;
    }

    public CommentDTO commentDTOFromComment(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setPk(comment.getPk());
        commentDTO.setAuthorImage(comment.getAuthorImage());
        commentDTO.setAuthorFirstName(comment.getAuthorFirstName());
        commentDTO.setCreatedAt(comment.getCreatedAt());
        commentDTO.setText(comment.getText());
        return commentDTO;
    }

    public Comment commentFromCreateOrUpdateComment(CreateOrUpdateComment createOrUpdateComment) {
        Comment comment = new Comment();
        comment.setText(comment.getText());
        return comment;
    }
    public CreateOrUpdateComment createOrUpdateCommentFromComment(Comment comment){
        CreateOrUpdateComment createOrUpdateComment=new CreateOrUpdateComment();
        createOrUpdateComment.setText(createOrUpdateComment.getText());
        return createOrUpdateComment;
    }

}
