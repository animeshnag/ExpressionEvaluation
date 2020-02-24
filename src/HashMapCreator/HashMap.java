package HashMapCreator;

import AllOperatorsList.Cos;
import AllOperatorsList.Log;

import java.util.HashMap;
import java.util.Map;

class Hashmap {

    public static HashMap<String, String> hm = new HashMap<String, String>();
    public static HashMap<String, Integer> hmPreference = new HashMap<String, Integer>();

    boolean checkOperator(String op){
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
    String getOperatorValue(String op){
        return hm.get(op);
    }


    /*void addOperator(String key, String value){
        hm.put(key, value);
    }*/

    void printHashMap(){
        System.out.println(hm);
    }

/*    public static void main(String args[]) {
        Hashmap obj=new Hashmap();
        obj.printHashMap();
    }*/
}
