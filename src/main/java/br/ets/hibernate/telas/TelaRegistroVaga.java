package br.ets.hibernate.telas;

import br.ets.hibernate.daos.UserDAO;
import br.ets.hibernate.daos.VagaDAO;
import br.ets.hibernate.dtos.vagas.VagaCreateDTO;

import javax.swing.*;

public class TelaRegistroVaga {
    public void showRegistroVaga(VagaDAO vagaDAO){
        JTextField numVagaField = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Deixa o layout do painel em colunas

        panel.add(new JLabel("Número Vaga: "));
        panel.add(numVagaField);

        var result = JOptionPane.showConfirmDialog(
                null,
                panel,
                "EasyPark",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if(result == JOptionPane.OK_OPTION){
            int numVaga = Integer.parseInt(numVagaField.getText());
            VagaCreateDTO data = new VagaCreateDTO(numVaga);
            if(vagaDAO.registerVaga(data)){
                JOptionPane.showMessageDialog(null, "Vaga cadastrada com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Algo deu errado ao cadastrar usuário", "", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("Cancel");
        }
    }
}
