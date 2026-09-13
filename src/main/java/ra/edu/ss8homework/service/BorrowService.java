package ra.edu.ss8homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.ss8homework.dto.BorrowCreateDTO;
import ra.edu.ss8homework.entity.Borrow;
import ra.edu.ss8homework.repository.BorrowRepository;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    public Borrow createBorrow(BorrowCreateDTO dto) {
        Borrow borrow = Borrow.builder()
                .username(dto.getUsername())
                .bookId(dto.getBookId())
                .build();
        return borrowRepository.save(borrow);
    }
}
