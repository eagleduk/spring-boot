package com.udemy.springboot.section06.springjdbc;


import com.udemy.springboot.section06.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SpringJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_QUERY =
            """
                INSERT INTO Course(id, name, author) VALUES(?, ?, ?)
            """;
    private static final String DELETE_QUERY =
            """
                DELETE FROM Course WHERE id = ?
            """;
    private static final String SELECT_QUERY =
            """
                SELECT * FROM Course WHERE id = ?
            """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        return jdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
