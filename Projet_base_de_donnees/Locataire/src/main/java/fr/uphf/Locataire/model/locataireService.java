package fr.uphf.Locataire.model;

import fr.uphf.Locataire.DTO.BienDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class locataireService {

    @Autowired
    private fr.uphf.Locataire.model.locataireRepository locataireRepository;

    @Autowired
    private WebClient.Builder webClient;
/*
    @Autowired
    public locataireService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }*/

    public List<locataire> getAllLocataires() {
        return locataireRepository.findAll();
    }

    public locataire getLocataireById(Long id) {
        return locataireRepository.findById(id).orElse(null);
    }

    public locataire addLocataire(locataire locataire) {
        return locataireRepository.save(locataire);
    }

    public locataire updateLocataire(locataire locataire) {
        return locataireRepository.save(locataire);
    }

    public void deleteLocataire(Long id) { locataireRepository.deleteById(id);
    }
/*
    public Mono<BienDTO> getBienByLocataire(Long locataireId) {
        return webClient.get()
                .uri("http://localhost:8080/bienImmobilier/locataires/" + locataireId + "/biens")
                .retrieve()
                .bodyToMono(BienDTO.class);
    }*/

    public List<BienDTO> listerBiensLocataire(Long idLocataire) {
        return webClient
                .build()
                .get()
                .uri("http://localhost:8083/reservation/reservation/reservation/"+idLocataire)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(BienDTO.class)
                .collectList()
                .block();
    }
}