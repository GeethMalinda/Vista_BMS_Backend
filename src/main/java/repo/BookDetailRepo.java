package repo;

import lk.vista.book.entity.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDetailRepo extends JpaRepository<BookDetail,String> {

}
