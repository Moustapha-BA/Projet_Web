package fr.uphf.bienImmobilier;

import fr.uphf.bienImmobilier.resources.BienImmobilier;
import fr.uphf.bienImmobilier.resources.BienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BienService {

    @Autowired
    private BienRepository bienRepository;

    public List<BienImmobilier> getAllBiens() {
        return bienRepository.findAll();
    }

    public BienImmobilier getBienById(Long id) {
        return bienRepository.findById(id).orElse(null);
    }

    public BienImmobilier addBien(BienImmobilier bien) {
        return bienRepository.save(bien);
    }

    public BienImmobilier updateBien(BienImmobilier bien) {
        return bienRepository.save(bien);
    }

    public void deleteBien(Long id) {
        bienRepository.deleteById(id);
    }
}