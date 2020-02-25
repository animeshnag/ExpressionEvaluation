package ReturnOperatorValue;

import Evaluator.Evaluation;

public class GetOperatorValue {


    public static String getOperatorValue(String op) {
        String ans = Evaluation.hmobj.getOperatorValue(op);
        return ans;
    }
}
