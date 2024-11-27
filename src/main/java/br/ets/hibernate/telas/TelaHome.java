package br.ets.hibernate.telas;

import br.ets.hibernate.daos.UserDAO;
import br.ets.hibernate.daos.VagaDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaHome {
    public void showHome(UserDAO userDAO, VagaDAO vagaDAO){
        JButton btnCadastroUsuario = new JButton("Cadastro de Usuário");
        JButton btnCadastroVaga = new JButton("Cadastro de Vaga");

        JPanel panel = new JPanel();

        panel.add(btnCadastroUsuario);
        panel.add(Box.createVerticalStrut(10)); // Espaço entre os botões
        panel.add(btnCadastroVaga);

        btnCadastroUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaRegistro telaRegistro = new TelaRegistro();
                telaRegistro.showRegister(userDAO);
            }
        });

        btnCadastroVaga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaRegistroVaga telaRegistroVaga = new TelaRegistroVaga();
                telaRegistroVaga.showRegistroVaga(vagaDAO);
            }
        });

        int option = JOptionPane.showOptionDialog(
                null,
                panel,
                "EasyPark",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                new Object[] {},
                null
        );
    }
}
