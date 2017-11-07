package com.awareqwx.NinjaGold.controllers;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController
{

    @RequestMapping("/")
    public String index(HttpSession session, Model model)
    {
        if (session.getAttribute("acts") == null)
        {
            session.setAttribute("acts", "");
        }
        if (session.getAttribute("gold") == null)
        {
            session.setAttribute("gold", 0);
        }
        model.addAttribute("acts", session.getAttribute("acts"));
        model.addAttribute("gold", session.getAttribute("gold"));
        return "gold.jsp";
    }
    
    @RequestMapping(path="/process", method=RequestMethod.POST)
    public String process(@RequestParam(value="gold") String gold, @RequestParam(value="location") String location, HttpSession session)
    {
        Random r = new Random();
        int[] parsed = parseGold(gold);
        int g = r.nextInt(parsed[1] - parsed[0]) + parsed[0];
        String act;
        if(location.equals("Casino"))
        {
            act = "<p class=\"act\">" + ("Entered a casino and " + ( g > 0 ? "gained " + g + " gold! Hooray!" : g < 0 ? "lost " + -g + " gold... Ouch..." : "broke even.")) + "</p>";
        }
        else
        {
            act = "<p class=\"act\">" + ("Earned " + g + " from the " + location + ".") + "</p>";
        }
        session.setAttribute("acts", session.getAttribute("acts") == null ? act : session.getAttribute("acts") + act);
        session.setAttribute("gold", session.getAttribute("gold") == null ? g : (int) session.getAttribute("gold") + g);
        return "redirect:/";
    }
    
    private int[] parseGold(String s)
    {
        int[] ret = new int[2];
        int index = s.indexOf('/');
        ret[0] = Integer.parseInt(s.substring(0, index));
        ret[1] = Integer.parseInt(s.substring(index + 1, s.length()));
        return ret;
    }

}
