package doublylist;
import java.util.Scanner;

class Node{
    int data;
    Node plink;
    Node nlink;
    Node(int data)
    {
        this.data = data;
        this.plink = this.nlink = null;
    }
}
public class dll{
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
    }
    public void display()
    {
        if(head==null)
        {
            System.out.println("Empty List");
            return;
        }
        Node current = head;
        while (current!=null){
            System.out.println(current.data);
            current = current.nlink;
        }
    }
    public void insertAthead(int data)
    {
        Node current = head;
        Node newnNode = new Node(data);
        if(head==null)
        {
            head = newnNode;
            tail = newnNode;
            return;
        }
        newnNode.nlink = head;
        head.plink = newnNode;
        head = newnNode;
    }
    public void insertAttail(int data)
    {
        Node current = head;
        Node newnode = new Node(data);
        if(head==null)
        {
            head = newnode;
            tail = newnode;
            return;
        }
        while (current.nlink!=null){
            current = current.nlink;
        }
        current.nlink = newnode;
        newnode.plink = current;
    }
    public int deleteAthead()
    {
        if(head == null)
        {
            System.out.println("Empty list deletion not possible");
            return -1;
        }
        Node current = head.nlink;
        current.plink = null;
        int val = head.data;
        head = head.nlink;
        return val;
    }
    public int deleteAttail()
    {
        if(head==null)
        {
            System.out.println("Empty list deletion not possible");
            return -1;
        }
        Node current = head;
        Node temp = null;
        while (current.nlink!=null){
            temp = current;
            current = current.nlink;
        }
        temp.nlink = null;
        return current.data;
    }
    public int findlenght()
    {
        Node current = head;
        int count  = 0;
        while (current!=null){
            count++;
            current = current.nlink;
        }
        return count;
    }
    public void insertByposition(int pos,int val)
    {
        if(pos<1 || pos>findlenght()+1)
        {
            System.out.println("Invalid postion insertion not possible");
            return;
        }
        Node current = head;
        Node newnode = new Node(val);
        Node prev = null;
        int count = 1;
        if(head == null)
        {
            head = newnode;
            tail = newnode;
            return;
        }
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
            while (current!=null){
                if(count== pos)
                {
                    newnode.nlink = prev.nlink;
                    newnode.plink = prev;
                    current.plink = newnode;
                    prev.nlink = newnode;
                    return;
                }
                prev = current;
                current = current.nlink;
                count++;
            }
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
            val = deleteAthead();
        }
        else if(pos == findlenght()+1)
        {
            val = deleteAttail();
        }
        else
        {
           while (current!=null){
                 if(count==pos)
                 {
                     temp.nlink =current.nlink;
                     current.nlink.plink = current.plink;
                     return current.data;
                 }
                 temp = current;
                 current = current.nlink;
                 count++;
           }
        }
        return -1;
    }
    public void createorderlist(int val)
    {
        Node newnode = new Node(val);
        Node current = head;
        if(head == null)
        {
            head = newnode;
            tail = newnode;
            return;
        }
        Node temp = null;
        int count = 1;
        while (current!=null){
            if(val<current.data){
                insertByposition(count, val);
                return;
            }
          temp = current;
          current = current.nlink;
          count++;
        }
        temp.nlink = newnode;
        newnode.plink = temp;
    }
    public void reverselist()
    {
        if(head == null)
        {
            System.out.println("Empty list");
            return;
        }
        Node current = head;
        Node prev = null;
        Node next = null;
        tail = head;
        while (current!=null){
            next = current.nlink;
            current.nlink = prev;
            prev = current;
            current.plink = next;
            current = next;
        }
        head = prev;
    }
    public void freelist()
    {
        head = null;
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
    
    public static void main(String args[])
    {
        doublylist list =  new doublylist();
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

