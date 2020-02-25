package CoversionPostfixTree;

import java.io.*;
import java.util.ArrayList;

import AllOperatorsList.Operator;
import NodeCreation.Node;
import OperatorCheck.isOperator;
import ReturnOperatorValue.GetOperatorValue;

class Stack1
{
    private Node[] a;
    private int top, m;

    public Stack1(int max)
    {
        m = max;
        a = new Node[m];
        top = -1;
    }

    public void push(Node key)
    {
        a[++top] = key;
    }

    public Node pop()
    {
        return (a[top--]);
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }
}

class Tree
{
    public static Node root;

    public Tree()
    {
        root = null;
    }

    public Node convertToTree(ArrayList<String> ar)
    {
        Stack1 stk = new Stack1(100);
        int length=ar.size();
        Node newNode, ptr1=null, ptr2=null ;
        int i=0;
        while (i<length) {
            String symbol=ar.get(i);

            if(isOperator.isOperator(symbol)){

                String className= GetOperatorValue.getOperatorValue(symbol);
                double ans=-1;
                Class cls = null;
                try {
                    cls = Class.forName(className);
                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    Operator c=(Operator)cls.newInstance();
                    String type=c.getType();
                    if(type.equals("binary")){
                        try{
                            ptr1 = stk.pop();
                        }
                        catch (Exception e){
                            System.out.println("One operand is missing with respect to operator " + symbol);
                            System.exit(0);
                        }

                        try{
                            ptr2 = stk.pop();
                        }
                        catch (Exception e){
                            System.out.println("One operand is missing with respect to operator " + symbol);
                            System.exit(0);
                        }

                        newNode = new Node(symbol);
                        newNode.leftChild = ptr2;
                        newNode.rightChild = ptr1;
                        stk.push(newNode);
                    }

                    else{
                        ptr1= stk.pop();
                        newNode = new Node(symbol);
                        newNode.leftChild = ptr1;
                        stk.push(newNode);
                    }
                }
                catch (InstantiationException e) {
                    e.printStackTrace();
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            else{

                /*try{
                    Integer.parseInt(symbol);
                }
                catch(Exception e){
                }*/
                newNode = new Node(symbol);
                stk.push(newNode);
            }
            i++;
        }
        root = stk.pop();
        return root;
    }
}

public class PostfixToTree extends Tree
{
    static Node r;
    public Node postfixToTree(ArrayList<String> ar){
        Tree t=new Tree();
        r=t.convertToTree(ar);
        return (r);
    }
}








