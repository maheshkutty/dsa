import java.util.ArrayList;
import java.util.Stack;

class Graph
{
    int data;
    int vertexCount;
    ListNode edges[];
    ArrayList<Integer> ver;
    public Graph(int vertexCount)
    {
        this.vertexCount = vertexCount;
        ver = new ArrayList<Integer>();
        edges = new ListNode[vertexCount];
        for(int i=0;i<vertexCount;i++)
        {
            ver.add(i);
            edges[i] = new ListNode();
        }  
    }    
    public void addEdge(int src,int des)
    {
        edges[src].addFirst(des);
    }
    public void traverse()
    {
        for(int i=0;i<vertexCount;i++)
        {
            System.out.println(i);
            edges[i].traverse();
        }  
    }
    
    public void dfs(int init)
    {
        Stack<Integer> sCheck = new Stack<Integer>();
        int visited[] = new int[vertexCount];
        for(int i=0;i<vertexCount;i++)
        {
            visited[i] = 0;
        }
        int curr = init;
        LNode start1 = null;
        int flag = 0;
        while(true)
        {
            if(sCheck.isEmpty() && flag==1)
                break;
            if(!visited(curr,visited))
            {
                flag = 1;
                sCheck.add(curr);
                System.out.println("Visited:"+curr);
                start1 = edges[curr].head.next;
                curr = start1.data;
            }
            else
            {
                if(start1.next == null)
                {
                    sCheck.pop();
                    if(sCheck.isEmpty())
                        break;
                    curr = sCheck.peek();
                    start1 = edges[curr].head.next;
                    curr = start1.data;
                }else
                {
                    start1 = start1.next;
                    curr = start1.data;
                }
            }
        }
    }
    public boolean visited(int data, int checkArr[])
    {
        if(checkArr[data]==0)
        {
            checkArr[data] =  1;
            return false;
        }else
        {
            return true;
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addEdge(0, 1);
        g.addEdge(1, 6);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 2);
        g.addEdge(4, 2);
        g.addEdge(4, 7);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 4);
        g.addEdge(6, 4);
        g.addEdge(7, 4);
        //g.traverse();
        g.dfs(5);
    }
}