package ra.edu.ss8homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.ss8homework.dto.BookCreateDTO;
import ra.edu.ss8homework.entity.Book;
import ra.edu.ss8homework.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@ModelAttribute BookCreateDTO dto) {
        Book savedBook = bookService.createBook(dto);
        // Trả về mã 201 Created cùng với bản ghi sách vừa tạo
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateBookStock(
            @PathVariable Long id,
            @jakarta.validation.Valid @RequestBody ra.edu.ss8homework.dto.BookUpdateStockDTO dto) {
        String result = bookService.updateBook(id, dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }
}
