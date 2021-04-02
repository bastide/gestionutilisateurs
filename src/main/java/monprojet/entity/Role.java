package monprojet.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
// Lombok
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NonNull
    @Column(unique=true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private List<Utilisateur> users = new LinkedList<>();
}
