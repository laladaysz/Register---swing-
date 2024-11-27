package br.ets.hibernate.entities;

import br.ets.hibernate.dtos.users.UserCreateDTO;
import br.ets.hibernate.entities.enums.UserRole;

import javax.persistence.*;

@Entity
@Table(name="Usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Long idUsuario;

    private String nome;
    private String login;
    private String senha;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(UserCreateDTO data){
        this.nome = data.nome();
        this.login = data.login();
        this.senha = data.senha();
        this.role = UserRole.ROLE_ADMIN;
    }

    public User(Long idUsuario, String nome, String login, String senha, UserRole role) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.role = role;
    }

    public User() {
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
