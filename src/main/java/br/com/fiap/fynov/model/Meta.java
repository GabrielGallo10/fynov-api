package br.com.fiap.fynov.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_fyn_metas")
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_META")
    @SequenceGenerator(name = "SEQ_META", sequenceName = "ISEQ$$_3934369", allocationSize = 1)
    private Long id;

    @Column(name = "cd_categoria")
    @NotNull
    private Long cd_categoria;

    @Column(name = "nm_meta")
    @NotNull
    private String nm_meta;

    @Column(name = "vl_alvo_meta")
    @NotNull
    private BigDecimal vl_alvo_meta;

    @Column(name = "vl_atual_meta")
    @NotNull
    private BigDecimal vl_atual_meta;

    @Column(name = "dt_inicio_meta")
    @NotNull
    private Date dt_inicio_meta;

    @Column(name = "dt_limite_meta")
    @NotNull
    private Date dt_limite_meta;

    @Column(name = "st_meta")
    @NotNull
    private String st_meta;

    public Meta() {}

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

    public String getNmMeta() {
        return nm_meta;
    }

    public void setNmMeta(String nm_meta) {
        this.nm_meta = nm_meta;
    }
    
    public BigDecimal getVlAlvoMeta() {
        return vl_alvo_meta;
    }

    public void setVlAlvoMeta(BigDecimal vl_alvo_meta) {
        this.vl_alvo_meta = vl_alvo_meta;
    }

    public BigDecimal getVlAtualMeta() {
        return vl_atual_meta;
    }
    
    public void setVlAtualMeta(BigDecimal vl_atual_meta) {
        this.vl_atual_meta = vl_atual_meta;
    }

    public Date getDtInicioMeta() {
        return dt_inicio_meta;
    }

    public void setDtInicioMeta(Date dt_inicio_meta) {
        this.dt_inicio_meta = dt_inicio_meta;
    }
    
    public Date getDtLimiteMeta() {
        return dt_limite_meta;
    }

    public void setDtLimiteMeta(Date dt_limite_meta) {
        this.dt_limite_meta = dt_limite_meta;
    }

    public String getStMeta() {
        return st_meta;
    }
    
    public void setStMeta(String st_meta) {
        this.st_meta = st_meta;
    }
}
