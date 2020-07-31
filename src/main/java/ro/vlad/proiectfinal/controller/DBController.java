package ro.vlad.proiectfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DBController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("postCar")
    public ModelAndView postCar(@RequestParam("name") String name, @RequestParam("price") Double price,
                                @RequestParam("photo_file") String photoFile, @RequestParam("category_name") String category,
                                @RequestParam("fuel_type") String fuelType, @RequestParam("fuel_efficiency") String fuelEfficiency,
                                @RequestParam("transmission") String transmission, @RequestParam("kilometers") Double km,
                                @RequestParam("hp") Integer hp, @RequestParam("n/m") Integer nM,
                                @RequestParam("owner") String ownerName, @RequestParam("ownerPhone") String ownerPhone,
                                @RequestParam("wheels") String wheels, @RequestParam("seats") String seats,
                                @RequestParam("audio") String audio, @RequestParam("traction") String traction) {
        // adaugam in DB datele introduse de user
        jdbcTemplate.update("insert into product values(null,?,?,?,?, ?,?,?,?,?,?,?,?,?,?,?,?)", name,
                price, photoFile, category, fuelType, fuelEfficiency, transmission, km, hp, nM, ownerName, ownerPhone, wheels,
                seats, audio, traction);

        return new ModelAndView("redirect:/dashboard");
    }

    @GetMapping("/contact-form")
    public ModelAndView contactUs(@RequestParam("firstName") String firstName,
                                  @RequestParam("lastName") String lastName,
                                  @RequestParam("email") String email,
                                  @RequestParam("phone") String phone,
                                  @RequestParam("message") String message) {
        // salvam datele userului si mesajul in DB
        jdbcTemplate.update("insert into user_message values(null,?,?,?,?,?)", firstName, lastName, email, phone, message);
        return new ModelAndView("redirect:/contact");
    }
}
