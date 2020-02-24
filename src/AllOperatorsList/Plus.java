class Plus extends Hashmap implements Operator  {

    String type="binary";

    Plus(){
        hm.put("+", "Plus");
        hmPreference.put("+", 1);
    }
    public double evaluate(double a, double b){
        return a+b;
    }
    public String getType(){
        return "binary";
    }
    public int getPreference(){
        return 1;
    }
}
