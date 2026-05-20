package br.com.fiap.fynov.service;

import br.com.fiap.fynov.config.SecurityUtils;
import br.com.fiap.fynov.dto.DashboardResponse;
import br.com.fiap.fynov.model.Gasto;
import br.com.fiap.fynov.model.Meta;
import br.com.fiap.fynov.model.Recebimento;
import br.com.fiap.fynov.repository.GastoRepository;
import br.com.fiap.fynov.repository.MetaRepository;
import br.com.fiap.fynov.repository.RecebimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;

@Service
public class DashboardService {

    @Autowired
    private GastoRepository gastoRepository;

    @Autowired
    private RecebimentoRepository recebimentoRepository;

    @Autowired
    private MetaRepository metaRepository;

    public DashboardResponse getDashboard() {
        Long userId = SecurityUtils.getCurrentUserId();

        List<Gasto> gastos = gastoRepository.findAllByIdUsuario(userId);
        List<Recebimento> recebimentos = recebimentoRepository.findAllByIdUsuario(userId);
        List<Meta> topMetas = metaRepository.findTop3ByIdUsuarioAndStMetaNotInOrderByDtLimiteMetaAsc(
                userId, Set.of("CANCELADO", "CONCLUIDO"));

        return new DashboardResponse(gastos, recebimentos, topMetas);
    }
}
