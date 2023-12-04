package lk.vista.book.service;

import lk.vista.book.dto.SeasonalOfferDTO;

import java.util.List;

public interface SeasonalOfferService {
    SeasonalOfferDTO createOffer(SeasonalOfferDTO offerDTO);
    SeasonalOfferDTO updateOffer(Long id, SeasonalOfferDTO offerDTO);
    void deleteOffer(Long id);
    List<SeasonalOfferDTO> getCurrentOffers();
}
