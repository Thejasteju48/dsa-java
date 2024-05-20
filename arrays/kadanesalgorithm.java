import java.util.Scanner;

public class kadanesalgorithm{
    public static void kadanes(int arr[])
    {
        int currentsum =0;
        int maxsum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            currentsum+=arr[i];
            if(currentsum>=0)
            {
                if(currentsum>maxsum)
                {
                    maxsum = currentsum;
                }
            }
            else
            {
                currentsum = 0;
            }
        }
        System.out.println("The maximum sum of subarray is:"+maxsum);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[8];
        System.out.println("Enter the elements of array");
        for(int i =0;i<8;i++)
        {
            arr[i] = sc.nextInt();
        }
        kadanes(arr);
    }
    
}
