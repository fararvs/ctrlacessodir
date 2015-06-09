package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author rvsfara
 */
@Entity
@Table(name = "tb_arquivo")
public class Arquivo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "arq_id")
    private Long id;
    @Column(name = "arq_nome", nullable = false, length = 80)
    private String arq_nome;
    @ManyToOne
    @JoinColumn(name="pas_id")
    private Pasta pasta;
}
