package lk.vista.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeasonalOfferDTO {
    private Long id;
    private BigDecimal discountRate;
    private LocalDate startDate;
    private LocalDate endDate;
    private String category;
}
