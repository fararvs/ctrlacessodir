package model;

import util.IPasta;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author rvsfara
 */
@Entity
@Table(name = "tb_pasta")
public class Pasta implements IPasta, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pas_id")
    private Long id;
    @Column(name = "pas_nome", nullable = false, length = 80)
    private String pas_nome;
    @Column(name = "pas_caminho", nullable = false, length = 100)
    private String pas_caminho;
    @Transient//Não sera gravado em banco de dados
    private final String msg = "Realizando Operações solicitadas para esse diretório";
    
    public Pasta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getPas_nome() {
        return pas_nome;
    }

    public void setPas_nome(String pas_nome) {
        this.pas_nome = pas_nome;
    }

    public String getPas_caminho() {
        return pas_caminho;
    }

    public void setPas_caminho(String pas_caminho) {
        this.pas_caminho = pas_caminho;
    }

    @Override
    public String toString() {
        return (this.pas_caminho+this.pas_nome);
    }

    @Override
    public String realizaOperacoes() {
        return (this.msg+"\n"+this.pas_caminho+this.pas_nome);
    }
    
    
}
