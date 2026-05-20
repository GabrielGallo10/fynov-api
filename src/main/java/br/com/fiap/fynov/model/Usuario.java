package br.com.fiap.fynov.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "t_fyn_usuario")
public class Usuario implements UserDetails {

    @Id
    @Column(name = "cd_usuario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "ISEQ$$_3934355", allocationSize = 1)
    private Long id;

    @Column(name = "nm_usuario")
    @NotNull
    private String nmUsuario;

    @Column(name = "em_usuario", unique = true)
    @NotNull
    private String emUsuario;

    @JsonIgnore
    @Column(name = "pw_usuario")
    @NotNull
    private String pwUsuario;

    public Usuario() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return pwUsuario;
    }

    @Override
    public String getUsername() {
        return emUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getEmUsuario() {
        return emUsuario;
    }

    public void setEmUsuario(String emUsuario) {
        this.emUsuario = emUsuario;
    }

    public String getPwUsuario() {
        return pwUsuario;
    }

    public void setPwUsuario(String pwUsuario) {
        this.pwUsuario = pwUsuario;
    }
}
