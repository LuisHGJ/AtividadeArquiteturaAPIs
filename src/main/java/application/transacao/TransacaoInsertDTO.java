package application.transacao;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para Criação/Alteração de Transações")
public record TransacaoInsertDTO(
    @Schema(
        description = "ID do usuário",
        example = "1",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    long idUsuario,
    @Schema(
        description = "ID da categoria",
        example = "1",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    Long idCategoria,
    @Schema(
        description = "Título da transação",
        example = "Salário",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    String titulo,
    @Schema(
        description = "Valor da transação",
        example = "5000.00",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    Float valor) {
    public TransacaoInsertDTO(Transacao dados) {
        this(dados.getIdUsuario(), dados.getIdCategoria(), dados.getTitulo(), dados.getValor());
    }
}
