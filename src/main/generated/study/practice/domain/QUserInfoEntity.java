package study.practice.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserInfoEntity is a Querydsl query type for UserInfoEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserInfoEntity extends EntityPathBase<UserInfoEntity> {

    private static final long serialVersionUID = 1376501560L;

    public static final QUserInfoEntity userInfoEntity = new QUserInfoEntity("userInfoEntity");

    public final NumberPath<Integer> uid = createNumber("uid", Integer.class);

    public final StringPath userDescription = createString("userDescription");

    public final StringPath userId = createString("userId");

    public final StringPath userName = createString("userName");

    public QUserInfoEntity(String variable) {
        super(UserInfoEntity.class, forVariable(variable));
    }

    public QUserInfoEntity(Path<? extends UserInfoEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserInfoEntity(PathMetadata metadata) {
        super(UserInfoEntity.class, metadata);
    }

}

