package br.ets.hibernate.telas;

import br.ets.hibernate.daos.UserDAO;
import br.ets.hibernate.dtos.users.UserCreateDTO;
import br.ets.hibernate.entities.User;

import javax.swing.*;

public class TelaRegistro {
    public void showRegister(UserDAO userDAO){
        JTextField nameField = new JTextField();
        JTextField loginField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Deixa o layout do painel em colunas

        panel.add(new JLabel("Nome: "));
        panel.add(nameField);

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
            String name = nameField.getText();
            String login = loginField.getText();
            String password = new String(passwordField.getPassword());
            UserCreateDTO data = new UserCreateDTO(name, login, password);

            if(userDAO.register(data)){
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Algo deu errado ao cadastrar usuário", "", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("Cancel");
        }
    }
}
