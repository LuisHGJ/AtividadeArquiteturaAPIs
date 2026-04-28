package application.categoria;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para Criação/Alteração de Categorias")
public record CategoriaInsertDTO(
    @Schema(
        description = "ID do usuário",
        example = "1",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    long idUsuario,
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
    public CategoriaInsertDTO(Categoria dados) {
        this(dados.getIdUsuario(), dados.getDescricao(), dados.getTipo(), dados.getValor());
    }
}
