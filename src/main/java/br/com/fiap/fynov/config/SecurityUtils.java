package br.com.fiap.fynov.config;

import br.com.fiap.fynov.model.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static Long getCurrentUserId() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof Usuario usuario) {
            return usuario.getId();
        }
        throw new RuntimeException("Nenhum usuario autenticado na sessao atual");
    }

    private SecurityUtils() {}
}
