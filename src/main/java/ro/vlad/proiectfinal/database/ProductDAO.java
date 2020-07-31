package ro.vlad.proiectfinal.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> findAll() {
        return jdbcTemplate.query("select * from product", new ProductRowMapper());
    }
    public Product findById(Integer id) {
        return jdbcTemplate.query("select * from product where id=" + id, new ProductRowMapper()).get(0);
    }
    public List<Product> findByCategory(String category, Integer minPrice, Integer maxPrice, Integer minKm, Integer maxKm,
                                        String fuelType) {
        return jdbcTemplate.query("select * from product where category_name='" + category +"' && " +
                "price >= " + minPrice + "&& price <=" + maxPrice + "&& kilometers >= " + minKm +
                "&& kilometers <= " + maxKm + "&& fuel_type = '" + fuelType +"'", new ProductRowMapper());
    }
    public void deleteProd(Integer id) {
        jdbcTemplate.update("delete from product where id=" + id );
    }
}
