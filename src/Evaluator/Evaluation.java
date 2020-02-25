package Evaluator;
import AllOperatorsList.Operator;
import HashMapCreator.Hashmap;
import NodeCreation.Node;
import OperatorCheck.isOperator;
import ReturnOperatorValue.GetOperatorValue;


public class Evaluation
{
    public static Hashmap hmobj=new Hashmap();
    public static isOperator isOpObj=new isOperator();
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static double addBT(Node root)
    {
        if(isNumeric(root.data))
            return (Double.parseDouble(root.data));

        else if(isOpObj.isOperator(root.data)){
            String className= GetOperatorValue.getOperatorValue(root.data);
            double ans=-1;
            Class cls = null;
            try {
                cls = Class.forName(className);
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                Operator c=(Operator)cls.newInstance();
                String type=c.getType();
                if(type.equals("binary"))
                    ans=c.evaluate(addBT(root.leftChild), addBT(root.rightChild));
                else{
                    ans=c.evaluate(addBT(root.leftChild), 0);
                }
            }
            catch (InstantiationException e) {
                e.printStackTrace();
            }
            catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return ans;
        }

        else{
            System.out.println("Invalid Number " + root.data);
            System.exit(0);
            return 0;
        }
    }

    public double evaluate(Node root1){
        double ans=addBT(root1);
        //System.out.println("Result " + ans);
        return(ans);
    }


    /*public static void main(String args[]) {

        Node root = newNode("*");
        root.left = newNode("2");
        root.right = newNode("3");

        double ans = addBT(root);
        System.out.println("Result : " + ans);
    }*/
}