package admin.service;

import admin.generator.entity.Administrator;

public interface AdministratorService
{
    Administrator queryByUsernameAndPassword(String username, String password);
}
