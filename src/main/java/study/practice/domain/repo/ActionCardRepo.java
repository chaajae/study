package study.practice.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.practice.domain.ActionCard;
@Repository
public interface ActionCardRepo extends JpaRepository<ActionCard, Integer> , ActionCardRepoDsl {
}
