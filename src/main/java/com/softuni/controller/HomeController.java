package com.softuni.controller;

import com.softuni.entity.Calculator;
import com.softuni.entity.WeightConverse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String home(){
		return "home-layout";
	}
	@GetMapping("/calculator")
	public String calculator(Model model){
		model.addAttribute("operator", "+");
		model.addAttribute("view", "views/calculatorForm");
		return "base-layout";
	}
	@PostMapping("/calculator")
	public String calculate(@RequestParam String leftOperand,
							@RequestParam String operator,
							@RequestParam String rightOperand,
							Model model){
		double leftNum;
		double rightNum;
		try{
			leftNum = Double.parseDouble(leftOperand);
		}catch (NumberFormatException nfe){
			leftNum = 0;
		}
		try {
			rightNum = Double.parseDouble(rightOperand);
		}catch (NumberFormatException nfe){
			rightNum = 0;
		}
		Calculator calculator = new Calculator(leftNum, rightNum, operator);
		double result = calculator.calculateResult();

		model.addAttribute("leftOperand", calculator.getLeftOperand());
		model.addAttribute("operator", calculator.getOperator());
		model.addAttribute("rightOperand", calculator.getRightOperand());

		model.addAttribute("result", result);
		model.addAttribute("view", "views/calculatorForm");

		return "base-layout";
	}

	@GetMapping("/weight-conversing")
	public String calorieCalculator(Model model){
		model.addAttribute("leftOperand", "gram");
		model.addAttribute("rightOperand","gram");
		model.addAttribute("view", "views/weightForm");
		return "base-layout";
	}
	@PostMapping("/weight-conversing")
	public String weightCalculate(@RequestParam String value,
								  @RequestParam String leftOperand,
								  @RequestParam String rightOperand,
								  Model model) {
		double num;
		try {
			num = Double.parseDouble(value);
		} catch (NumberFormatException nfe) {
			num = 1;
		}

		WeightConverse weightConverse = new WeightConverse(num, leftOperand, rightOperand);

		double result = weightConverse.calculations();

		model.addAttribute("value", weightConverse.getValue());
		model.addAttribute("leftOperand", weightConverse.getLeftOperand());
		model.addAttribute("rightOperand", weightConverse.getRightOperand());

		model.addAttribute("result", result);
		model.addAttribute("view", "views/weightForm");

		return "base-layout";
	}
}

