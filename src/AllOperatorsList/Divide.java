package AllOperatorsList;

import HashMapCreator.Hashmap;

public class Divide extends Hashmap implements Operator  {

    String type="binary";

    public Divide(){
        hm.put("/", "Divide");
        hmPreference.put("/", 11);
    }
    public double evaluate(double a, double b){
        return a/b;
    }
    public String getType(){
        return "binary";
    }
}

