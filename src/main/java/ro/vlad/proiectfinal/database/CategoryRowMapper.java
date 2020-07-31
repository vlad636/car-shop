package ro.vlad.proiectfinal.database;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {

        @Override
        public Category mapRow (ResultSet resultSet, int i) throws SQLException {
            Category category = new Category();
            category.setName(resultSet.getString("name"));

            return category;
        }
}
