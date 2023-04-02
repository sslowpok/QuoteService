package quotes.app.repository;

import quotes.app.model.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<QuoteEntity, Long> {

    List<QuoteEntity> findByOrderByScoreDesc();

    List<QuoteEntity> findByOrderByScoreAsc();

}
