class LNode
{
    int data;
    LNode next;
}
class ListNode extends LNode
{
    int count = 0;
    LNode head;
    public ListNode()
    {
        head = new LNode();
        head.data = 0;
        head.next = null;
    }
    public void addFirst(int data)
    {
        LNode l = new LNode();
        l.data = data;
        if(head.next==null)
        {
            l.next = null;
            head.next = l;
        }else{
            l.next = head.next;
            head.next = l;
        }
    }
    public void addLast(int data)
    {
        LNode l = new LNode();
        l.data = data;
        l.next = null;
        LNode temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = l;
    }
    public void traverse()
    {
        LNode temp = head.next;
        while(temp != null)
        {
            System.out.println("Node Data:"+temp.data);
            temp = temp.next;
        }
    }
    public LNode getNext(LNode curr)
    {
        return curr.next;
    }
    public static void main(String args[])
    {
        ListNode k = new ListNode();
        //Scanner in = new Scanner(System.in);
        //System.out.println("Enter the count");
        for (int i = 0;i<5;i++)
        {
            k.addFirst(i+1);
        }
        k.traverse();
    }
}