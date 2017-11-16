package org.launchcode.cheesemvc.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static ArrayList<String> cheeses = new ArrayList<>();

    // Request path: /cheese
    @RequestMapping()
    public String index(Model model) {

//        cheeses.add("cheddar");
//        cheeses.add("parmesan");
//        cheeses.add("munster");

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses Are Great");
        return "cheese/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName){

        cheeses.add(cheeseName);
        return "redirect:";
    }

//    public String processAddCheeseForm(HttpServletRequest request){
//        String cheeseName = request.getParameter("cheeseName");
}

