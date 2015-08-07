package com.hoon.appting.entity;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QSchedule is a Querydsl query type for Schedule
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSchedule extends EntityPathBase<Schedule> {

    private static final long serialVersionUID = 1769415048;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSchedule schedule = new QSchedule("schedule");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath program = createString("program");

    public final QSosi sosi;

    public QSchedule(String variable) {
        this(Schedule.class, forVariable(variable), INITS);
    }

    public QSchedule(Path<? extends Schedule> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSchedule(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSchedule(PathMetadata<?> metadata, PathInits inits) {
        this(Schedule.class, metadata, inits);
    }

    public QSchedule(Class<? extends Schedule> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.sosi = inits.isInitialized("sosi") ? new QSosi(forProperty("sosi")) : null;
    }

}

