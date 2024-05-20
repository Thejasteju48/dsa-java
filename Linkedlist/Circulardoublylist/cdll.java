package Linkedlist.Circulardoublylist;
import java.util.Scanner;

class Node{
    int data;
    Node nlink,plink;
    Node(int data)
    {
        this.data =data;
        this.plink = this.nlink = null;
    }
}
public class cdll{
    private Node head;
    private Node tail;
    Scanner sc = new Scanner(System.in);
    public void Createlist()
    {
        int data;
        System.out.println("Enter the value of head node: ");
        data = sc.nextInt();
        head = new Node(data);
        Node current = head;
        int count = 1;
        while (current!=null){
            System.out.println("Enter -1 to end list");
            System.out.println("Enter the value of "+(count+1)+"node");
            data = sc.nextInt();
            if(data!=-1){
            Node newnode = new Node(data);
            current.nlink = newnode;
            newnode.plink = current;
            current = current.nlink;
            }
            else
            {
                tail = current;
                current = null;
            }
            count++;
        }
        head.plink = tail;
        tail.nlink = head;
    }
    public void display()
    {
        if(head==null)
        {
            System.out.println("Empty list");
            return;
        }
        Node current = head;
        do {
             System.out.println(current.data);
             current = current.nlink;
        } while (current!=head);
    }
    public int findlenght()
    {
        if(head == null)
        {
            System.out.println("Empty list");
            return 0;
        }
        Node current = head;
        int count = 0;
        do {
              current = current.nlink;
              count++;
        } while (current!=head);
        return count;
    }
    public void insertAthead(int data)
    {
        Node newnode = new Node(data);
        if(head == null)
        {
            head = newnode;
            newnode.nlink = newnode.plink = newnode;
            tail = newnode;
            return;
        }
        Node current = head;
        newnode.nlink = current;
        newnode.plink = current.plink;
        current.plink.nlink = newnode;
        current.plink = newnode;
        head = newnode;
    }
    public void insertAttail(int data)
    {
        Node newnode = new Node(data);
        if(head == null)
        {
            head = newnode;
            newnode.nlink = newnode.plink = newnode;
            tail = newnode;
            return;
        }
        Node current = head.plink;
        newnode.nlink = current.nlink;
        newnode.plink = current;
        current.nlink = newnode;
        head.plink = newnode;   
    }
    public int deleteAthead()
    {
        if(head == null)
        {
            System.out.println("Empty list deletion not possible");
            return -1;
        }
        Node current = head;
        current.plink.nlink = current.nlink;
        current.nlink.plink = current.plink;
        head = current.nlink;
        return current.data;
    }
    public int deleteAttail()
    {
        if(head == null)
        {
            System.out.println("Empty list deletion not possible");
            return -1;
        }
        Node current = head.plink;
        current.plink.nlink = current.nlink;
        current.nlink.plink = current.plink;
        return current.data;
    }
    public void insertByposition(int pos,int val)
    {
        if(pos<1||pos>findlenght()+1)
        {
            System.out.println("Invalid postion insertion not possible");
            return;
        }
        Node newnode = new Node(val);
        Node current = head;
        Node temp = null;
        int count = 1;
        if(pos == 1)
        {
            insertAthead(val);
        }
        else if(pos == findlenght()+1)
        {
            insertAttail(val);
        }
        else
        {
             do {
                  if(count==pos)
                  {
                    newnode.nlink =current;
                    newnode.plink = temp;
                    temp.nlink = newnode;
                    current.plink = newnode;
                    return;
                  }  
                  temp = current;
                  current = current.nlink;
                  count++;
             } while (current!=head);
        }
    }

