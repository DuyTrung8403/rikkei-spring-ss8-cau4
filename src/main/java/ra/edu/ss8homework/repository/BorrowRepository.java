package ra.edu.ss8homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.edu.ss8homework.entity.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {
}
