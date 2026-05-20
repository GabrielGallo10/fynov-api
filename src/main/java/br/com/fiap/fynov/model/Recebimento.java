package br.com.fiap.fynov.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_fyn_recebimentos")
public class Recebimento {

    @Id
    @Column(name = "cd_recebimento")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RECEBIMENTO")
    @SequenceGenerator(name = "SEQ_RECEBIMENTO", sequenceName = "ISEQ$$_3934366", allocationSize = 1)
    private Long id;

    @Column(name = "cd_usuario")
    @NotNull
    private Long idUsuario;

    @Column(name = "cd_categoria")
    @NotNull
    @Positive
    private Long cdCategoria;

    @Column(name = "ds_recebimento")
    @NotNull
    @Size(min = 1, max = 255)
    private String dsRecebimento;

    @Column(name = "vl_recebimento")
    @NotNull
    @DecimalMin(value = "0.01", message = "O valor do recebimento deve ser maior que zero")
    private BigDecimal vlRecebimento;

    @Column(name = "dt_recebimento")
    @NotNull
    private Date dtRecebimento;

    public Recebimento() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public Long getCdCategoria() { return cdCategoria; }
    public void setCdCategoria(Long cdCategoria) { this.cdCategoria = cdCategoria; }

    public String getDsRecebimento() { return dsRecebimento; }
    public void setDsRecebimento(String dsRecebimento) { this.dsRecebimento = dsRecebimento; }

    public BigDecimal getVlRecebimento() { return vlRecebimento; }
    public void setVlRecebimento(BigDecimal vlRecebimento) { this.vlRecebimento = vlRecebimento; }

    public Date getDtRecebimento() { return dtRecebimento; }
    public void setDtRecebimento(Date dtRecebimento) { this.dtRecebimento = dtRecebimento; }
}
