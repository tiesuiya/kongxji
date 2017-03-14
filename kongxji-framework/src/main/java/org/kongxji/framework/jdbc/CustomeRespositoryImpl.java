package org.kongxji.framework.jdbc;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * @author lh
 * @since 1.0.0
 */
public class CustomeRespositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomeRespository<T, ID> {
    private final EntityManager entityManager;

    public CustomeRespositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public void commonMethod() {
        System.out.println("=====>>>>> Invok commonMethod！");
    }
}
