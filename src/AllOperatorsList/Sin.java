public class Sin extends Hashmap implements Operator {

    Sin(){
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
