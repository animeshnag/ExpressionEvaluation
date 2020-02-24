package TokenCreator;
import java.util.ArrayList;

public class Tokenizer {

    public ArrayList tokenizer(String input){

        String exp=input;
        ArrayList<String> ar=new ArrayList<String>();
        String S="";
        boolean flag=false, flag1=false;
        for(int i=0; i<exp.length(); i++) {
            char ch = exp.charAt(i);
            String ch1=Character.toString(ch);
            if(ch==' ')
                continue;
            if (Character.isDigit(ch) || ch == '.') {
                if(flag1==true) {
                    if (!(S.equals("")))
                        ar.add(S);
                    S = "";
                    flag1=false;
                }
                S = S + ch;
                flag = true;
            }
            else if (ch == '(') {
                flag1=false;
                if (!(S.equals("")))
                    ar.add(S);
                S = "";
                S = S + ch;
                ar.add(S);
                S = "";
            }
            else if (ch == ')') {
                if (!(S.equals("")))
                    ar.add(S);
                S = "";
                S = S + ch;
                ar.add(S);
                S = "";
            }
            else if(Character.isLetter(ch)) {
                S = S + ch;
                flag1=true;
            }
            else if(isOperator.isOperator(ch1) && flag==true){
                if(!(S.equals(("")))) {
                    ar.add(S);
                }
                S = "";
                S = S + ch;
                ar.add(S);
                S = "";
                flag = false;
            }
            else if ((ch == '-') && flag == false) {
                ar.add("-1");
                ar.add("*");
                S = "";
            }
            else {
                S = S + ch;
            }
        }
        if(!(S.equals("")))
            ar.add(S);

        //System.out.println("Tokenizer " + ar);
        return ar;
    }
}
