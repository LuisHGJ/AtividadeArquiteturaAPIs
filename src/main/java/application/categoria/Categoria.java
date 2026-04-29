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
    private String descricao;
    @Column(nullable = false)
    private String tipo;

    public Categoria(String descricao, String tipo) {
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public Categoria(CategoriaDTO dados) {
        this.id = dados.id();
        this.descricao = dados.descricao();
        this.tipo = dados.tipo();
    }

    public Categoria(CategoriaInsertDTO dados) {
        this.descricao = dados.descricao();
        this.tipo = dados.tipo();
    }
}
