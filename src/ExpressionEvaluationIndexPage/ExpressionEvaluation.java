package ExpressionEvaluationIndexPage;

import java.io.DataInputStream;
import java.io.IOException;

public class ExpressionEvaluation {
    public static void main(String[] args)throws IOException {
        DataInputStream inp = new DataInputStream(System.in);
        //String ch="y";
        //while(ch!="n") {
          //  System.out.println("Enter a expression to evaluate");
            //String input = inp.readLine();
            String input = "12+34+45+56";
            if(input.equals(""))
                System.out.println("You have not provided any input");
            else {
                Controller obj = new Controller();
                double finalAns=obj.controller(input);
                System.out.println("Result : " + finalAns);
                System.out.println("To continue press any key except n");
              //  ch=inp.readLine();
            }
        //}
    }
}
