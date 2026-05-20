package br.com.fiap.fynov.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name = "t_fyn_recebimentos")
public class Recebimento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RECEBIMENTO")
    @SequenceGenerator(name = "SEQ_RECEBIMENTO", sequenceName = "ISEQ$$_3934366", allocationSize = 1)
    private Long id;

    @Column(name = "cd_categoria")
    @NotNull
    private Long cd_categoria;

    @Column(name = "ds_recebimento")
    @NotNull
    private String ds_recebimento;

    @Column(name = "vl_recebimento")
    @NotNull
    private BigDecimal vl_recebimento;

    @Column(name = "dt_recebimento")
    @NotNull
    private Date dt_recebimento;

    public Recebimento() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCdCategoria() {
        return cd_categoria;
    }

    public void setCdCategoria(Long cd_categoria) {
        this.cd_categoria = cd_categoria;
    }

    public String getDsRecebimento() {
        return ds_recebimento;
    }

    public void setDsRecebimento(String ds_recebimento) {
        this.ds_recebimento = ds_recebimento;
    }
    
    public BigDecimal getVlRecebimento() {
        return vl_recebimento;
    }

    public void setVlRecebimento(BigDecimal vl_recebimento) {
        this.vl_recebimento = vl_recebimento;
    }

    public Date getDtRecebimento() {
        return dt_recebimento;
    }

    public void setDtRecebimento(Date dt_recebimento) {
        this.dt_recebimento = dt_recebimento;
    }
}
