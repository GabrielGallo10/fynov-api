package br.com.fiap.fynov.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Column;
import java.math.BigDecimal;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "t_fyn_gastos")
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GASTO")
    @SequenceGenerator(name = "SEQ_GASTO", sequenceName = "ISEQ$$_3934363", allocationSize = 1)
    private Long id;
    
    @Column(name = "cd_categoria")
    @NotNull
    private Long cd_categoria;

    @Column(name = "ds_gasto")
    @NotNull
    private String ds_gasto;

    @Column(name = "vl_gasto")
    @NotNull
    private BigDecimal vl_gasto;

    @Column(name = "dt_gasto")
    @NotNull
    private Date dt_gasto;

    public Gasto() {}

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

    public String getDsGasto() {
        return ds_gasto;
    }

    public void setDsGasto(String ds_gasto) {
        this.ds_gasto = ds_gasto;
    }

    public BigDecimal getVlGasto() {
        return vl_gasto;
    }

    public void setVlGasto(BigDecimal vl_gasto) {
        this.vl_gasto = vl_gasto;
    }

    public Date getDtGasto() {
        return dt_gasto;
    }

    public void setDtGasto(Date dt_gasto) {
        this.dt_gasto = dt_gasto;
    }
}
