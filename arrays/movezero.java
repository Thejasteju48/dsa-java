package arrays;
import java.util.Scanner;

public class movezero{

    public static int[] movzero(int A[])
    {
        int j =0;
        for(int i =0;i<A.length;i++)
        {
            if(A[i]!=0 && A[j]==0)
            {
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
            if(A[j]!=0)
            {
                j++;
            }
        }
        return A;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int A[] = new int[5];
        for(int i =0;i<A.length;i++)
        {
            A[i] = sc.nextInt();
        }
        A = movzero(A);
        for(int i =0;i<A.length;i++)
        {
            System.out.println(A[i]);
        }
    }
    
}

