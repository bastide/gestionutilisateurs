package monprojet.service;

import monprojet.entity.User;

public interface UserService {
    void createAdminUser();
    
    void save(User user);

    User findByUserName(String username);
}
