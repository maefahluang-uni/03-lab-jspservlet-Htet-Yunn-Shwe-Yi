package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/calbmi")
//TODO: add webservlet to "/calbmi"
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String w = request.getParameter("weight");
        double weight = Double.parseDouble(w);
        String h = request.getParameter("height");
        double height =  Double.parseDouble(h);
        
        //TODO: calculate bmi
        double bmi=Math.round(weight / (height * height));
        //TODO: determine the built from BMI
        String bmi_result = " ";
        if (bmi < 18.5) {
            bmi_result = "underweight";
        } else if ((18.5<=bmi) && (bmi < 25)) {
            bmi_result = "normal";
        } else if ((25<=bmi) && (bmi < 30)) {
            bmi_result= "overweight";
        }  else if ((30<=bmi) && (bmi < 35)) {
            bmi_result="obese";
        } else if ( (bmi >= 35)) {
            bmi_result= "extremely obese";
        }
    

      
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("bmi",bmi);
        request.setAttribute("bmi_result" ,bmi_result);

        //TODO: forward to jsp
        request.getRequestDispatcher("bmi_result.jsp").forward(request, response);
    }
           
    }
    

