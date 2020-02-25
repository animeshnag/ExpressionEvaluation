package ExpressionController;

import CoversionPostfixTree.Postfix;
import CoversionPostfixTree.PostfixToTree;
import Evaluator.Evaluation;
import NodeCreation.Node;

import PrintInorder.Inorder;
import TokenCreator.Tokenizer;
import java.util.ArrayList;

public class Controller {

    public double controller(String input){

        System.out.println("Initial Expression " + input);

        Tokenizer tokenobj = new Tokenizer();
        ArrayList<String> ar=new ArrayList<String>();
        ar=tokenobj.tokenizer(input);
        System.out.println("After tokenization " + ar);

        Postfix postfixobj=new Postfix();
        ArrayList<String> ar1=new ArrayList<String>();
        ar1=postfixobj.convertToPostfix(ar);
        System.out.println("After postfix conversion " + ar1);

        PostfixToTree treeObj=new PostfixToTree();
        Node root=treeObj.postfixToTree(ar1);
        System.out.print("After Tree Creation ");
        Inorder.inOrder(root);

        System.out.println();

        Evaluation evaluateObj=new Evaluation();
        double finalAns=evaluateObj.evaluate(root);
        //System.out.println(finalAns);
        return finalAns;
    }
}
