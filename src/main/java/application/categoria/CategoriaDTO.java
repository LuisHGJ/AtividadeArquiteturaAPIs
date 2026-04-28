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
        description = "ID do usuário",
        example = "1",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    Long idUsuario,
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
    String tipo,
    @Schema(
        description = "Valor da categoria",
        example = "5000.00",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    Float valor) {
    public CategoriaDTO(Categoria dados) {
        this(dados.getId(), dados.getIdUsuario(), dados.getDescricao(), dados.getTipo(), dados.getValor());
    }
}