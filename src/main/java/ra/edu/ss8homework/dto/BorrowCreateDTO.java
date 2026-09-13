package ra.edu.ss8homework.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.edu.ss8homework.validation.ExistingBookId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowCreateDTO {
    @NotBlank(message = "Username cannot be blank")
    private String username;

    @ExistingBookId
    private Long bookId;
}
