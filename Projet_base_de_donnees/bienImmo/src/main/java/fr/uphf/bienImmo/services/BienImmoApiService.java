package fr.uphf.bienImmo.services;

import fr.uphf.bienImmo.resources.BienImmo;
import fr.uphf.bienImmo.resources.BienImmoRepository;
import fr.uphf.bienImmo.resources.CreationBienImmoRequestODT;
import fr.uphf.bienImmo.resources.CreationBienImmoResponseODT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class BienImmoApiService {

    @Autowired
    private WebClient.Builder webClient;

    @Autowired
    private BienImmoRepository bienImmoRepository;


    public BienImmoApiService (BienImmoRepository bienImmoRepository) {
        this.bienImmoRepository = bienImmoRepository;
    }


    //********* services internes au microservice bienImmo *********

    //récupérer tous les biensImmo
    public List<BienImmo> listerBiensImmo() {
        return bienImmoRepository.findAll();
    }

    //récupérer un bienImmo par son id
    public BienImmo recupererBienImmoById(Long id) {
        Optional<BienImmo> bienImmo = bienImmoRepository.findById(id);
        return bienImmo.orElseThrow(null);
    }

    //ajouter un bienImmo
    public CreationBienImmoResponseODT ajouterBienImmo(CreationBienImmoRequestODT creationBienImmoRequestODT) {
        BienImmo bienImmoAAjouter = BienImmo.builder()
                .adresse(creationBienImmoRequestODT.getAdresse())
                .type(creationBienImmoRequestODT.getType())
                .surface(creationBienImmoRequestODT.getSurface())
                .loyer(creationBienImmoRequestODT.getLoyer())
                .nbPieces(creationBienImmoRequestODT.getNbPieces())
                .build();
        BienImmo bienImmoSauvegarder = bienImmoRepository.save(bienImmoAAjouter);
        return CreationBienImmoResponseODT.builder()
                .idBienImmo(bienImmoSauvegarder.getId())
                .adresse(bienImmoSauvegarder.getAdresse())
                .type(bienImmoSauvegarder.getType())
                .surface(bienImmoSauvegarder.getSurface())
                .loyer(bienImmoSauvegarder.getLoyer())
                .nbPieces(bienImmoSauvegarder.getNbPieces())
                .build();
    }

    //service pour modifier un bienImmo
    public CreationBienImmoResponseODT modifierBienImmo(Long idBienImmo, CreationBienImmoRequestODT creationBienImmoRequestODT){
        Optional<BienImmo> bienImmoOption = bienImmoRepository.findById(idBienImmo);
        if(bienImmoOption.isPresent()){
            BienImmo bienImmo = bienImmoOption.get();
            bienImmo.setAdresse(creationBienImmoRequestODT.getAdresse());
            bienImmo.setType(creationBienImmoRequestODT.getType());
            bienImmo.setSurface(creationBienImmoRequestODT.getSurface());
            bienImmo.setLoyer(creationBienImmoRequestODT.getLoyer());
            bienImmo.setNbPieces(creationBienImmoRequestODT.getNbPieces());

            BienImmo bienImmoModifier = bienImmoRepository.save(bienImmo);
            return CreationBienImmoResponseODT.builder()
                    .idBienImmo(bienImmoModifier.getId())
                    .adresse(bienImmoModifier.getAdresse())
                    .type(bienImmoModifier.getType())
                    .surface(bienImmoModifier.getSurface())
                    .loyer(bienImmoModifier.getLoyer())
                    .nbPieces(bienImmoModifier.getNbPieces())
                    .build();
        } else {
            throw new RuntimeException("Le bienImmo n'existe pas");
        }

    }


    //service pour supprimer un bienImmo

    //********* services pour communiquer avec le microservice Locataire *********


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
