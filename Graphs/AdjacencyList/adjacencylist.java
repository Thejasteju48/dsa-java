package Graphs.AdjacencyList;

//This program represents Undirected-graph
import java.util.LinkedList;

public class adjacencylist{
    private LinkedList<Integer>[] adj;
    private int V;
    private int E;
    
    @SuppressWarnings("unchecked")
    public adjacencylist(int nodes)
    {
        this.adj = new LinkedList[nodes];
        this.V = nodes;
        this.E = 0;
        for(int v =0;v<nodes;v++)
        {
            adj[v] = new LinkedList<>();
        }
    }
    public void AddEdge(int u,int v)
    {
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V+" Vertices "+E+" edge "+"\n");
        for(int v = 0;v<V;v++)
        {
           sb.append(v+": ");
            for(int w:adj[v])
            {
               sb.append(w+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
       }

    public static void main(String args[])
    {
        adjacencylist a = new adjacencylist(5);
        a.AddEdge(0, 1);
        a.AddEdge(1, 2);
        a.AddEdge(2, 3);
        a.AddEdge(3, 4);
        a.AddEdge(4, 2);
        System.out.println(a.toString());
    }

}
