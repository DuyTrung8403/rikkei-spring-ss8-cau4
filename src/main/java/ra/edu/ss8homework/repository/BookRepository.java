package ra.edu.ss8homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.edu.ss8homework.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
