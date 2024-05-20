import java.util.Scanner;

public class trappedrainwater{
    public static int trapp(int height[])
    {
        int leftarr[] = new int[height.length];
        int rightarr[] = new int[height.length];
        leftarr[0] = height[0];
        int n = height.length;
        for(int i =1;i<height.length;i++)
        {
            leftarr[i] = Math.max(height[i], leftarr[i-1]);
        }
        rightarr[n-1] = height[n-1];
        for(int i = n-2;i>=0;i--)
        {
            rightarr[i] = Math.max(height[i], rightarr[i+1]);
        }
        int trapwater = 0;
        for(int i =0;i<n;i++)
        {
            int waterlevel=Math.min(leftarr[i], rightarr[i]);
            trapwater+=waterlevel-height[i];
        }
        return trapwater;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int arr[] = {4,2,0,6,3,2,5};
        System.out.println(trapp(arr));
    }
}