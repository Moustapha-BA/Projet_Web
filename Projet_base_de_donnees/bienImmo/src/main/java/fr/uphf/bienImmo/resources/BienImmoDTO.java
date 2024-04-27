package fr.uphf.bienImmo.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BienImmoDTO {
        private Long idBienImmo;
        private String adresse;
        private String type;
        private int surface;
        private int nbPieces;
        private int loyer;
        private LocataireDTO locataire;

        @Getter
        @Setter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class LocataireDTO {
                Long idLocataire;
        }
}

