package monprojet.service;

import monprojet.entity.Utilisateur;

public interface UserService {
    void initializeRolesAndAdmin();

    void save(Utilisateur user);

    Utilisateur findByUserName(String username);
}
