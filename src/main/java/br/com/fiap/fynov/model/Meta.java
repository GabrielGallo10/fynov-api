package br.com.fiap.fynov.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_fyn_metas")
public class Meta {

    @Id
    @Column(name = "cd_meta")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_META")
    @SequenceGenerator(name = "SEQ_META", sequenceName = "ISEQ$$_3934369", allocationSize = 1)
    private Long id;

    @Column(name = "cd_usuario")
    private Long idUsuario;

    @Column(name = "cd_categoria")
    @NotNull
    @Positive
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long cdCategoria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cd_categoria", insertable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Categoria categoria;

    @Column(name = "nm_meta")
    @NotNull
    @Size(min = 1, max = 100)
    private String nmMeta;

    @Column(name = "vl_alvo_meta")
    @NotNull
    @DecimalMin(value = "0.01", message = "O valor alvo da meta deve ser maior que zero")
    private BigDecimal vlAlvoMeta;

    @Column(name = "vl_atual_meta")
    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal vlAtualMeta;

    @Column(name = "dt_inicio_meta")
    @NotNull
    private Date dtInicioMeta;

    @Column(name = "dt_limite_meta")
    @NotNull
    private Date dtLimiteMeta;

    @Column(name = "st_meta")
    @NotNull
    @Size(min = 1, max = 20)
    private String stMeta;

    public Meta() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public Long getCdCategoria() { return cdCategoria; }
    public void setCdCategoria(Long cdCategoria) { this.cdCategoria = cdCategoria; }

    public Categoria getCategoria() { return categoria; }

    public String getNmMeta() { return nmMeta; }
    public void setNmMeta(String nmMeta) { this.nmMeta = nmMeta; }

    public BigDecimal getVlAlvoMeta() { return vlAlvoMeta; }
    public void setVlAlvoMeta(BigDecimal vlAlvoMeta) { this.vlAlvoMeta = vlAlvoMeta; }

    public BigDecimal getVlAtualMeta() { return vlAtualMeta; }
    public void setVlAtualMeta(BigDecimal vlAtualMeta) { this.vlAtualMeta = vlAtualMeta; }

    public Date getDtInicioMeta() { return dtInicioMeta; }
    public void setDtInicioMeta(Date dtInicioMeta) { this.dtInicioMeta = dtInicioMeta; }

    public Date getDtLimiteMeta() { return dtLimiteMeta; }
    public void setDtLimiteMeta(Date dtLimiteMeta) { this.dtLimiteMeta = dtLimiteMeta; }

    public String getStMeta() { return stMeta; }
    public void setStMeta(String stMeta) { this.stMeta = stMeta; }
}
