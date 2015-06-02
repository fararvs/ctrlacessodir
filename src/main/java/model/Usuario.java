package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import state.Desconectado;
import state.Estado;

/**
 *
 * @author rvsfara
 */
@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Long id;
    @Column(name = "usu_nome", nullable = false, length = 80)
    private String nome;
    @Column(name = "usu_usuario", nullable = false, length = 12, unique = true)
    private String usuario;
    @Column(name = "usu_senha", nullable = false, length = 12)
    private String senha;
    @Column(name = "usu_perseguranca", nullable = false, length = 100)
    private String perSeguranca;
    @Column(name = "usu_resseguranca", nullable = false, length = 100)
    private String resSeguranca;
    @Column(name = "usu_admin", nullable = false)
    private Boolean admin;
    @OneToOne
    private Pasta diretorio;
    @Transient
    private Estado estado = new Desconectado();

    public Usuario() {
    }

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pasta getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(Pasta diretorio) {
        this.diretorio = diretorio;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerSeguranca() {
        return perSeguranca;
    }

    public void setPerSeguranca(String perSeguranca) {
        this.perSeguranca = perSeguranca;
    }

    public String getResSeguranca() {
        return resSeguranca;
    }

    public void setResSeguranca(String resSeguranca) {
        this.resSeguranca = resSeguranca;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return this.usuario;
    }
    
}
