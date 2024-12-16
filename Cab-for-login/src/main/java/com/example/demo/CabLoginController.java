package com.example.demo;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CabLoginController {

    @Autowired
    CabRepo repo;  // Create a separate service for CabRepo

    Logger log = Logger.getAnonymousLogger();

    // Load the login page
    @RequestMapping("/")
    public ModelAndView loadpage(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index.jsp");
        return mv;
    }

    // Handle login request
    @RequestMapping("/login")
    public ModelAndView loginaction(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView mv = new ModelAndView();
        Cab cab = repo.loginCheck(req.getParameter("fullName"), req.getParameter("pwd"));
        if (cab != null) {
            mv.setViewName("display.jsp");
            mv.addObject("cab", cab);
        } else {
            mv.setViewName("fail.jsp");
        }
        return mv;
    }

    // Register a new cab
    @ResponseBody
    @RequestMapping("/registerlogin")
    public String redirectToRegisterMs(HttpServletRequest req, HttpServletResponse res) {
        String fullName = req.getParameter("fullName");
        String password = req.getParameter("pwd");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("phoneNumber");
        String url = "http://localhost:8090/register/" + fullName + "/" + password + "/" + email + "/" + phoneNumber;
        log.info(url);
        RestTemplate temp = new RestTemplate(); // REST API call
        temp.getForObject(url, String.class);
        return "Registration done";
    }
}
