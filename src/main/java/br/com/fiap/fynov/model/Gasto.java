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
@Table(name = "t_fyn_gastos")
public class Gasto {

    @Id
    @Column(name = "cd_gasto")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GASTO")
    @SequenceGenerator(name = "SEQ_GASTO", sequenceName = "ISEQ$$_3934363", allocationSize = 1)
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

    @Column(name = "ds_gasto")
    @NotNull
    @Size(min = 1, max = 255)
    private String dsGasto;

    @Column(name = "vl_gasto")
    @NotNull
    @DecimalMin(value = "0.01", message = "O valor do gasto deve ser maior que zero")
    private BigDecimal vlGasto;

    @Column(name = "dt_gasto")
    @NotNull
    private Date dtGasto;

    public Gasto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public Long getCdCategoria() { return cdCategoria; }
    public void setCdCategoria(Long cdCategoria) { this.cdCategoria = cdCategoria; }

    public Categoria getCategoria() { return categoria; }

    public String getDsGasto() { return dsGasto; }
    public void setDsGasto(String dsGasto) { this.dsGasto = dsGasto; }

    public BigDecimal getVlGasto() { return vlGasto; }
    public void setVlGasto(BigDecimal vlGasto) { this.vlGasto = vlGasto; }

    public Date getDtGasto() { return dtGasto; }
    public void setDtGasto(Date dtGasto) { this.dtGasto = dtGasto; }
}
