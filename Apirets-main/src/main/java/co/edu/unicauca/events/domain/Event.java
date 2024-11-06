package co.edu.unicauca.events.domain;



import java.util.List;

public class Event {
    private Person chair;
    private List<Person> comite;
    private String name;
    private Long id;

    public Event(Person chair, List<Person> comite, String name, Long id) {
        this.chair = chair;
        this.comite = comite;
        this.name = name;
        this.id = id;
    }

    public Event() {
    }

    public Person getChair() {
        return chair;
    }

    public void setChair(Person chair) {
        this.chair = chair;
    }

    public List<Person> getComite() {
        return comite;
    }

    public void setComite(List<Person> comite) {
        this.comite = comite;
    }

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
}
