package com.swing.springboot.domain.svc;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSvc is a Querydsl query type for Svc
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSvc extends EntityPathBase<Svc> {

    private static final long serialVersionUID = 353410682L;

    public static final QSvc svc = new QSvc("svc");

    public final StringPath ci = createString("ci");

    public final StringPath custnum = createString("custnum");

    public final StringPath dcyn = createString("dcyn");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath olmagoyn = createString("olmagoyn");

    public final StringPath prodid = createString("prodid");

    public final StringPath svcmgmtnum = createString("svcmgmtnum");

    public final StringPath svcnum = createString("svcnum");

    public QSvc(String variable) {
        super(Svc.class, forVariable(variable));
    }

    public QSvc(Path<? extends Svc> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSvc(PathMetadata metadata) {
        super(Svc.class, metadata);
    }

}

