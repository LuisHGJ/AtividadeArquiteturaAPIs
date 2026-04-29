package application.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springdoc.api.ErrorMessage;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
    name = "Transações",
    description = "Operações relacionadas às transações",
    externalDocs = @ExternalDocumentation(
        description = "Documentação Detalhada",
        url = "https://swagger.io/docs/"
    )
)
@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    @Operation(summary = "Cria uma nova transação")
    @ApiResponse(
        responseCode = "200",
        description = "Transação criada com sucesso",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = TransacaoDTO.class)
        )
    )
    public TransacaoDTO insert(@RequestBody TransacaoInsertDTO novaTransacao) {
        return transacaoService.insert(novaTransacao);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Lista uma transação especifica selecionada pelo id")
    @ApiResponse(responseCode = "200", description = "Transação retornada com sucesso")
    @ApiResponse(
        responseCode = "404",
        description = "Transação não encontrada",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ErrorMessage.class)
        )
    )
    public TransacaoDTO getOne(
        @Parameter(description = "ID da transação a ser consultada", example = "10", required = true)
        @PathVariable long id) {
        return transacaoService.getOne(id);
    }

    @GetMapping
    @Operation(summary = "Lista todas as transações cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista de transações retornada com sucesso")
    public Iterable<TransacaoDTO> getAll() {
        return transacaoService.getAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma transação existente")
    @ApiResponse(
        responseCode = "200",
        description = "Transação atualizada com sucesso",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = TransacaoDTO.class)
        )
    )
    @ApiResponse(
        responseCode = "404",
        description = "Transação não encontrada",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ErrorMessage.class)
        )
    )
    public TransacaoDTO update(
        @Parameter(description = "ID da transação a ser atualizada", example = "10", required = true)
        @PathVariable long id, @RequestBody TransacaoInsertDTO novosDados) {
        return transacaoService.update(id, novosDados);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove uma transação existente")
    @ApiResponse(responseCode = "200", description = "Transação removida com sucesso")
    @ApiResponse(
        responseCode = "404",
        description = "Transação não encontrada",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ErrorMessage.class)
        )
    )
    public void remove(
        @Parameter(description = "ID da transação a ser removida", example = "10", required = true)
        @PathVariable long id) {
        transacaoService.delete(id);
    }
}