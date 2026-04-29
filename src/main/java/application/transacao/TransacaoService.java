package application.transacao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service    
public class TransacaoService {
     @Autowired
    private TransacaoRepository transacaoRepo;

    public Iterable<TransacaoDTO> getAll() {
        return transacaoRepo.findAll().stream().map(TransacaoDTO::new).toList();
    }

    public TransacaoDTO insert(TransacaoInsertDTO dados) {
        return new TransacaoDTO(transacaoRepo.save(new Transacao(dados)));
    }

    public TransacaoDTO getOne(long id) {
        Optional<Transacao> resultado = transacaoRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Transação não encontrada"
            );
        }

        return new TransacaoDTO(resultado.get());
    }

    public TransacaoDTO update(long id, TransacaoInsertDTO dadosTransacao) {
        Optional<Transacao> resultado = transacaoRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Transação não encontrada"
            );
        }

        resultado.get().setIdUsuario(dadosTransacao.idUsuario());
        resultado.get().setIdCategoria(dadosTransacao.idCategoria());
        resultado.get().setTitulo(dadosTransacao.titulo());
        resultado.get().setValor(dadosTransacao.valor());

        return new TransacaoDTO(transacaoRepo.save(resultado.get()));
    }

    public void delete(long id) {
        if(!transacaoRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Transação não encontrada"
            );
        }
        transacaoRepo.deleteById(id);
    }
}
