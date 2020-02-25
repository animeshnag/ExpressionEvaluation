package AllOperatorsList;

import HashMapCreator.Hashmap;

public class Modulus extends Hashmap implements Operator {
    public Modulus(){
        hm.put("%", "Modulus");
        hmPreference.put("%", 11);
    }

    public double evaluate(double a, double b){
        return a%b;
    }
    public String getType(){
        return "binary";
    }

}
