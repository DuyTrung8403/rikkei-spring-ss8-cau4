package ra.edu.ss8homework.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.edu.ss8homework.dto.BorrowCreateDTO;
import ra.edu.ss8homework.entity.Borrow;
import ra.edu.ss8homework.service.BorrowService;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @PostMapping
    public ResponseEntity<Borrow> createBorrow(@Valid @RequestBody BorrowCreateDTO dto) {
        Borrow savedBorrow = borrowService.createBorrow(dto);
        return new ResponseEntity<>(savedBorrow, HttpStatus.CREATED);
    }
}
