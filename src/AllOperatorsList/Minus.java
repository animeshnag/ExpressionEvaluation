package AllOperatorsList;

import HashMapCreator.Hashmap;

public class Minus extends Hashmap implements Operator {

    public Minus(){
        hm.put("-", "Minus");
        hmPreference.put("-", 1);
    }

    public double evaluate(double a, double b){
        return a-b;
    }
    public String getType(){
        return "binary";
    }

}
