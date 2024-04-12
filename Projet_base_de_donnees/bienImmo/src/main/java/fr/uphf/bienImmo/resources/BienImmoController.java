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

    //méthode pour supprimer un BienImmo
    @DeleteMapping("/{idBienImmo}")
    public ResponseEntity supprimerBienImmo(@PathVariable("idBienImmo") Long idBienImmo) {
        try {
            this.bienImmoApiService.supprimerBienImmo(idBienImmo);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erreur lors de la suppression du bienImmo");
        }
    }




    /*

    //Get un bienImmo par son id
    @GetMapping("/{idBienImmo}")
    public BienImmo getBienImmoById(String idBienImmo) {
        return bienImmoApiService.getBienImmoById(idBienImmo);
    }

    //ajouter un bienImmo
    @PostMapping
    public ResponseEntity ajouterBienImmo(@RequestBody CreationBienImmoRequestODT creationBienImmoRequestODT) {
        try {
            return ResponseEntity.ok(this.bienImmoApiService.addBienImmo(creationBienImmoRequestODT));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erreur lors de l'ajout du bienImmo");
        }
    }

    //modifier un bienImmo
    @PutMapping("/{idBienImmo}")
    public ResponseEntity modifierBienImmo(@PathVariable("idBienImmo") Long idBienImmo, @RequestBody BienImmo bienImmo) {
        try {
            return ResponseEntity.ok(this.bienImmoApiService.updateBienImmo(idBienImmo, bienImmo));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erreur lors de la modification du bienImmo");
        }
    }
    */

}
