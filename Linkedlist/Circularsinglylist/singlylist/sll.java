package dsa-java.Linkedlist.Circularsinglylist.Singlylist;
import java.util.Scanner;

public class sll{
    Scanner sc = new Scanner(System.in);
    private ListNode head;
    private ListNode tail;
    private static class ListNode{
        private int data;
        private ListNode next;
        public ListNode(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    public void createlist(int n)
    {

        System.out.println("Enter the value of head node");
        int data = sc.nextInt();
        head = new ListNode(data);
        int i = 1;

        ListNode current = head;
        tail = head;
        
        while (i<n){
            System.out.println("Enter the value of "+(i+1)+" node");
            data = sc.nextInt();
            ListNode newnode = new ListNode(data);
            current.next = newnode;
            current = newnode;
            i++;
        }
        tail = current;
    }
    public void display()
    {
        if(head == null)
        {
            System.out.println("List is Empty");
            return;
        }
        ListNode current = head;
        while (current!=null){
         System.out.println(current.data);
         current = current.next;
        }
    }
    public int findlenght()
    {
        ListNode current = head;
        int count =0;
        while (current!=null){
            count++;
            current = current.next;
        }
        return count;
    }
    public void insertAthead(int data)
    {
        ListNode newnode = new ListNode(data);
        ListNode current = head;
        if(head == null)
        {
            head = newnode;
        }
        else{
            newnode.next = head;
            head = newnode;
        }
    }
    public void insetAttail(int data)
    {
        ListNode newnode = new ListNode(data);
        if(head == null)
        {
            head = newnode;
        }
        else
        {
            tail.next = newnode;
        }
    }
    public int deleteAthead()
    {

        if(head == null)
        {
            System.out.println("Empty list deletion not possible");
            return -1;
        }
        ListNode current = head;
        head = current.next;
        int data = current.data;
        current = null;
        return data;
    }
    public int deleteAttail()
    {
        if(head == null)
        {
            System.out.println("Empty list deletion not possible");
            return -1;
        }
        ListNode current = head;
        ListNode parent = null;
        while (current.next!=null){
            parent = current;
            current = current.next;
        }
        int data = current.data;
        if(parent!=null){
        tail =parent;
        parent.next = null;
        current = null;
        }
        else{
            tail = null;
            head = null;
        }
        return data;
    }
    public void insertByposition(int pos,int val)
    {
        ListNode current = head;
        ListNode prev = null;
        int i =1;
        ListNode newnode = new ListNode(val);
        if(pos == 1)
        {
            insertAthead(val);
        }
       else if(pos == findlenght())
        {
            insetAttail(val);
        }
        else
        {
           while (i!=pos){
             prev = current;
             current = current.next;
            i++;
           }
          prev.next = newnode;
          newnode.next = current;
        }
    }
    public int deleteBypos(int pos)
    {
        int data;
        int i =1;
        ListNode current = head;
        ListNode prev = null;
        if(pos>findlenght()||pos<0)
        {
            System.out.println("Invalid position deletion not possible");
            return -1;
        }
        if(pos==1)
        {
           data = deleteAthead();   
        }
        else if(pos == findlenght())
        {
            data = deleteAttail();
        }
        else
        {
            while (i<pos){
                prev =current;
                current = current.next;
                i++;
            }
            prev.next = current.next;
            data = current.data;
            current = null;
        }
        return data;
    }
    public void deleteBykey(int key)
    {
        ListNode current = head;
        ListNode prev = null;
        int i =1;
        int data;
        while (current!=null){
            
            if(current.data == key)
            {
                data = deleteBypos(i);
                System.out.println(key+"is deleted from list");
            }
            current = current.next;
            i++;
        }
    }
    public int searchBykey(int key)
    {
        ListNode current = head;
        while (current!=null){
            if(current.data == key)
            {
                return 1;
            }
            current = current.next;
        }
        return -1;
    }
    public int searchbypos(int pos)
    {
        ListNode current = head;
        int i = 1;
        if(pos<0||pos>findlenght())
        {
            System.out.println("Invalid postion searching not possible");
            return -1;
        }
        while (current!=null){
            if(i==pos)
            {
                return current.data;
            }
            current = current.next;
            i++;
        }
        return -1;
    }
    public void reverselist()
    {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        while (current!=null){
            next = current.next;
            current.next = prev;
            prev =current;
            current = next;
        }
        head = prev;
    }
    public ListNode findmiddleNode()
    {
        if(head==null)
        {
            System.out.println("Empty list");
            return null;
        }
        ListNode fastptr = head;
        ListNode slowptr = head;
        while (fastptr!=null&&fastptr.next!=null){
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
        }
        return slowptr;
    }
    public ListNode findnode(int n)
    {
        if(head == null)
        {
            System.out.println("Empty list");
            return null;
        }
        int count =0;
        ListNode rfrptr = head;
        ListNode mainptr = head;
    
        while (count<n){
            rfrptr = rfrptr.next;
            count++;
        }
        while (rfrptr!=null){
           rfrptr = rfrptr.next;
           mainptr = mainptr.next;
        }
        return mainptr;
    }
    public void freelist()
    {
          head = null;
    }
    public void removeduplicate()
    {
        if(head==null)
        {
            System.out.println("Empty list");
            return;
        }
        ListNode current = head;
        while (current!=null && current.next!=null){
            if(current.data==current.next.data)
            {
                current.next = current.next.next;
            }
            else
            {
                current = current.next;
            }
        }
    }
    public void createorderlist(int val)
    {
        ListNode current = head;
        int count = 1;
        if(head == null)
        {
            insertAthead(val);
            return;
        }
        else
        {
            while (current!=null){
                if(val<current.data)
                {
                    insertByposition(count, val);
                    return;
                }
                current = current.next;
                count++;
            }
            insetAttail(val);
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        singlylist list = new singlylist();
        ListNode tempNode = null;
        int choice,val,pos;
        do{
            System.out.print("1.InsertAthead\n2.InsertAttail\n3.DeleteAthead\n4.DeleteAttail\n5.Insertbypos\n6.DeletebyPos\n7.DelteBykey\n8.Searchbykey\n9.Searchbypos\n10.Reverselist\n11.FindMiddleNode\n12.Find nth node from end\n13.RemoveDuplicate\n14.CreatrOrderedList\n15.Exit\n");
            System.out.println("Enter your choice of operations");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                        list.createlist(5);
                       System.out.println("Enter the value to be inserted");
                       val = sc.nextInt();
                       list.insertAthead(val);
                       list.display();
                       list.freelist();
                    break;
                case 2:
                       list.createlist(5);
                       System.out.println("Enter the value to be inserted");
                       val = sc.nextInt();
                       list.insetAttail(val);
                       list.display();
                       list.freelist();
                       break;
                case 3:
                       list.createlist(5);
                       val = list.deleteAthead();
                       if(val!=-1){
                       System.out.println(val+" is deleted from list");}
                       list.display();
                       list.freelist();
                       break;
                case 4:
                       list.createlist(1);
                       val = list.deleteAttail();
                       if(val !=-1){
                       System.out.println(val+" is deleted from list");}
                       list.display();
                       list.freelist();
                        break;  
                case 5:
                       list.createlist(5);
                       System.out.println("Enter the position and value to be inserted");
                       pos = sc.nextInt();
                       val = sc.nextInt();
                       list.insertByposition(pos, val);
                       list.display();
                       list.freelist();
                       break;
                case 6:
                        list.createlist(5);
                        System.out.println("Enter the position to be deleted");
                        pos = sc.nextInt();
                        val = list.deleteBypos(pos);
                        if(val!=-1)
                        {
                            System.out.println(val+" is deleted from list");
                        }
                        list.display();
                        list.freelist();
                        break;
                case 7:
                        list.createlist(5);
                        System.out.println("Enter the key value to be deleted");
                        val = sc.nextInt();
                        list.deleteBykey(val);
                        list.display();
                        list.freelist();
                        break;
                case 8:
                        list.createlist(5);
                        System.out.println("Enter the key to be searched");
                        val = sc.nextInt();
                        pos = list.searchBykey(val);
                        if(pos!=-1)
                        {
                            System.out.println("Key found");
                        }
                        else
                        {
                            System.out.println("Key not found");
                        }
                        list.freelist();
                        break;
                case 9:
                         list.createlist(5);
                        System.out.println("Enter the position to be searched");
                        pos = sc.nextInt();
                        val = list.searchbypos(pos);
                        if(val!=-1)
                        {
                            System.out.println(val+" is found at postion "+pos);
                        }
                        list.freelist();
                        break;
                case 10:
                         list.createlist(5);
                         System.out.println("List after reversal");
                         list.reverselist();
                         list.display();
                         list.freelist();
                         break;
                case 11:
                          list.createlist(4);
                          tempNode = list.findmiddleNode();
                          if(tempNode!=null)
                          {
                            System.out.println(tempNode.data+" is the elements of middle node");
                          }
                          list.freelist();
                          break;
                case 12:
                          list.createlist(5);
                          System.out.println("Enter the postion of node from lastNode to find");
                          pos = sc.nextInt();
                          tempNode = list.findnode(pos);
                          if(tempNode!=null)
                          {
                            System.out.println(tempNode.data+"is found at postion "+pos);
                          }
                          list.freelist();
                          break;
                case 13:
                         list.createlist(5);
                         list.removeduplicate();
                         list.display();
                         break;
                case 14:
                          list.createlist(5);
                          System.out.println("Enter the value to be inserted");
                          val = sc.nextInt();
                          list.createorderlist(val);
                          list.display();
                          break;
                case 15:
                       System.out.println("--Exiting--");
                       break;
            
                default:
                      System.out.println("Invalid choice");
                    break;
            }
        }while(choice!=15);

    }
    
}

