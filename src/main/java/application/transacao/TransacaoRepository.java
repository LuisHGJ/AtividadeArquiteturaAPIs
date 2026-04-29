package application.transacao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    public Optional<Transacao> findByIdUsuario(Long idUsuario);
}
