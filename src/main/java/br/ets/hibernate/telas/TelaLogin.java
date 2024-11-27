package br.ets.hibernate.telas;

import br.ets.hibernate.daos.UserDAO;

import javax.swing.*;
import java.awt.*;

public class TelaLogin {
    public boolean showLogin(UserDAO userDAO){
        JTextField loginField = new JTextField();
        loginField.setPreferredSize(new Dimension(200, 30));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 30));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Deixa o layout do painel em colunas

        panel.add(new JLabel("Login: "));
        panel.add(loginField);

        panel.add(new JLabel("Senha: "));
        panel.add(passwordField);

        var result = JOptionPane.showConfirmDialog(
                null,
                panel,
                "EasyPark",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if(result == JOptionPane.OK_OPTION){
            String login = loginField.getText();
            String password = new String(passwordField.getPassword());

            if(userDAO.authenticate(login, password)){
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Login e/ou senha incorretos!", "", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } else {
            System.out.println("Cancel");
            return false;
        }
    }
}
