package HashMapCreator;

import AllOperatorsList.*;

import java.util.HashMap;
import java.util.Map;


public class Hashmap {

    public static HashMap<String, String> hm = new HashMap<String, String>();
    public static HashMap<String, Integer> hmPreference = new HashMap<String, Integer>();

    public boolean checkOperator(String op){
        new Plus();
        new Minus();
        new Multiply();
        new Divide();
        new Sin();
        new Cos();
        new Log();
        new Modulus();
        new PowerOfPower();

        if(hm.containsKey(op)){
            return true;
        }
        else{
            return false;
        }
    }
    public String getOperatorValue(String op){
        return hm.get(op);
    }
}
