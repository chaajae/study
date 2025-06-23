package study.practice.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import study.practice.domain.UserInfoEntity;

public interface UserInfoRepo extends JpaRepository<UserInfoEntity, Integer> , UserInfoRepoDsl {
}
