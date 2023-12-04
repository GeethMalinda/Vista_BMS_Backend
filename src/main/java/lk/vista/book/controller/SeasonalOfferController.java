package lk.vista.book.controller;

import lk.vista.book.dto.SeasonalOfferDTO;
import lk.vista.book.service.SeasonalOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/seasonal-offers")
@CrossOrigin
public class SeasonalOfferController {

    @Autowired
    private SeasonalOfferService seasonalOfferService;

    @PostMapping
    public ResponseEntity<SeasonalOfferDTO> createOffer(@RequestBody SeasonalOfferDTO offerDTO) {
        return ResponseEntity.ok(seasonalOfferService.createOffer(offerDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeasonalOfferDTO> updateOffer(@PathVariable Long id, @RequestBody SeasonalOfferDTO offerDTO) {
        return ResponseEntity.ok(seasonalOfferService.updateOffer(id, offerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable Long id) {
        seasonalOfferService.deleteOffer(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/current")
    public ResponseEntity<List<SeasonalOfferDTO>> getCurrentOffers() {
        return ResponseEntity.ok(seasonalOfferService.getCurrentOffers());
    }
}
