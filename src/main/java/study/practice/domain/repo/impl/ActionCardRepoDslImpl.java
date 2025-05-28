package study.practice.domain.repo.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import study.practice.domain.repo.ActionCardRepoDsl;

@RequiredArgsConstructor
public class ActionCardRepoDslImpl implements ActionCardRepoDsl {
    private JPAQueryFactory jpaQueryFactory;

}
