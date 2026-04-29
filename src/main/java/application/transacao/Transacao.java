package application.transacao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transacoes")
@Getter
@Setter
@NoArgsConstructor
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private Long idUsuario;
    @Column(nullable = false)
    private Long idCategoria;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private Float valor;

    public Transacao(Long idUsuario, Long idCategoria, String titulo, Float valor) {
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
        this.titulo = titulo;
        this.valor = valor;
    }

    public Transacao(TransacaoDTO dados) {
        this.id = dados.id();
        this.idUsuario = dados.idUsuario();
        this.idCategoria = dados.idCategoria();
        this.titulo = dados.titulo();
        this.valor = dados.valor();
    }

    public Transacao(TransacaoInsertDTO dados) {
        this.idUsuario = dados.idUsuario();
        this.idCategoria = dados.idCategoria();
        this.titulo = dados.titulo();
        this.valor = dados.valor();
    }
}