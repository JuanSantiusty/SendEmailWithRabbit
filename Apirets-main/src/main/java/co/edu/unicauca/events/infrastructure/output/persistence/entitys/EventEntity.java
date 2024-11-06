/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.events.infrastructure.output.persistence.entitys;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author FABIAN G
 */
@Entity
@Table(name = "events")
public class EventEntity implements Serializable{


    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonEntity chair;

    @ManyToMany
    @JoinTable(
            name = "participants",
            joinColumns = @JoinColumn(name = "events_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private List<PersonEntity> comite;
    
    private String name;
    @Id //define la llave rpimaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //genera automaticamente el Id
    private Long id;

 // agergar getters y setters...

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonEntity getChair() {
        return chair;
    }

    public void setChair(PersonEntity chair) {
        this.chair = chair;
    }

    public List<PersonEntity> getComite() {
        return comite;
    }

    public void setComite(List<PersonEntity> comite) {
        this.comite = comite;
    }
}