package fr.uphf.Locataire.model;

import fr.uphf.Locataire.DTO.BienImmoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class LocataireService {

    @Autowired
    private LocataireRepository locataireRepository;

    @Autowired
    private WebClient.Builder webClient;
/*
    @Autowired
    public locataireService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }
*/
    public List<Locataire> getAllLocataires() {
        return locataireRepository.findAll();
    }

    public Locataire getLocataireById(Long id) {
        return locataireRepository.findById(id).orElse(null);
    }

    public Locataire addLocataire(Locataire locataire) {
        return locataireRepository.save(locataire);
    }

    public Locataire updateLocataire(Locataire locataire) {
        return locataireRepository.save(locataire);
    }

    public void deleteLocataire(Long id) { locataireRepository.deleteById(id);
    }
/*
    public Mono<BienImmoDTO> getBienByLocataire(Long locataireId) {
        return webClient.get()
                .uri("http://localhost:8080/bienImmobilier/locataires/" + locataireId + "/biens")
                .retrieve()
                .bodyToMono(BienImmoDTO.class);
    }

*/
    //service pour tous les biensImmo
    public BienImmoDTO listerBiensImmo() {
        return webClient.baseUrl("http://bienImmo/")
                .build()
                .get()
                .uri("/bienImmo")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(BienImmoDTO.class)
                .block();
        }

}