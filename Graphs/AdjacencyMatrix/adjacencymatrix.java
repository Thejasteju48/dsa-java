//This program is to represent Undirected-Graph
public class adjacencymatrix {
   int [][] adjmat;
   public adjacencymatrix(int nodes)
   {
     this.adjmat = new int[nodes][nodes];
   }
   public void AddEdge(int u,int v)
   {
    adjmat[u][v] = 1;
    adjmat[v][u] = 1;
   }
   
   public void display()
   {
     
       for(int i =0;i<adjmat.length;i++)
      {
        for(int j = 0;j<adjmat.length;j++)
        {
            System.out.print(adjmat[i][j]+"\t");
        }
        System.out.println();
      }
   }
    public static void main(String args[])
    {
        adjacencymatrix a = new adjacencymatrix(5);
        a.AddEdge(0, 1);
        a.AddEdge(1, 2);
        a.AddEdge(2, 3);
        a.AddEdge(3, 4);
        a.AddEdge(4, 2);
        a.display();
    }
}