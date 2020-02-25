package AllOperatorsList;

import HashMapCreator.Hashmap;

public class Multiply extends Hashmap implements Operator {

    public Multiply(){
        hm.put("*", "Multiply");
        hmPreference.put("*", 11);
    }
    public double evaluate(double a, double b){
        return a*b;
    }


    public String getType(){
        return "binary";
    }
}
