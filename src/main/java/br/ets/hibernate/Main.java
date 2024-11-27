package br.ets.hibernate;

import br.ets.hibernate.daos.UserDAO;
import br.ets.hibernate.daos.VagaDAO;
import br.ets.hibernate.telas.TelaHome;
import br.ets.hibernate.telas.TelaLogin;
import br.ets.hibernate.telas.TelaRegistro;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        UserDAO userDAO = new UserDAO(entityManager);
        VagaDAO vagaDAO = new VagaDAO(entityManager);

        TelaLogin telaLogin = new TelaLogin();

        if(telaLogin.showLogin(userDAO)){
            TelaHome telaHome = new TelaHome();
            telaHome.showHome(userDAO, vagaDAO);
        }
    }
}