package com.email.repository;

import com.email.common.repository.BaseRepository;
import com.email.entity.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
@Repository
public interface EmployeesRepository  extends BaseRepository<Employees, Integer> {
    @Query("from Employees mt where mt.department.id=(?1)")
    Page<Employees> getPage(Pageable pageable,Integer id);

    @Query("from Employees mt where mt.department.id=(?1)")
    List<Employees> getAll(Integer id);
}
