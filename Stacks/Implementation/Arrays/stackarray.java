package Stacks.Implementation.Arrays;
import java.util.Scanner;
public class stackarray {
    class Stack{
        public int arr[];
        public int top;
    }
   public Stack intialiaze(int n)
   {
       Stack st = new Stack();
       st.arr = new int[n];
       st.top = -1;
       return st;
   }
   public boolean isEmpty(Stack st)
   {
       if(st.top==-1)
       {
        return true;
       }
       return false;
   }
   public boolean isFull(Stack st)
   {
     if(st.top==st.arr.length-1)
     {
        return true;
     }
     return false;
   }
   public void Push(Stack st ,int val)
   {
      if(isFull(st))
      {
        System.out.println("Stack overflow");
      }
     else
     {
        st.top++;
        st.arr[st.top] = val;
     }
   }
   public int pop(Stack st)
   {
     if(isEmpty(st))
     {
        System.out.println("Stack underflow");
        return -1;
     }
     return st.arr[st.top--];
   }
   public int peek(Stack st)
   {
    if(isEmpty(st))
    {
       System.out.println("Stack underflow");
       return -1;
    }
     return st.arr[st.top];
   }
   public void display(Stack st)
   {
      if(isEmpty(st))
      {
        System.out.println("Stack is Empty");
        return;
      }
      int i = 0;
      while (i<=st.top){
        System.out.println(st.arr[i]);
        i++;
      }
   }
   public static void main(String args[])
   {
      stackarray s = new Stackarray();
      Stack st = null;
      int size,val,choice;
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the size of stack");
      size = sc.nextInt();
      st = s.intialiaze(size);
      do {
            System.out.println("---MENU---");
            System.out.println("1.PUSH");
            System.out.println("2.POP");
            System.out.println("3.PEEK");
            System.out.println("4.DISPLAY");
            System.out.println("5.EXIT");
            System.out.println("Enter your choice of operations:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                       System.out.println("Enter the value to be pushed");
                       val = sc.nextInt();
                       s.Push(st, val);
                    break;
                case 2:
                         val = s.pop(st);
                         if(val!=-1){
                         System.out.println(val+" is popped from stack");
                         }
                         break;
                case 3:
                        val = s.peek(st);
                        if(val!=-1)
                        {
                        System.out.println(val+" is at top of stack");
                        }
                        break;
                case 4:
                        s.display(st);
                        break;
                case 5:
                        System.out.println("--Exiting--");
                        break;
                default:
                        System.out.println("Invalid choice");
                    break;
            }
      } while (choice!=5);
   }

    
}
