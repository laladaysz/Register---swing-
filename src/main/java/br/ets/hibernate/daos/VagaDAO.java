package br.ets.hibernate.daos;

import br.ets.hibernate.dtos.vagas.VagaCreateDTO;
import br.ets.hibernate.entities.Vaga;

import javax.persistence.EntityManager;

public class VagaDAO {
    private EntityManager entityManager;

    public VagaDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public boolean registerVaga(VagaCreateDTO data){
        Vaga vaga = new Vaga(data);
        try {
            entityManager.getTransaction().begin();
            this.entityManager.persist(vaga);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return false;
        }
    }
}
