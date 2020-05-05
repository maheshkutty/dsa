import java.util.Scanner;

class BinarySearch
{
    int data;
    BinarySearch left;
    BinarySearch right;
}
class BinarySearchOP extends BinarySearch
{ 
    BinarySearch getNode(int data)
    {
        BinarySearch bp = new BinarySearch();
        bp.data = data;
        bp.left = null;
        bp.right = null;
        return bp;
    }
    BinarySearch insertNode(BinarySearch root,int data)
    {
        if(root==null)
        {
            root = getNode(data);
        }
        else if (root.data<=data)
        {
            root.left = insertNode(root.left, data);
        }else if (root.data>data)
        {
            root.right = insertNode(root.right, data);
        }
        return root;
    }
    void preOrder(BinarySearch root)
    {
        if(root==null)
        {
            return;
        }
        System.out.println(root.data);
        root = preOrder(root.left);
        root = preOrder(root.right); 
    }
    void inOrder(BinarySearch root)
    {
        if(root==null)
        {
            return;
        }
        root = inOrder(root.left);
        System.out.println(root.data);
        root = inOrder(root.right);
    }
    void postOrder(BinarySearch root)
    {
        if(root==null)
        {
            return;
        }
        root = inOrder(root.left);
        root = inOrder(root.right);
        System.out.println(root.data);
    }
    public static void main(String[] args) {
        BinarySearch root = null;
        BinarySearchOP bst = new BinarySearchOP();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Number of tree Node::::::::::::");
        int node = in.nextInt();
        for (int i = 0;i<node;i++)
        {
            root = bst.insertNode(root, in.nextInt());
        }
        bst.preOrder(root);
    }
}