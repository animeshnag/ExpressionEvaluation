class Evaluation
{
    static Hashmap hmobj=new Hashmap();
    static isOperator isOpObj=new isOperator();
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

//    public static boolean isOperator(String op){
//        boolean ans=hmobj.checkOperator(op);
//        if(ans)
//            return true;
//        else
//            return false;
//    }

//    public static String getOperatorValue(String op){
//        String ans=hmobj.getOperatorValue(op);
//        return ans;
//    }

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

    double evaluate(Node root1){
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