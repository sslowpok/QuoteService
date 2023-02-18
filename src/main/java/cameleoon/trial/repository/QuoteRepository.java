package cameleoon.trial.repository;

import cameleoon.trial.model.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuoteRepository extends JpaRepository<QuoteEntity, Long> {

    List<QuoteEntity> findByOrderByScoreDesc();

    List<QuoteEntity> findByOrderByScoreAsc();

}
