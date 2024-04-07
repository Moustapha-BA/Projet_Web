package fr.uphf.Locataire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/locataires")
public class locataireControlleur {

    @Autowired
    private locataireService locataireService;
    @Autowired
    private WebClient.Builder webClient;
    @GetMapping
    public List<locataire> getAllLocataires() {
        return locataireService.getAllLocataires();
    }

    @GetMapping("/{id}")
    public locataire getLocataireById(@PathVariable Long id) {
        return locataireService.getLocataireById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public locataire addLocataire(@RequestBody locataire locataire) {
        return locataireService.addLocataire(locataire);
    }

    @PutMapping
    public locataire updateLocataire(@RequestBody locataire locataire) {
        return locataireService.updateLocataire(locataire);
    }

    @GetMapping("/{id}/reservations")
    public Mono<reservationDTO[]> getReservationsByLocataireId(@PathVariable Long id) {
        return webClient.baseUrl("http://reservation/")
                .build()
                .get()
                .uri("/reservations/locataire/" + id)
                .retrieve()
                .bodyToMono(reservationDTO[].class);
    }



}