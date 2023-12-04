package lk.vista.book.repo;

import lk.vista.book.entity.SeasonalOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SeasonalOfferRepository extends JpaRepository<SeasonalOffer, Long> {
    List<SeasonalOffer> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate currentDate);
}
