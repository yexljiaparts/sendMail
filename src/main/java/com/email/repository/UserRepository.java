package com.email.repository;

import com.email.common.repository.BaseRepository;
import com.email.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/2/18.
 */
@Repository
public interface UserRepository extends BaseRepository<User, Integer> {
}
