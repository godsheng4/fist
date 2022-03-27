package com.weifeng.web;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weifeng.pojo.Calculation;

import autoArithmetic.Calculator;
import autoArithmetic.CreateInteger;

@WebServlet("/mycalculationServlet")
public class MycakculationServlet extends BaseServlet{
	
	
	protected void integerTest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> answers = new ArrayList<>();
        Random random = new Random();
        int k=0;
        int j=0;
        while(k<20) {
        int operatorCount = 1 + random.nextInt(2); //随机操作符的个数（1-3个）
        int operand[] = new int[operatorCount + 1]; //操作数个数
        int[] operatorIndex = CreateInteger.index(operatorCount, 4, random);
        for(int i = 0; i < operatorCount + 1; i++){
            operand[i] = random.nextInt(100);
        }

        String formula = CreateInteger.stitchingFormula(operatorCount, operand, operatorIndex,0);
        //计算结果
        Calculator calculator = new Calculator();
        int res = calculator.algorithm(formula);
        if(res>0)
        {
        	list.add(formula);
        	k++;
        	String newRes=String.valueOf(res);
        	answers.add(newRes);
        }
        
        }
        System.out.println(list);
        System.out.println(answers);
        req.setAttribute("list",list);
        req.setAttribute("answers",answers);
        req.getRequestDispatcher("pages/answer.jsp").forward(req,resp);
        }
	
	
	protected void compare(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		int score=0;
		String inputanswers[]=req.getParameterValues("inputanswer");
		String answers[]=req.getParameterValues("answer");
		String questions[]=req.getParameterValues("questions");
		System.out.println(inputanswers[0]); 
		System.out.println(answers[0]);
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0;i<inputanswers.length;i++) {
			if(inputanswers[i].equals(answers[i])) {
				
				result.add(questions[i]+"="+inputanswers[i]+"  (√)");
				score+=5;
			}else {
				result.add(questions[i]+"="+inputanswers[i]+"  (×)");
			}
		
		}
//		req.setAttribute("questions", questions);
		req.setAttribute("result", result);
		req.setAttribute("score",score);
        req.getRequestDispatcher("/pages/answer.jsp").forward(req,resp);
	}
	
	
	
	
	
	
	
	
	
	/*括号*/
        protected void bracketTest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	req.setCharacterEncoding("utf-8");
    		resp.setCharacterEncoding("utf-8");
    		resp.setContentType("text/html;charset=utf-8");
    		ArrayList<String> list = new ArrayList<>();
    		ArrayList<String> answers = new ArrayList<>();
            Random random = new Random();
            int k=0;
            int j=0;
            while(k<20) {
            int operatorCount = 1 + random.nextInt(3); //随机操作符的个数（1-3个）
            int operand[] = new int[operatorCount + 1]; //操作数个数
            int[] operatorIndex = CreateInteger.index(operatorCount, 4, random);
            for(int i = 0; i < operatorCount + 1; i++){
                operand[i] = random.nextInt(100);
            }

            String formula = CreateInteger.stitchingFormula(operatorCount, operand, operatorIndex,0);
            //计算结果
            Calculator calculator = new Calculator();
            int res = calculator.algorithm(formula);
            if(res>0)
            {
            	list.add(formula);
            	k++;
            	answers.add(String.valueOf(res));
            }
            }
            req.setAttribute("list",list);
            req.setAttribute("answers",answers);
            req.getRequestDispatcher("pages/answer.jsp").forward(req,resp);
            }
	}
