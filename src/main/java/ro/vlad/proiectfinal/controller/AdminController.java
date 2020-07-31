package ro.vlad.proiectfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.vlad.proiectfinal.database.Product;
import ro.vlad.proiectfinal.database.ProductDAO;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    ProductDAO productDAO;

    @GetMapping("/admin")
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView("admin");

        List<Product> products = productDAO.findAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteProd(@RequestParam("productId") Integer productId) {
        productDAO.deleteProd(productId);
        return new ModelAndView("redirect:/admin");
    }
}
