package mft.simcard.model.tools;

import lombok.Getter;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaProvider {
    @Getter
    private static JpaProvider provider = new JpaProvider();

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("sim_card");

private JpaProvider() {}
    public EntityManager getEntityManager() {
    return factory.createEntityManager();
    }
}
