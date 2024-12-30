package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoDTO {
    private String titulo;
    private String descricao;
    private int duracao;
    private String categoria;
    private String dataPublicacao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Video toVideo() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
            Date data = sdf.parse(dataPublicacao);
            return new Video(titulo, descricao, duracao, categoria, data);
        } catch (Exception e) {
            throw new IllegalArgumentException("Data de publicação inválida. ");
        }
    }
}
