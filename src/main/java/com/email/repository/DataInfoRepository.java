package com.email.repository;

import com.email.common.repository.BaseRepository;
import com.email.entity.DataInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/2/18.
 */
@Repository
public interface DataInfoRepository extends BaseRepository<DataInfo, Integer> {
Page<DataInfo> findAll(Pageable pageable);
}
