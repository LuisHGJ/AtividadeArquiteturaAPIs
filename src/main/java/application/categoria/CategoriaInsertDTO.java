package application.categoria;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para Criação/Alteração de Categorias")
public record CategoriaInsertDTO(
    @Schema(
        description = "Descrição da categoria",
        example = "Salário",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    String descricao,
    @Schema(
        description = "Tipo da categoria",
        example = "Entrada/Saída",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    String tipo) {
    public CategoriaInsertDTO(Categoria dados) {
        this(dados.getDescricao(), dados.getTipo());
    }
}
