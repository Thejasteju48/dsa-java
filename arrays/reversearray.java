import java.util.Scanner;

public class reversearray{
    public static int[] reverse(int A[],int n)
    {
        int start = 0;
        int end = n-1;
        while(start<end)
        {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
        return A;
    }
    public static void main(String args[])
    {
        int A[] = new int[5];
        Scanner sc = new Scanner(System.in);
        for(int i =0;i<5;i++)
        {
            A[i] = sc.nextInt();
        }
        A= reverse(A, 5);
        for(int i =0;i<5;i++)
        {
            System.out.println(A[i]);
        }
    }
    
}
