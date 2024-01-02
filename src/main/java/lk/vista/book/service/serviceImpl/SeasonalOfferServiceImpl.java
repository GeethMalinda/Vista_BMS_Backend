package lk.vista.book.service.serviceImpl;

import lk.vista.book.dto.SeasonalOfferDTO;
import lk.vista.book.entity.SeasonalOffer;
import lk.vista.book.repo.SeasonalOfferRepository;
import lk.vista.book.service.SeasonalOfferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SeasonalOfferServiceImpl implements SeasonalOfferService {

    @Autowired
    private SeasonalOfferRepository seasonalOfferRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SeasonalOfferDTO createOffer(SeasonalOfferDTO offerDTO) {
        SeasonalOffer offer = modelMapper.map(offerDTO, SeasonalOffer.class);
        return modelMapper.map(seasonalOfferRepository.save(offer), SeasonalOfferDTO.class);
    }

    @Override
    public SeasonalOfferDTO updateOffer(Long id, SeasonalOfferDTO offerDTO) {
        // Implement logic to update an offer
        return new SeasonalOfferDTO();
    }

    @Override
    public void deleteOffer(Long id) {
        // Implement logic to delete an offer
    }

    @Override
    public List<SeasonalOfferDTO> getCurrentOffers() {
        LocalDate today = LocalDate.now();
        return seasonalOfferRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(today, today)
                .stream()
                .map(offer -> modelMapper.map(offer, SeasonalOfferDTO.class))
                .collect(Collectors.toList());
    }

}
