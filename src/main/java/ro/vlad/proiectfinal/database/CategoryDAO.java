package ro.vlad.proiectfinal.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Category> findByName() {
        return jdbcTemplate.query("select name from category", new CategoryRowMapper());
    }
}
