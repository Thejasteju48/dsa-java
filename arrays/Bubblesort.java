import java.util.Scanner;

public class Bubblesort{
    void swap()

    void bubblesort(int a[],int n)
    {
        int flag,x;
        for(int i = 0;i<n-1;i++)
        {
            flag = 0;
            for(int j =0;j<n-1;j++)
            {
                if(a[j]>a[j+1])
                {
                    x = a[j];
                    a[j] = a[j+1];
                    a[j+1] = x;
                    flag = 1;
                }
            }
            if(flag == 0)
            break;
        }
    }
    void display(int a[],int n)
    {
        for(int i =0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        Bubblesort b = new Bubblesort();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array\n");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the elements of array\n");
        for(int i = 0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }
        System.out.println("Elements of array before sorting");
        b.display(a, n);
        b.bubblesort(a, n);
        System.out.println("Elements of array after sorting");
        b.display(a, n);
    }
    
}