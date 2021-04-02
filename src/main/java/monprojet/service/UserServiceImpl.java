package monprojet.service;

import monprojet.entity.User;
import monprojet.dao.RoleRepository;
import monprojet.dao.UserRepository;
import monprojet.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    // Login et Password de l'administrateur son définis dans 'application.propertie'
    @Value("${admin.login}")
    private String adminLogin;
    
    @Value("${admin.password}")
    private String adminPassword;

    @Value("${admin.email}")
    private String adminEmail;
        
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        // Par défaut on attribue le rôle 'normal' aux nouveaux utilisateurs
        //Le rôle 'normal' doit exister cf. data.sql
        Role normal = roleRepository.findByName("ROLE_USER").orElseThrow();
        // On crypte le mot de passe avant de l'enregistrer
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.getRoles().add(normal);
        //user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void createAdminUser() {
        //Le rôle 'admin' doit exister cf. data.sql
        Role admin = roleRepository.findByName("ROLE_ADMIN").orElseThrow();
        User adminUser = userRepository.findByUsername(adminLogin);
        if (null == adminUser) { // On ne le crée pas si il existe déjà
            log.info("On crée l'administrateur login: {}, password: {}", adminLogin, adminPassword);
            User firstAdmin = new User(adminLogin, adminPassword, adminEmail);
            // On crypte le mot de passe avant de l'enregistrer
            firstAdmin.setPassword(bCryptPasswordEncoder.encode(firstAdmin.getPassword()));
            firstAdmin.getRoles().add(admin);
            userRepository.save(firstAdmin);
        }
    }
}
