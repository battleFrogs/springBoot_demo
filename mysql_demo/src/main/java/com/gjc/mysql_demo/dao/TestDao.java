package com.gjc.mysql_demo.dao;

import com.gjc.mysql_demo.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void save(Test test) {
        String sql = "insert into test(name,created) values(?,?)";
        jdbcTemplate.update(sql, test.getName(), test.getCreated());
    }

    public void delete(String id) {
        String sql = "delete from test where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Test> findAll() {
        String sql = "select * from test";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Test.class));
    }



}
