package br.ets.hibernate.daos;

import br.ets.hibernate.dtos.users.UserCreateDTO;
import br.ets.hibernate.entities.User;
import br.ets.hibernate.entities.enums.UserRole;
import br.ets.hibernate.exceptions.GenericsNotFoundException;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.EntityManager;

public class UserDAO {
    private EntityManager entityManager;

    public UserDAO (EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public boolean register(UserCreateDTO data){
        try {
            User user = new User(data);
            String hashPassword = BCrypt.hashpw(user.getSenha(), BCrypt.gensalt());
            user.setSenha(hashPassword);

            entityManager.getTransaction().begin();
            this.entityManager.persist(user);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e){
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            return false;
        }
    }

    public User getByLogin(String login) {
        try {
            return entityManager.createQuery(
                            "SELECT u FROM User u WHERE u.login = :login", User.class)
                    .setParameter("login", login)
                    .getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            throw new GenericsNotFoundException("Usuário não encontrado!");
        }
    }

    public boolean authenticate(String login, String password){
        try {
            User user = getByLogin(login);
            if(BCrypt.checkpw(password, user.getSenha())){
                if(user.getRole() == UserRole.ROLE_ADMIN){
                    return  true;
                } else {
                    return false;
                }
            }
            return true;
        } catch (GenericsNotFoundException e){
            return false;
        }
    }
}
