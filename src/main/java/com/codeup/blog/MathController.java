package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @RequestMapping(path="/add/{numOne}/and/{numTwo}")
    @ResponseBody
    public String add(@PathVariable int numOne, @PathVariable int numTwo) {
        return numOne + " plus " + numTwo + " equals " + (numOne + numTwo);
    }

    @RequestMapping(path="/subtract/{numOne}/from/{numTwo}")
    @ResponseBody
    public String subtract(@PathVariable int numOne, @PathVariable int numTwo) {
        return numOne + " subtracted from " + numTwo + " equals " + (numTwo - numOne);
    }

    @RequestMapping(path="/multiply/{numOne}/and/{numTwo}")
    @ResponseBody
    public String multiply(@PathVariable int numOne, @PathVariable int numTwo) {
        return numOne + " multiplied by " + numTwo + " equals " + (numOne * numTwo);
    }

    @RequestMapping(path="/divide/{numOne}/by/{numTwo}")
    @ResponseBody
    public String divide(@PathVariable int numOne, @PathVariable int numTwo) {
        return numOne + " divided by " + numTwo + " equals " + (numTwo / numOne);
    }
}
