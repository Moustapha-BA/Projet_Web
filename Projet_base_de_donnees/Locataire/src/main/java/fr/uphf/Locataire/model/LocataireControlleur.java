package fr.uphf.Locataire.model;

import fr.uphf.Locataire.DTO.BienImmoDTO;
import fr.uphf.Locataire.DTO.reservationDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/locataires")
public class LocataireControlleur {

    @Autowired
    private LocataireService locataireService;

    @Autowired
    private WebClient.Builder webClient;


    @GetMapping
    public List<Locataire> getAllLocataires() {
        return locataireService.getAllLocataires();
    }

    @GetMapping("/{id}")
    public Locataire getLocataireById(@PathVariable Long id) {
        return locataireService.getLocataireById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Locataire addLocataire(@RequestBody Locataire locataire) {
        return locataireService.addLocataire(locataire);
    }

    @PutMapping
    public Locataire updateLocataire(@RequestBody Locataire locataire) {
        return locataireService.updateLocataire(locataire);
    }
    @Builder
    @Getter
    @Setter
    public static class locataireDetailDTO {
        private Long id;
        private List<reservationDTO> reservations;
    }
    @GetMapping("/reservations/{id}")
    public ResponseEntity<locataireDetailDTO> getReservationsByLocataireId(@PathVariable Long id) {
        reservationDTO[] reservationsFromApi = webClient.build()
                .get()
                .uri("http://localhost:8081/reservation/reservation/reservation/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(reservationDTO[].class)
                .block();
        return ResponseEntity.ok(locataireDetailDTO.builder().id(id).reservations(Arrays.asList(reservationsFromApi)).build());
    }



    //méthode pour lister les biensImmo qui existe dans le microservice bienImmo

    @GetMapping("/biensImmo")
    public ResponseEntity<List<BienImmoDTO>> getBiensImmo() {
        BienImmoDTO biensImmoFromApi = this.locataireService.listerBiensImmo();

        return ResponseEntity.ok(List.of(biensImmoFromApi));
    }

}