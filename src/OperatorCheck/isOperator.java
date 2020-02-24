public class isOperator {
    public static boolean isOperator(String op){
        boolean ans=Evaluation.hmobj.checkOperator(op);
        if(ans)
            return true;
        else
            return false;
    }
}
