package mft.simcard.model.service;

import mft.simcard.servlet.exception.PersonNotFoundException;
import mft.simcard.model.entity.Person;
import mft.simcard.model.repository.CrudRepository;

import java.util.List;

public class PersonService {
    public Person save(Person person) throws Exception {
        try (CrudRepository<Person, Integer> personRepository = new CrudRepository<>()) {
            return personRepository.save(person);
        }
    }

    public Person edit(Person person) throws Exception {
        try (CrudRepository<Person, Integer> personRepository = new CrudRepository<>()) {
            if (personRepository.findById(person.getId(),Person.class) != null) {
                return personRepository.edit(person);
            } else {
                throw new PersonNotFoundException();
            }
        }
    }

    public Person deleteById(int id) throws Exception {
        try (CrudRepository<Person, Integer> personRepository = new CrudRepository<>()) {
            if (personRepository.findById(id,Person.class) != null) {
                return personRepository.deleteById(id,Person.class);
            } else {
                throw new PersonNotFoundException();
            }
        }
    }

    public List<Person> findAll() throws Exception {
        try (CrudRepository<Person, Integer> personRepository = new CrudRepository<>()) {
            return personRepository.findAll(Person.class);
        }
    }

    public Person findById(int id) throws Exception {
        try (CrudRepository<Person, Integer> personRepository = new CrudRepository<>()) {
            return personRepository.findById(id,Person.class);
        }
    }

    public List<Person> findByNameAndFamily(String name, String family) throws Exception {
        try (CrudRepository<Person, Integer> personRepository = new CrudRepository<>()) {
            return personRepository.findByNameAndFamily(name, family);
        }
    }
}
