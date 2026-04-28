package application.categoria;

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
@Table(name = "categorias")
@Getter
@Setter
@NoArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private Long idUsuario;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private Float valor;

    public Categoria(Long idUsuario, String descricao, String tipo, Float valor) {
        this.idUsuario = idUsuario;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Categoria(CategoriaDTO dados) {
        this.id = dados.id();
        this.idUsuario = dados.idUsuario();
        this.descricao = dados.descricao();
        this.tipo = dados.tipo();
        this.valor = dados.valor();
    }

    public Categoria(CategoriaInsertDTO dados) {
        this.idUsuario = dados.idUsuario();
        this.descricao = dados.descricao();
        this.tipo = dados.tipo();
        this.valor = dados.valor();
    }
}