    public int deletebypostion(int pos)
    {
        if(pos<1||pos>findlenght()+1||head==null)
        {
            System.out.println("Invalid postion deletion not possible");
            return -1;
        }
        int val;
        Node current = head;
        Node temp = null;
        int count = 1;
        if(pos == 1)
        {
            return deleteAthead();
        }
        else if(pos == findlenght()+1)
        {
            return deleteAttail();
        }
        else
        {
            do {
                   if(count==pos)
                   {
                       current.nlink.plink = temp;
                       temp.nlink = current.nlink;
                       return current.data;
                   }
                   temp = current;
                   current = current.nlink;
                   count++;
            } while (current!=head);
        }
        return -1;
    }
    public int deletebykey(int key)
    {
        if(head==null)
        {
            System.out.println("Empty list deletion not possible");
            return -1;
        }
        Node current = head;
        int count = 1;
        while (current!=null){
            if(current.data == key)
            {
                return deletebypostion(count);
            }
            current = current.nlink;
            count++;
        }
        return -1;
    }
    public void createorderlist(int val)
    {
        Node current = head;
        Node newnode = new Node(val);
        if(head==null)
        {
           newnode.nlink = newnode.plink = newnode;
           head = newnode;
           tail = newnode;
           return;
        }
        int count =1;
        do {
              if(val<current.data)
              {
                insertByposition(count, val);
                return;
              }
              count++;
              current = current.nlink;
        } while (current!=head);
        newnode.nlink = current;
        newnode.plink = current.plink;
        current.plink.nlink = newnode;
        current.plink = newnode;
    }
    public void reverselist()
    {
        if(head==null)
        {
            System.out.println("Empty list");
            return;
        }
        Node current = head;
        Node prev = null;
        Node next = null;
        do {
            next = current.nlink;
            current.nlink = prev;
            prev = current;
            current.plink = next;
            current = next;
        } while (current!=head);
        head.nlink = prev;
        prev.plink = head;
        head = prev;
        tail = current;
    }
    public void freelist()
    {
        head = null;
    }

    public static void main(String args[])
    {
        cdll list =  new cdll();
        int val,pos,choice,key;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1.FINDLENGTH");
            System.out.println("2.INSERTATHEAD");
            System.out.println("3.INSERTATTAIL");
            System.out.println("4.DELETEATHEAD");
            System.out.println("5.DELETEATTAIL");
            System.out.println("6.INSERTBYPOSITITON");
            System.out.println("7.DELETEBYPOSTION");
            System.out.println("8.DELETEBYKEY");
            System.out.println("9.CREATEORDERDLIST");
            System.out.println("10.REVERSELIST");
            System.out.println("11.EXIT");
            System.out.println("Enter your choice of operation :");
            choice = sc.nextInt();
            switch (choice) {
               case 1:
                        list.Createlist();
                        System.out.println("The length of list is "+list.findlenght());
                        list.display();   
                        list.freelist();               
                        break;
               case 2:
                        list.Createlist();
                        System.out.println("Enter the value to be inserted");
                        val = sc.nextInt();
                        list.insertAthead(val);
                        list.display();
                        list.freelist();
                        break;
               case 3:
                       list.Createlist();
                       System.out.println("Enter the value to be inserted");
                       val = sc.nextInt();
                       list.insertAttail(val);
                       list.display();
                       list.freelist();
                       break;
               case 4:
                      list.Createlist();
                      val = list.deleteAthead();
                      if(val!=-1){
                      System.out.println(val+" is deleted from list");
                      }
                      list.display();
                      list.freelist();
                      break;
               case 5:
                      list.Createlist();
                      val = list.deleteAttail();
                      if(val!=-1)
                      {

                        System.out.println(val+" is deleted from list");
                      }
                      list.display();
                      list.freelist();
                      break;
               case 6:
                       list.Createlist();
                       System.out.println("Enter the postion and its value to be inserted");
                       pos = sc.nextInt();
                       val =sc.nextInt();
                       list.insertByposition(pos, val);
                       list.display();
                       list.freelist();
                       break;
               case 7:
                       list.Createlist();
                       System.out.println("Enter the postion to be deleted");
                       pos = sc.nextInt();
                       val =list.deletebypostion(pos);
                       if(val!=-1)
                       {
                        System.out.println(val+" is deleted from postion "+pos);
                       }
                       list.display();
                       list.freelist();
                       break;
               case 8:
                      list.Createlist();
                      System.out.println("Enter the key value to be deleted");
                     key = sc.nextInt();
                      val = list.deletebykey(key);
                      if(val!=-1)
                      {
                        System.out.println(val+" is deleted from list");
                      }
                      list.display();
                      list.freelist();
                      break;
               case 9:
                      list.Createlist();
                      System.out.println("Enter the value to be inserted");
                      val = sc.nextInt();
                      list.createorderlist(val);
                      list.display();
                      list.freelist();
                      break;
               case 10:
                       list.Createlist();
                       list.reverselist();
                       list.display();
                       list.freelist();
                       break;
               case 11:
                      System.out.println("--Exiting--");
                      break;
            
               default:
                        System.out.println("Invalid choice");
                  break;
            }
         }while(choice!=11);
     }
}

