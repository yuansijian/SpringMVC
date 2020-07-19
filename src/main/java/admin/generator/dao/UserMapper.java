package admin.generator.dao;

import admin.generator.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper
{


    User selectByPrimaryKey(int id);


}