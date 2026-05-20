package br.com.fiap.fynov.dto;

import br.com.fiap.fynov.model.Gasto;
import br.com.fiap.fynov.model.Meta;
import br.com.fiap.fynov.model.Recebimento;
import java.util.List;

public class DashboardResponse {

    private List<Gasto> gastos;
    private List<Recebimento> recebimentos;
    private List<Meta> topMetas;

    public DashboardResponse(List<Gasto> gastos, List<Recebimento> recebimentos, List<Meta> topMetas) {
        this.gastos = gastos;
        this.recebimentos = recebimentos;
        this.topMetas = topMetas;
    }

    public List<Gasto> getGastos() { return gastos; }
    public List<Recebimento> getRecebimentos() { return recebimentos; }
    public List<Meta> getTopMetas() { return topMetas; }
}
