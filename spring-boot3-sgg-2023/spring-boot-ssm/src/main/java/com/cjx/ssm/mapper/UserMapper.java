package com.cjx.ssm.mapper;

import com.cjx.ssm.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User getUserById(@Param("id") Long id);

}
