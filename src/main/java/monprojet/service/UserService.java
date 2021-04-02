package monprojet.service;

import monprojet.entity.Utilisateur;

public interface UserService {
    void createAdminUser();
    
    void save(Utilisateur user);

    Utilisateur findByUserName(String username);
}
