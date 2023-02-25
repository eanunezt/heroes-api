package itli.diplomado.heroes.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity (name="HEROES2" )
public class Heroe2 implements Serializable{ 
    
    @Id
    @Column(name="HEROE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //el nombre no necesariamente es igual
    
    @Column(name="NAME")
    private String name; 
    
    @ManyToMany() //cascade = { CascadeType.ALL }
    @JoinTable(name = "REL_HEROE_PODERES",
            joinColumns = { @JoinColumn(name = "HEROE_ID", foreignKey = @ForeignKey(name = "FK_REL_HEPO_HEROE"))},
            inverseJoinColumns = { @JoinColumn(name = "PODER_ID", foreignKey = @ForeignKey(name = "FK_REL_HEPO_PODER")) })
    private Set<Poder> poderes = new HashSet<Poder>(); 
        

}
