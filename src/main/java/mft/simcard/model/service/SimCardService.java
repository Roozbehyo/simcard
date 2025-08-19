package mft.simcard.model.service;

import mft.simcard.model.entity.SimCard;
import mft.simcard.model.repository.CrudRepository;
import mft.simcard.servlet.exception.PersonNotFoundException;
import mft.simcard.servlet.exception.SimCardNotFoundException;

import java.util.List;

public class SimCardService {
    public SimCard save(SimCard simCard) throws Exception {
        try (CrudRepository<SimCard, Integer> simCardRepository = new CrudRepository<>()) {
            return simCardRepository.save(simCard);
        }
    }

    public SimCard edit(SimCard simCard) throws Exception {
        try (CrudRepository<SimCard, Integer> simCardRepository = new CrudRepository<>()) {
            if (simCardRepository.findById(simCard.getId(),SimCard.class) != null) {
                return simCardRepository.edit(simCard);
            } else {
                throw new SimCardNotFoundException();
            }
        }
    }

    public SimCard deleteById(int id) throws Exception {
        try (CrudRepository<SimCard, Integer> personRepository = new CrudRepository<>()) {
            if (personRepository.findById(id,SimCard.class) != null) {
                return personRepository.deleteById(id,SimCard.class);
            } else {
                throw new PersonNotFoundException();
            }
        }
    }

    public List<SimCard> findAll() throws Exception {
        try (CrudRepository<SimCard, Integer> personRepository = new CrudRepository<>()) {
            return personRepository.findAll(SimCard.class);
        }
    }

    public SimCard findById(int id) throws Exception {
        try (CrudRepository<SimCard, Integer> personRepository = new CrudRepository<>()) {
            return personRepository.findById(id,SimCard.class);
        }
    }

//    public List<Person> findByNameAndFamily(String name, String family) throws Exception {
//        try (CrudRepository<Person, Integer> personRepository = new CrudRepository<>()) {
//            return personRepository.findByNameAndFamily(name, family);
//        }
//    }
}
