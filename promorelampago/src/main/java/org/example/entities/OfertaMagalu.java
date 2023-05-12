package org.example.entities;

public class OfertaMagalu {
    private String nome;
    private String link;
    private String precoAntigo;
    private String precoAtual;
    private String parcela;

    public OfertaMagalu(String nome, String link, String precoAntigo, String precoAtual, String parcela) {
        this.nome = nome;
        this.precoAntigo = precoAntigo;
        this.precoAtual = precoAtual;
        this.parcela = parcela;
        this.link = link;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPrecoAntigo() {
        return precoAntigo;
    }

    public void setPrecoAntigo(String precoAntigo) {
        this.precoAntigo = precoAntigo;
    }

    public String getPrecoAtual() {
        return precoAtual;
    }

    public void setPrecoAtual(String precoAtual) {
        this.precoAtual = precoAtual;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    @Override
    public String toString() {
        return "OfertaMagalu{" +
                "nome='" + nome + '\'' +
                ", link='" + link + '\'' +
                ", precoAntigo='" + precoAntigo + '\'' +
                ", precoAtual='" + precoAtual + '\'' +
                ", parcela='" + parcela + '\'' +
                '}';
    }
}
