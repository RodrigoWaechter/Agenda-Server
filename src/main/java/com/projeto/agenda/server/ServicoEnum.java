package com.projeto.agenda.server;

public enum ServicoEnum {
    SERVICO_A("Serviço A", 10.0f),
    SERVICO_B("Serviço B", 15.0f);

    private final String descricao;
    private final float preco;

    ServicoEnum(String descricao, float preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
