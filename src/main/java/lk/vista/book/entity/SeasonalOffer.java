package lk.vista.book.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "SeasonalOffers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeasonalOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal discountRate;

    private LocalDate startDate;

    private LocalDate endDate;

    private String category;
}
