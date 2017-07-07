package com.email.repository;

import com.email.common.repository.BaseRepository;
import com.email.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
@Repository
public interface DepartmentRepository extends BaseRepository<Department, Integer> {
    Page<Department> findById(Integer id, Pageable pageable);

    List<Department> findByParentId(Integer parentId);

    @Query(value = "select  * from e_department dep order by dep.id desc limit 0,1 ",nativeQuery = true)
    Department findLastDep();
//    Department findById(Integer id);
}
