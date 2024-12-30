package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Video {
    private String titulo;
    private String descricao;
    private int duracao; // em minutos
    private String categoria;
    private Date dataPublicacao;

    public Video(String titulo, String descricao, int duracao, String categoria, Date dataPublicacao) {
        if (titulo == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("O titulo não pode ser vazio.");
        }
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("A descrição não pode ser vazia.");
        }
        if (duracao <= 0) {
            throw new  IllegalArgumentException("Atenção!  duração tem que ser um número positico.");
        }
        if (!isCategoriaValida(categoria)) {
            throw new IllegalArgumentException("A categoria deve ser valida(Filme, Série, Documentário).");
        }
        if (dataPublicacao == null) {
            throw new IllegalArgumentException("A data de publicação deve ser valida no formato dd/MM/yyy");
        }
        this.titulo = titulo;
        this.descricao = descricao;
        this.duracao = duracao;
        this.categoria = categoria;
        this.dataPublicacao = dataPublicacao;
    }

    private boolean isCategoriaValida(String categoria) {
        return categoria.equalsIgnoreCase("Filme") ||
                categoria.equalsIgnoreCase("Série") ||
                categoria.equalsIgnoreCase("Documentário");
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getCategoria() {
        return categoria;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return titulo + ";" + descricao + ";" + duracao + ";" + categoria + ";" + sdf.format(dataPublicacao);
    }

    public static Video fromString(String linha) {
        try {
            String[] partes = linha.split(";");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return new Video(partes[0], partes[1], Integer.parseInt(partes[2]), partes[3], sdf.parse(partes[4]));
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao converter a linha para um objeto video: " + e.getMessage());
        }
    }
}