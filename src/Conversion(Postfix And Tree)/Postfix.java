import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Postfix {
    static isOperator isOpObj=new isOperator();

    /*private int getPreference(String c){
        if(c.equals("+") || c.equals("-"))
            return 1;
        else if(c.equals("*") || c.equals("/"))
            return 2;
        else if (c.equals("sin") || c.equals("log") || c.equals("cos"))
            return 3;
        else
            return -1;
    }*/

    private ArrayList<String> getPostFixString(ArrayList<String> ar){

        int a=-1;
        Stack<String> stack = new Stack<>();
        ArrayList<String> postFixList = new ArrayList<>();

        for(int i=0; i<ar.size(); i++){

            String word=ar.get(i);
            if(word==""){
                continue;
            }
            else if(word.equals("(")){
                stack.push(word);

            }
            else if(word.equals(")")){
                while(!stack.isEmpty()){
                    if((stack.peek().equals("(")) || stack.peek().equals("cos")){
                        stack.pop();
                        break;
                    }
                    else{
                        postFixList.add(stack.pop()+"");
                    }
                }
            }
            else if(isOpObj.isOperator(word)){
                //System.out.println(word);
                String className= GetOperatorValue.getOperatorValue(word);
                Class cls = null;
                try {
                    cls = Class.forName(className);
                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    Operator c=(Operator) cls.newInstance();
                    String type=c.getType();

                    if(type.equals("binary")){
                        if(stack.isEmpty()){
                            stack.push(word);
                        }
                        else{
                            try {
                                a = Hashmap.hmPreference.get(stack.peek());
                            }
                            catch(Exception e){
                                a=-1;
                            }
                            int b=Hashmap.hmPreference.get(word);
                            while(!stack.isEmpty() && a>=b){
                                postFixList.add(stack.pop()+"");
                            }
                            /*while(!stack.isEmpty() && c.getPreference(stack.peek()) >= getPreference(word)){
                                postFixList.add(stack.pop()+"");
                            }*/
                            stack.push(word);
                        }
                    }
                    else if(type.equals("unary")){
                        stack.push(word);
                    }
                }
                catch (InstantiationException e) {
                    e.printStackTrace();
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            else{
                postFixList.add(word+"");

            }
        }

        while(!stack.isEmpty()){
            postFixList.add(stack.pop()+"");
        }
        return postFixList;
    }
    public ArrayList<String> convertToPostfix(ArrayList<String> ar) {

        ArrayList<String> postFixString = getPostFixString(ar);
        return (postFixString);
    }
}