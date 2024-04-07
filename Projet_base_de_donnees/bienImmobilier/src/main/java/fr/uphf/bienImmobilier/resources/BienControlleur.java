package fr.uphf.bienImmobilier.resources;

import fr.uphf.bienImmobilier.resources.BienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bienImmobilier")
public class BienControlleur {

    @Autowired
    private BienService bienService;

    @GetMapping
    public List<BienImmobilier> getAllBiens() {
        return bienService.getAllBiens();
    }

    @GetMapping("/{id}")
    public BienImmobilier getBienById(@PathVariable Long id) {
        return bienService.getBienById(id);
    }

    @PostMapping
    public BienImmobilier addBien(@RequestBody BienImmobilier bien) {
        return bienService.addBien(bien);
    }

    @PutMapping
    public BienImmobilier updateBien(@RequestBody BienImmobilier bien) {
        return bienService.updateBien(bien);
    }

    @DeleteMapping("/{id}")
    public void deleteBien(@PathVariable Long id) {
        bienService.deleteBien(id);
    }

    @GetMapping("/locataires/{id}/biens")
    public List<BienImmobilier> getBiensByLocataire(@PathVariable Long id) {
        return bienService.getAllBiens().stream()
                .filter(bien -> bien.getLocataires().stream()
                        .anyMatch(locataire -> locataire.getId().equals(id)))
                .collect(Collectors.toList());
    }
}