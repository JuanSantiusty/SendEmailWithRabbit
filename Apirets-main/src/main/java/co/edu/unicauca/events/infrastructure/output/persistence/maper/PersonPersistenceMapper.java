package co.edu.unicauca.events.infrastructure.output.persistence.maper;

import co.edu.unicauca.events.domain.Person;
import co.edu.unicauca.events.infrastructure.output.persistence.entitys.PersonEntity;

public class PersonPersistenceMapper {
    public static PersonEntity toPersonEntity(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(person.getId());
        personEntity.setName(person.getName());
        personEntity.setEmail(person.getEmail());
        return personEntity;
    }

    public static Person toPerson(PersonEntity entity) {
        Person person = new Person();
        person.setId(entity.getId());
        person.setName(entity.getName());
        person.setEmail(entity.getEmail());
        return person;
    }

}
