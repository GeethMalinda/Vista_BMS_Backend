package lk.vista.book.repo;

import lk.vista.book.entity.BookDetail;
import lk.vista.book.enums.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDetailRepository extends JpaRepository<BookDetail, String> {

    List<BookDetail> findByCategory(String category);

}
