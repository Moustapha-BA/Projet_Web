package fr.uphf.bienImmo.resources;

import fr.uphf.bienImmo.services.BienImmoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class BienImmoController {

    @Autowired
    private BienImmoApiService bienImmoApiService;


    @GetMapping
    public ResponseEntity<BienImmo[]> listerBiensImmo() {
        return ResponseEntity.ok(this.bienImmoApiService.getAllBiensImmo());
    }

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

}
