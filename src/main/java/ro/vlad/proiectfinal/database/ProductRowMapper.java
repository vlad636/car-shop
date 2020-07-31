package ro.vlad.proiectfinal.database;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getInt("id"));
        product.setName((resultSet.getString("name")));
        product.setPrice(resultSet.getDouble("price"));
        product.setPhotoFile(resultSet.getString("photo_file"));
        product.setFuelType(resultSet.getString("fuel_type"));
        product.setFuelEfficiency(resultSet.getString("fuel_efficiency"));
        product.setKilometers(resultSet.getDouble("kilometers"));
        product.setTransmission(resultSet.getString("transmission"));
        product.setHorsepower(resultSet.getInt("hp"));
        product.setNewtonMeters(resultSet.getInt("n/m"));
        product.setOwnerName(resultSet.getString("owner"));
        product.setOwnerPhone(resultSet.getString("ownerPhone"));
        product.setWheels(resultSet.getString("wheels"));
        product.setAudio(resultSet.getString("audio"));
        product.setSeats(resultSet.getString("seats"));
        product.setTraction(resultSet.getString("traction"));
        product.setCategoryName(resultSet.getString("category_name"));

        return product;
    }
}
