package AllOperatorsList;
import HashMapCreator.Hashmap;

public class Log extends Hashmap implements Operator {

    public Log(){
        hm.put("log", "Log");
        hmPreference.put("log", 21);
    }

    public double evaluate(double a, double b){
        return Math.log10(a);
    }

    public String getType(){
        return "unary";
    }
}
