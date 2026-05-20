package br.com.fiap.fynov.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "t_fyn_categoria")
public class Categoria {
    @Id
    @Column(name = "cd_categoria")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CATEGORIA")
    @SequenceGenerator(name = "SEQ_CATEGORIA", sequenceName = "ISEQ$$_3934359", allocationSize = 1)
    private Long id;

    @Column(name = "nm_categoria")
    @NotNull
    private String nmCategoria;

    public Categoria() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNmCategoria() { return nmCategoria; }
    public void setNmCategoria(String nmCategoria) { this.nmCategoria = nmCategoria; }
}
