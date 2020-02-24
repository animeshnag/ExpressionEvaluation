public class PowerOfPower extends Hashmap implements Operator {

    PowerOfPower(){
        hm.put("#", "PowerOfPower");
        hmPreference.put("#", 31);
    }
    public double evaluate(double a, double b){
        return Math.pow(a,Math.pow(b,b));
    }
    public String getType(){
        return "binary";
    }
}
