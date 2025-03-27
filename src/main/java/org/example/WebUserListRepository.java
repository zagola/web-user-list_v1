package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WebUserListRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<UserEntry> getAll() {
        return jdbcTemplate.query("select user_id, user_name, role_name from users left join roles on users.role_id = roles.role_id",
                BeanPropertyRowMapper.newInstance(UserEntry.class));
    }

    public List<RoleEntry> getRoles() {
        return jdbcTemplate.query("select role_id, role_name from roles", BeanPropertyRowMapper.newInstance(RoleEntry.class));
    }

    public void addRole(String roleName) {
        jdbcTemplate.update("insert into roles (role_name) VALUES (?)", roleName);
    }

    public void addUser(String userName, String roleName) {
        jdbcTemplate.update("insert into users (user_name, role_id) values (?, (select role_id from roles where role_name = ?))", userName, roleName);
    }

    public void deleteUser(int userId) {
        jdbcTemplate.update("delete from users where user_id=?", userId);
    }

    public void deleteRole(int roleId) {
        jdbcTemplate.update("delete from roles where role_id=?", roleId);
    }
}