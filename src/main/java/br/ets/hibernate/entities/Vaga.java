package br.ets.hibernate.entities;

import br.ets.hibernate.dtos.vagas.VagaCreateDTO;
import br.ets.hibernate.entities.enums.StatusVaga;

import javax.persistence.*;

@Entity
@Table(name="Vagas")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vaga")
    private Long idVaga;

    @Column(name="numero_vaga")
    private int numeroVaga;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusVaga statusVaga;

    public Vaga(VagaCreateDTO data){
        this.numeroVaga = data.numeroVaga();
        this.statusVaga = StatusVaga.STATUS_LIVRE;
    }

    public Vaga(){

    }
    public Vaga(Long idVaga, int numeroVaga, StatusVaga statusVaga) {
        this.idVaga = idVaga;
        this.numeroVaga = numeroVaga;
        this.statusVaga = statusVaga;
    }

    public Long getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(Long idVaga) {
        this.idVaga = idVaga;
    }

    public int getNumeroVaga() {
        return numeroVaga;
    }

    public void setNumeroVaga(int numeroVaga) {
        this.numeroVaga = numeroVaga;
    }

    public StatusVaga getStatusVaga() {
        return statusVaga;
    }

    public void setStatusVaga(StatusVaga statusVaga) {
        this.statusVaga = statusVaga;
    }
}
