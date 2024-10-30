package co.edu.unicauca.events.publisher.DTO;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "person")
public class PersonDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String email;
    private Long idConference;
    private String nameConference;

    public PersonDTO(Long id, String name, String email, Long idConference, String nameConference) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.idConference = idConference;
        this.nameConference = nameConference;
    }

    public PersonDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getIdConference() {
        return idConference;
    }

    public void setIdConference(Long idConference) {
        this.idConference = idConference;
    }

    public String getNameConference() {
        return nameConference;
    }

    public void setNameConference(String nameConference) {
        this.nameConference = nameConference;
    }
}
