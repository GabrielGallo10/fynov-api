package br.com.fiap.fynov.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import br.com.fiap.fynov.repository.MetaRepository;
import br.com.fiap.fynov.repository.GastoRepository;
import br.com.fiap.fynov.repository.RecebimentoRepository;
import br.com.fiap.fynov.config.SecurityUtils;

@Service
public class LimparService {

    @Autowired
    private MetaRepository metaRepository;

    @Autowired
    private GastoRepository gastoRepository;

    @Autowired
    private RecebimentoRepository recebimentoRepository;

    @Transactional
    public void limpar() {
        Long userId = SecurityUtils.getCurrentUserId();
        metaRepository.deleteAllByIdUsuario(userId);
        gastoRepository.deleteAllByIdUsuario(userId);
        recebimentoRepository.deleteAllByIdUsuario(userId);
    }
}
