package study.practice.domain.repo.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.practice.domain.repo.UserInfoRepoDsl;

@Repository
@RequiredArgsConstructor
public class UserInfoRepoDslImpl implements UserInfoRepoDsl {
    private final JPAQueryFactory jpaQueryFactory;

}
