package fr.uphf.bienImmo.resources;

import fr.uphf.bienImmo.services.BienImmoApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biensImmo")
public class BienImmoController {

    private BienImmoApiService bienImmoApiService;

    public BienImmoController(BienImmoApiService bienImmoApiService) {
        this.bienImmoApiService = bienImmoApiService;
    }

    @GetMapping
    public ResponseEntity<List<BienImmo>> listerBiensImmo() {
        return ResponseEntity.ok(this.bienImmoApiService.listerBiensImmo());
    }


    //méthode GetMapping pour lister un bienImmo par son id
    @GetMapping("/{idBienImmo}")
    public ResponseEntity<BienImmo> recupererBienImmo(@PathVariable("idBienImmo") Long idBienImmo) {
        try {
            return ResponseEntity.ok(this.bienImmoApiService.recupererBienImmoById(idBienImmo));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //méthode ajouter un BienImmo
    @PostMapping
    public ResponseEntity ajouterBienImmo(@RequestBody CreationBienImmoRequestODT creationBienImmoRequestODT) {
        try {
            return ResponseEntity.ok(this.bienImmoApiService.ajouterBienImmo(creationBienImmoRequestODT));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erreur lors de l'ajout du bienImmo");
        }
    }

    //méthode pour modifier un BienImmo
    @PutMapping("/{idBienImmo}")
    public ResponseEntity modifierBienImmo(@PathVariable("idBienImmo") Long idBienImmo, @RequestBody CreationBienImmoRequestODT creationBienImmoRequestODT) {
        try {
            return ResponseEntity.ok(this.bienImmoApiService.modifierBienImmo(idBienImmo, creationBienImmoRequestODT));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erreur lors de la modification du bienImmo");
        }
    }

     //Ajout d'un API pour lister less biensImmos d'un locataire
    @GetMapping("/locataires/{idLocataire}/biens")
    public ResponseEntity<List<BienImmoDTO>> listerBiensImmoParLocataireId(@PathVariable("idLocataire") Long idLocataire) {
        try {
            List<BienImmoDTO> biens = bienImmoApiService.listerBiensImmoParLocataire(idLocataire);
            if (biens.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(biens);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}
