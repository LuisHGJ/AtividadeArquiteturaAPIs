package application.categoria;

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
    name = "Categorias",
    description = "Operações relacionadas às categorias",
    externalDocs = @ExternalDocumentation(
        description = "Documentação Detalhada",
        url = "https://swagger.io/docs/"
    )
)
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    @Operation(summary = "Cria uma nova categoria")
    @ApiResponse(
        responseCode = "200",
        description = "Categoria criada com sucesso",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = CategoriaDTO.class)
        )
    )
    public CategoriaDTO insert(@RequestBody CategoriaInsertDTO novaCategoria) {
        return categoriaService.insert(novaCategoria);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Lista uma categoria especifica selecionada pelo id")
    @ApiResponse(responseCode = "200", description = "Categoria retornada com sucesso")
    @ApiResponse(
        responseCode = "404",
        description = "Categoria não encontrada",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ErrorMessage.class)
        )
    )
    public CategoriaDTO getOne(
        @Parameter(description = "ID da categoria a ser consultada", example = "10", required = true)
        @PathVariable long id) {
        return categoriaService.getOne(id);
    }

    @GetMapping
    @Operation(summary = "Lista todas as categorias cadastradas")
    @ApiResponse(responseCode = "200", description = "Lista de categorias retornada com sucesso")
    public Iterable<CategoriaDTO> getAll() {
        return categoriaService.getAll();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma categoria existente")
    @ApiResponse(
        responseCode = "200",
        description = "Categoria atualizada com sucesso",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = CategoriaDTO.class)
        )
    )
    @ApiResponse(
        responseCode = "404",
        description = "Categoria não encontrada",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ErrorMessage.class)
        )
    )
    public CategoriaDTO update(
        @Parameter(description = "ID da categoria a ser atualizada", example = "10", required = true)
        @PathVariable long id, @RequestBody CategoriaInsertDTO novosDados) {
        return categoriaService.update(id, novosDados);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove uma categoria existente")
    @ApiResponse(responseCode = "200", description = "Categoria removida com sucesso")
    @ApiResponse(
        responseCode = "404",
        description = "Categoria não encontrada",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = ErrorMessage.class)
        )
    )
    public void remove(
        @Parameter(description = "ID da categoria a ser removida", example = "2", required = true)
        @PathVariable long id) {
        categoriaService.delete(id);
    }
}