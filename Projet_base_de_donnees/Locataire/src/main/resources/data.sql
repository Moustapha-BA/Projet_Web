
CREATE TABLE locataire (
                           id INT PRIMARY KEY,
                           nom VARCHAR(50),
                           prenom VARCHAR(50),
                           adresse VARCHAR(100),
                           num_tel VARCHAR(15)
);
INSERT INTO locataire (id,nom, prenom, adresse, NUM_TEL ) values
    (1, 'Dupont', 'Jean', '123 rue de la Paix', '0123456789') ,
    (2, 'Durand', 'Paul', '456 rue de la République', '9876543210') ,
    (3, 'Duchemin', 'Marie', '789 rue de la Liberté', '1234567890') ,
    (4, 'Dutronc', 'Jacques', '159 rue de la Fraternité', '0987654321') ,
    (5, 'Duchamp', 'Marcel', '357 rue de la Solidarité', '1357924680') ;
