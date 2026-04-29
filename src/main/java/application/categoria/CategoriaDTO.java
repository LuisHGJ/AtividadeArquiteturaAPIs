package application.categoria;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para Categorias")
public record CategoriaDTO(
    @Schema(
        description = "ID da categoria",
        requiredMode = Schema.RequiredMode.AUTO
    )
    long id,
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
    public CategoriaDTO(Categoria dados) {
        this(dados.getId(), dados.getDescricao(), dados.getTipo());
    }
}