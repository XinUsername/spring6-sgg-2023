package com.cjx.mybatisx.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.cjx.mybatisx.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author star
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-02-29 11:59:31
* @Entity com.cjx.mybatisx.domain.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

    //插入
    int insertSelective(User user);

    //查询
    List<User> selectNameAndAgeByIdBetweenOrderByIdDesc(@Param("beginId") Long beginId, @Param("endId") Long endId);

    //修改
    int updateNameAndEmailByNameLike(@Param("name") String name, @Param("email") String email, @Param("oldName") String oldName);

    //删除
    int deleteByNameAndIsDeletedNot(@Param("name") String name, @Param("isDeleted") Integer isDeleted);
}




