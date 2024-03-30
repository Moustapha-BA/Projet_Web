package fr.uphf.Locataire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class locataireService {

    @Autowired
    private locataireRepository locataireRepository;

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

    public void deleteLocataire(Long id) {
        locataireRepository.deleteById(id);
    }
}
