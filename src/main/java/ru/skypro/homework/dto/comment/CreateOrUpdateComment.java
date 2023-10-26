package ru.skypro.homework.dto.comment;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdateComment {
    @Size(min = 8, max = 64)
    private String text;
}
