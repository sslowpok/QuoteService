package cameleoon.trial.repository;

import cameleoon.trial.model.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<QuoteEntity, Long> {
}
