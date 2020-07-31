package ro.vlad.proiectfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.vlad.proiectfinal.database.Product;
import ro.vlad.proiectfinal.database.ProductDAO;

import java.util.List;

@Controller
public class FormController {
    @Autowired
    ProductDAO productDAO;

    @GetMapping("/filter-form")
    public ModelAndView filter(@RequestParam("model") String model, @RequestParam("minPrice") Integer minPrice,
                               @RequestParam("maxPrice") Integer maxPrice,
                               @RequestParam("minKilometers") Integer minKilometers,
                               @RequestParam("maxKilometers") Integer maxKilometers,
                               @RequestParam("fuelType") String fuelType) {
        ModelAndView modelAndView = new ModelAndView("carsFromFilter");
        //cautam in DB masina sau masinile care respecta datele introduse de user
        List<Product> productByAll = productDAO.findByCategory(model, minPrice, maxPrice, minKilometers, maxKilometers, fuelType);
        if (productByAll.isEmpty()) {
            // daca nu s-a gasit nicio masina se afiseaza mesajul
            String message = "No cars found";
            modelAndView.addObject("message", message);
        } else {
            // daca s-a gasit adaugam masinile gasite
            modelAndView.addObject("products", productByAll);
        }
        return modelAndView;
    }
}
