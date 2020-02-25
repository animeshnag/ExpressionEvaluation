package AllOperatorsList;

import HashMapCreator.Hashmap;

public class Sin extends Hashmap implements Operator {

    public Sin(){
        hm.put("sin", "Sin");
        hmPreference.put("sin", 21);
    }

    public double evaluate(double a, double b){
        return Math.sin(a);
    }
    public String getType(){
        return "unary";
    }
}
