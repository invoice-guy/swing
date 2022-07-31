package com.swing.springboot.domain.svc;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.swing.springboot.web.dto.SvcResponseDto;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.swing.springboot.domain.svc.QSvc.svc;

@Repository
public class SvcRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public SvcRepositorySupport(JPAQueryFactory queryFactory) {
        super(Svc.class);
        this.queryFactory = queryFactory;
    }

    public List<Svc> findByCi(String ci) {
        return queryFactory.selectFrom(svc)
                .where(svc.ci.eq(ci))
                .fetch();
    }

    public List<Svc> findBySvcmgmtnum(String svcmgmtnum) {
        return queryFactory.selectFrom(svc)
                .where(svc.svcmgmtnum.eq(svcmgmtnum))
                .fetch();
    }

}
