package com.baton.Calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CalculatorService {
    public Integer calculate(String mode, Integer Num1, Integer Num2) {
        Integer answer=0;

        switch (mode) {
            case "add":
                answer=Num1+Num2;
                break;
            case "sub":
                answer=Num1-Num2;
                break;
            case "div":
                answer=Num1/Num2;
                break;
            case "mul":
                answer=Num1*Num2;
                break;



        }
        return answer;
    }
}
