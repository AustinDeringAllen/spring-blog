package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RollDiceController {
    @GetMapping(path="/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping(path="/roll-dice/{number}")
    public String rollDiceGuess(@PathVariable int number, Model model) {
        int[] returnArray = new int[5];

        for(int i=0; i<returnArray.length; i++) {
            returnArray[i] = (int) Math.floor((Math.random() * 6) + 1);
            System.out.println(returnArray[i]);
        }

        model.addAttribute("numberToGuess", number);
        model.addAttribute("rolls",returnArray);
        return "dice-guess";
    }
}