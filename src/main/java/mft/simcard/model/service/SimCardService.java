package mft.simcard.model.service;

import mft.simcard.model.entity.SimCard;
import mft.simcard.model.enums.SimStatus;
import mft.simcard.model.repository.CrudRepository;
import mft.simcard.servlet.exception.SimCardNotFoundException;

import java.sql.ResultSet;
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
        try (CrudRepository<SimCard, Integer> simCardRepository = new CrudRepository<>()) {
            if (simCardRepository.findById(id,SimCard.class) != null) {
                return simCardRepository.deleteById(id,SimCard.class);
            } else {
                throw new SimCardNotFoundException();
            }
        }
    }

    public List<SimCard> findAll() throws Exception {
        try (CrudRepository<SimCard, Integer> simCardRepository = new CrudRepository<>()) {
            String whereClause = " status = "+ SimStatus.ENABLE;
            return simCardRepository.findAll(SimCard.class,whereClause);
        }
    }

    public SimCard findById(int id) throws Exception {
        try (CrudRepository<SimCard, Integer> simCardRepository = new CrudRepository<>()) {
            return simCardRepository.findById(id,SimCard.class);
        }
    }

    public SimCard findByNumber(String number) throws Exception {
        try (CrudRepository<SimCard, Integer> simCardRepository = new CrudRepository<>()) {
           String whereClause = " and number = :number:";
           List<SimCard> results = simCardRepository.findAll(SimCard.class,whereClause);
           if (results.size() > 0) {
               return results.get(0);
           }
        }
        return null;
    }
}
