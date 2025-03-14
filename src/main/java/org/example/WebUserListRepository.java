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
}