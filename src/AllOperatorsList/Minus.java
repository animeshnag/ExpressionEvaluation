public class Minus extends Hashmap implements Operator {



    Minus(){
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
