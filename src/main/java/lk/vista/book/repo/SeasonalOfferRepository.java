package lk.vista.book.repo;

import lk.vista.book.entity.SeasonalOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SeasonalOfferRepository extends JpaRepository<SeasonalOffer, Long> {
    List<SeasonalOffer> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate startDate, LocalDate endDate);
}
