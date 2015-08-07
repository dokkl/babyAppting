package com.hoon.appting.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QSosi is a Querydsl query type for Sosi
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSosi extends EntityPathBase<Sosi> {

    private static final long serialVersionUID = 1719510307;

    public static final QSosi sosi = new QSosi("sosi");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<Schedule, QSchedule> scheduleList = this.<Schedule, QSchedule>createList("scheduleList", Schedule.class, QSchedule.class, PathInits.DIRECT2);

    public QSosi(String variable) {
        super(Sosi.class, forVariable(variable));
    }

    public QSosi(Path<? extends Sosi> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSosi(PathMetadata<?> metadata) {
        super(Sosi.class, metadata);
    }

}

