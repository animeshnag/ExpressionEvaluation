package AllOperatorsList;
import HashMapCreator.Hashmap;

public class Cos extends Hashmap implements Operator {

    public Cos(){
        hm.put("cos", "Cos");
        hmPreference.put("cos", 21);
    }

    public double evaluate(double a, double b){
        return Math.cos(a);
    }
    public String getType(){
        return "unary";
    }
}
