package fr.uphf.Locataire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locataires")
public class locataireControlleur {

    @Autowired
    private locataireService locataireService;

    @GetMapping
    public List<locataire> getAllLocataires() {
        return locataireService.getAllLocataires();
    }

    @GetMapping("/{id}")
    public locataire getLocataireById(@PathVariable Long id) {
        return locataireService.getLocataireById(id);
    }

    @PostMapping
    public locataire addLocataire(@RequestBody locataire locataire) {
        return locataireService.addLocataire(locataire);
    }

    @PutMapping
    public locataire updateLocataire(@RequestBody locataire locataire) {
        return locataireService.updateLocataire(locataire);
    }


}