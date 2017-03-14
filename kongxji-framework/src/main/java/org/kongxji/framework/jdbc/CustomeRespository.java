package org.kongxji.framework.jdbc;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * 区块链存储接口
 * @author lh
 * @since 1.0.0
 */
@NoRepositoryBean
public interface CustomeRespository<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {
    void commonMethod();
}
