package ro.vlad.proiectfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ro.vlad.proiectfinal.database.Category;
import ro.vlad.proiectfinal.database.CategoryDAO;
import ro.vlad.proiectfinal.database.Product;
import ro.vlad.proiectfinal.database.ProductDAO;

import java.util.Comparator;
import java.util.List;

@Controller
public class PageController {
    //DAO = data acces object
    @Autowired
    ProductDAO productDAO;

    @Autowired
    CategoryDAO categoryDAO;

    @GetMapping("/offers")
    public ModelAndView offerCars() {
        //stocam produsele intr-o lista
        List<Product> products = productDAO.findAll();
        int carsOnStock = products.size();
        for (Product p : products) {
            //setam url-ul
            p.setUrl("product?id=" + p.getId());
        }
        //adaugam elementele in interfata printr-un model and view
        ModelAndView modelAndView = new ModelAndView("offers");
        modelAndView.addObject("products", products);
        modelAndView.addObject("carsOnStock",carsOnStock);

        return modelAndView;
    }

    @GetMapping("/product")
    public ModelAndView product(@RequestParam("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("product");
        //adaugam produsul pe pagina sa
        Product product = productDAO.findById(id);
        modelAndView.addObject("product", product);

        return modelAndView;
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView("dashboard");
        return modelAndView;
    }

    @GetMapping("/about")
    public ModelAndView aboutUs() {
        return new ModelAndView("about");
    }

    @GetMapping("/contact")
    public ModelAndView contact() {
        return new ModelAndView("contact");
    }

    @GetMapping("filter")
    public ModelAndView filterPage() {
        ModelAndView modelAndView = new ModelAndView("filter");
        //adaugam intr-un select categoriile
        List<Category> categories = categoryDAO.findByName();
        categories.sort(Comparator.comparing(Category::getName));
        modelAndView.addObject("categories", categories);

        return modelAndView;
    }

    @GetMapping("/policy")
    public ModelAndView policy() {
        ModelAndView modelAndView = new ModelAndView("policy");

        return modelAndView;
    }

    @GetMapping("/terms")
    public ModelAndView terms() {
        ModelAndView modelAndView = new ModelAndView("terms");

        return modelAndView;
    }

    @GetMapping("/favorite")
    public ModelAndView favorite() {
        ModelAndView modelAndView = new ModelAndView("favorite");

        return modelAndView;
    }
}
