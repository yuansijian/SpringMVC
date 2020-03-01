package admin.generator.dao;

import admin.generator.entity.Administrator;
import org.apache.ibatis.annotations.Param;

public interface AdministratorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKeyWithBLOBs(Administrator record);

    int updateByPrimaryKey(Administrator record);

    Administrator queryByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

}