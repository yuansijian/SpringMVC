package admin.service;

import admin.generator.entity.Administrator;

public interface AdministratorService
{
    Administrator queryByUsernameAndPassword(String username, String password);
    int updateByPrimaryKeySelective(Administrator record);
    Administrator selectByPrimaryKey(Integer id);
    int insert(Administrator record);


}
