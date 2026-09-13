package ra.edu.ss8homework.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateDTO {
    private String title;
    private String author;
    private Integer stock;
    private MultipartFile coverImage;
}
