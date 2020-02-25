package NodeCreation;

public class Node
{
    public String data;
    public Node leftChild;
    public Node rightChild;

    public Node(String x)
    {
        data = x;
    }

    public void displayNode(){
        System.out.print(data);
    }
}