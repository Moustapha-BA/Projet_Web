package fr.uphf.bienImmo.services;

import fr.uphf.bienImmo.resources.BienImmo;
import fr.uphf.bienImmo.resources.CreationBienImmoRequestODT;
import fr.uphf.bienImmo.resources.CreationBienImmoResponseODT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BienImmoApiService {

    @Autowired
    private WebClient.Builder webClient;


    public BienImmo[] getAllBiensImmo() {
        return webClient.baseUrl("http://bienImmo/")
                .build()
                .get()
                .uri("/bienImmo")
                .retrieve()
                .bodyToMono(BienImmo[].class)
                .block();
    }

    public BienImmo getBienImmoById(String id) {
        return webClient.baseUrl("http://bienImmo/")
                .build()
                .get()
                .uri("/bienImmo/" + id)
                .retrieve()
                .bodyToMono(BienImmo.class)
                .block();
    }

    //ajouter un bienImmo
    public CreationBienImmoResponseODT addBienImmo(CreationBienImmoRequestODT creationBienImmoRequestODT) {
        return webClient.baseUrl("http://bienImmo/")
                .build()
                .post()
                .uri("/bienImmo")
                .bodyValue(creationBienImmoRequestODT)
                .retrieve()
                .bodyToMono(CreationBienImmoResponseODT.class)
                .block();
    }

    //modifier un bienImmo
    public CreationBienImmoResponseODT updateBienImmo(Long idBienImmo, BienImmo bienImmo) {
        return webClient.baseUrl("http://bienImmo/")
                .build()
                .put()
                .uri("/bienImmo/"+ idBienImmo)
                .bodyValue(bienImmo)
                .retrieve()
                .bodyToMono(CreationBienImmoResponseODT.class)
                .block();
    }

    //supprimer un bienImmo
    public void deleteBienImmo(Long idBienImmo) {
        webClient.baseUrl("http://bienImmo/")
                .build()
                .delete()
                .uri("/bienImmo/" + idBienImmo)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    //ajouter un locataire à un bienImmo
    public CreationBienImmoResponseODT addLocataireToBienImmo(Long idBienImmo, Long idLocataire) {
        return webClient.baseUrl("http://bienImmo/")
                .build()
                .put()
                .uri("/bienImmo/" + idBienImmo + "/locataire/" + idLocataire)
                .retrieve()
                .bodyToMono(CreationBienImmoResponseODT.class)
                .block();
    }
}
