package com.email.common.service;


import com.email.common.inject.support.InjectBaseDependencyHelper;
import com.email.common.repository.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HX-119 on 2014/4/24.
 */
public abstract class BaseService<E,ID extends Serializable>  implements InitializingBean {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private BaseRepository<E,ID> baseRepository;

    public void setBaseRepository(BaseRepository<E,ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public List<E> findAll() {
        return baseRepository.findAll();
    }
    public List<E> findAll(Specification<E> specification) {
        return baseRepository.findAll(specification);
    }

    public Page<E> findAll(Specification<E> specification,Pageable pageable) {
        return baseRepository.findAll(specification,pageable);
    }

    public<S extends E>  S save(S s){
        return baseRepository.save(s);
    }

    public Page<E> findAll(Pageable pageable){
        return baseRepository.findAll(pageable);
    }
    public E findOne(ID id){
        return baseRepository.findOne(id);
    }

    public void delete(ID id){
        baseRepository.delete(id);
    }

    public void delete(ID [] ids){
        for(ID id : ids){
            baseRepository.delete(id);
        }
    }

    public long count(){
        return  baseRepository.count();
    }

    public boolean exists(ID id){
        return baseRepository.exists(id);
    }

    //@Override
    public void afterPropertiesSet() throws Exception {
        InjectBaseDependencyHelper.findAndInjectBaseRepositoryDependency(this);
        Assert.notNull(baseRepository, "BaseRepository required, Class is:" + getClass());
    }

}
