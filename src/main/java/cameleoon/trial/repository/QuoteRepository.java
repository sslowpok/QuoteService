package cameleoon.trial.repository;

import cameleoon.trial.model.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuoteRepository extends JpaRepository<QuoteEntity, Long> {

	boolean existsByContent(String content);

	QuoteEntity findByContent(String content);

}
