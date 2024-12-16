package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;  // Use ProductService instead of EmployeeService
    
    // Endpoint to insert product data
    @RequestMapping("/insert")
    public ModelAndView insertProduct(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView mv = new ModelAndView();
        
        // Create a new Product object
        Product product = new Product();
        
        // Set product properties from the request
        product.setPname(req.getParameter("pname"));
        product.setPcost(Double.parseDouble(req.getParameter("pcost")));
        
        // Parse and set the product order date
        try {
            product.setPorderdt(new java.text.SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("porderdt")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Insert product through the service layer
        if (productService.insert(product) != null) {
            mv.setViewName("display.jsp");  // Redirect to display page after insertion
        } else {
            mv.setViewName("error.jsp");  // In case of an error
        }

        return mv;
    }

    // Endpoint to get all products
    @RequestMapping("/getall")
    public ModelAndView getAllProducts(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView mv = new ModelAndView();
        
        // Fetch the list of products from the service
        List<Product> productList = productService.getAll();
        
        // Set the view name and add the product list as model
        mv.setViewName("productdisplay.jsp");
        mv.addObject("list", productList);

        return mv;
    }
}
