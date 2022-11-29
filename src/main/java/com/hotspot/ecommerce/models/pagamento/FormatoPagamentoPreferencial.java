package com.hotspot.ecommerce.models.pagamento;

public class FormatoPagamentoPreferencial {

    private TipoPagamento tipoPagamento;

    public FormatoPagamentoPreferencial() {
    }

    public FormatoPagamentoPreferencial(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
