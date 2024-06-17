package Stacks.Implementation.Linkedlist;
import java.util.Scanner;

public class stacklist{
    static class stack{
        int data;
        stack next;
        stack(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    private stack top;
    stack head;
    public boolean isEmpty()
    {
        return top == null;
    }
    
    public void push(int val)
    {
        stack st = new stack(val);
        if(top ==null)
        {
            top = st;
            head = top;
        }
        else
        {
            st.next = top;
            top = st;
        }
    }
    
    public int pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack Underflow");
            return -1;
        }
        int val = top.data;
        top = top.next;
        return val;
    }

    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("Stack underflow");
            return -1;
        }
        int val = top.data;
        return val;
    }
    public void display()
    {
        if(isEmpty())
        {
            System.out.println("Stack is empty");
            return;
        }
        stack current = top;
        while (current!=null){
             System.out.println(current.data);
             current = current.next;
        }
    }
    
    public static void main(String args[])
    {
        stacklist s = new stacklist();
        Scanner sc = new Scanner(System.in);
        int val,choice;
        do {
               System.out.println("--MENU--");
               System.out.println("1.PUSH");
               System.out.println("2.POP");
               System.out.println("3.PEEK");
               System.out.println("4.DISPLAY");
               System.out.println("0.EXIT");
               System.out.println("Enter your choice of operations:");
               choice = sc.nextInt();
               switch (choice) {
                   case 1:
                          System.out.println("Enter the value to be pushed");
                          val = sc.nextInt();
                          s.push(val);
                       break;
                   case 2:
                           val = s.pop();
                           System.out.println(val+" is poped from stack");
                           break;
                   case 3:
                            val = s.peek();
                            System.out.println(val+" is at top of stack");
                            break;
                   case 4:
                            s.display();
                            break;
                   case 0:
                            System.out.println("--Exiting--");
                            break;
               }
        } while (choice!=0);
    }
}

