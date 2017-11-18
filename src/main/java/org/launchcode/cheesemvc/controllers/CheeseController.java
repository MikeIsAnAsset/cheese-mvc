package org.launchcode.cheesemvc.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("cheese")
public class CheeseController {

//    static ArrayList<String> cheeses = new ArrayList<>();

    static HashMap<String, String> cheeses = new HashMap<>();

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

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription){

        cheeses.put(cheeseName, cheeseDescription);
        return "redirect:";
    }

/*    public String processAddCheeseForm(HttpServletRequest request){
        String cheeseName = request.getParameter("cheeseName");*/

    @RequestMapping(value="/delete", method = RequestMethod.GET)
    public String displayDeleteCheeseForm(Model model){
        model.addAttribute("cheeses", "cheeses");
        model.addAttribute("title", "Delete Cheese");
        return "cheese/delete";
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public String processDeleteCheeseForm(@RequestParam ArrayList<String> cheese){
        for (String i : cheese){
            cheeses.remove(i);
        }
        return  "redirect:";
    }




}

