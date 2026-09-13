package ra.edu.ss8homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.edu.ss8homework.dto.BookCreateDTO;
import ra.edu.ss8homework.entity.Book;
import ra.edu.ss8homework.repository.BookRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Đường dẫn lưu file theo yêu cầu (lưu vào src/main/resources/uploads/)
    private final String UPLOAD_DIR = "src/main/resources/uploads/";

    public Book createBook(BookCreateDTO dto) {
        String coverUrl = null;
        MultipartFile file = dto.getCoverImage();
        
        if (file != null && !file.isEmpty()) {
            try {
                // Tạo thư mục nếu chưa tồn tại
                File uploadDir = new File(UPLOAD_DIR);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                // Lấy tên file gốc
                String fileName = file.getOriginalFilename();
                Path filePath = Paths.get(UPLOAD_DIR + fileName);
                
                // Lưu file vào thư mục uploads
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                
                // Gán đường dẫn file vào thuộc tính coverUrl (chuyển Path thành chuỗi để giống với kết quả trong ảnh)
                coverUrl = filePath.toString();
                
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Lỗi khi lưu file ảnh!");
            }
        }

        // Tạo đối tượng Book để lưu vào DB
        Book book = Book.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .stock(dto.getStock())
                .coverUrl(coverUrl)
                .build();

        return bookRepository.save(book);
    }
}
