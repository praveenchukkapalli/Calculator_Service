package com.baton.Calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.baton.Calculator.service.CalculatorService;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
public class ApiController {
    @Autowired

    CalculatorService CalcService;

    /**
     *
     * @param Num1
     * @param Num2
     * @return Integer
     */
    @RequestMapping(method = RequestMethod.GET,value="/add/")//retrieve required objects from the database
    private Integer add(@RequestParam("Num1") int Num1, @RequestParam("Num2") int Num2)
    {
        String mode="add";
        return CalcService.calculate(mode,Num1,Num2);
    }

    /**
     *
     * @param Num1
     * @param Num2
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value="/sub/")//retrieve required objects from the database
    private Integer subract(@RequestParam("Num1") int Num1, @RequestParam("Num2") int Num2)
    {
        String mode="sub";
        return CalcService.calculate(mode,Num1,Num2);
    }

    /**
     *
     * @param Num1
     * @param Num2
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value="/mul/")//retrieve required objects from the database
    private Integer multiply(@RequestParam("Num1") int Num1, @RequestParam("Num2") int Num2)
    {
        String mode="mul";
        return CalcService.calculate(mode,Num1,Num2);
    }

    /**
     *
     * @param Num1
     * @param Num2
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value="/div/")//retrieve required objects from the database
    private Integer divide(@RequestParam("Num1") int Num1, @RequestParam("Num2") int Num2)
    {
        if(Num2==0){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot divide by zero");

        }
        else {
            String mode = "div";
            return CalcService.calculate(mode, Num1, Num2);
        }


    }





}
