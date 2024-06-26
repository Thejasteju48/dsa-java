package Graphs.Adjacencymatrix;
//This program is to represent Undirected-Graph
public class adjacencymatrix {
  private int V;//Number of nodes in Graph
  private int E;//Number of edges in Graph
  private int [][] adjmat;
public adjacencymatrix(int nodes)
{
  this.adjmat = new int[nodes][nodes];
  this.V = nodes;
  this.E = 0;
}
public void AddEdge(int u,int v)
{
 adjmat[u][v] = 1;
 adjmat[v][u] = 1;
 E++;
}

public String toString(){
 StringBuilder sb = new StringBuilder();
 sb.append(V+" Vertices "+E+" edge "+"\n");
 for(int v = 0;v<V;v++)
 {
    sb.append(v+": ");
     for(int w:adjmat[v])
     {
        sb.append(w+" ");
     }
     sb.append("\n");
 }
 return sb.toString();
}

 public static void main(String args[])
 {
     adjacencymatrix a = new adjacencymatrix(5);
     a.AddEdge(0, 1);
     a.AddEdge(1, 2);
     a.AddEdge(2, 3);
     a.AddEdge(3, 4);
     a.AddEdge(4, 2);
     System.out.println(a.toString());
 }
}