package application.categoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service    
public class CategoriaService {
     @Autowired
    private CategoriaRepository categoriaRepo;

    public Iterable<CategoriaDTO> getAll() {
        return categoriaRepo.findAll().stream().map(CategoriaDTO::new).toList();
    }

    public CategoriaDTO insert(CategoriaInsertDTO dados) {
        return new CategoriaDTO(categoriaRepo.save(new Categoria(dados)));
    }

    public CategoriaDTO getOne(long id) {
        Optional<Categoria> resultado = categoriaRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Categoria não encontrada"
            );
        }

        return new CategoriaDTO(resultado.get());
    }

    public CategoriaDTO update(long id, CategoriaInsertDTO dadosCategoria) {
        Optional<Categoria> resultado = categoriaRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Categoria não encontrada"
            );
        }

        resultado.get().setDescricao(dadosCategoria.descricao());
        resultado.get().setTipo(dadosCategoria.tipo());

        return new CategoriaDTO(categoriaRepo.save(resultado.get()));
    }

    public void delete(long id) {
        if(!categoriaRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Categoria não encontrada"
            );
        }
        categoriaRepo.deleteById(id);
    }
}
