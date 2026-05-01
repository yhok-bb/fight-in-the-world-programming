class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListStudy {
    Node head;

    public static void main(String[] args) {
      LinkedListStudy linkedlist = new LinkedListStudy();
      linkedlist.add(1);
      linkedlist.add(2);
      linkedlist.print();
      linkedlist.printHead();
      linkedlist.addFirst(3);
      linkedlist.print();
      linkedlist.delete(2);
      linkedlist.print();
      linkedlist.add(1, 5);
      linkedlist.print();
      linkedlist.reverse();
      linkedlist.print();

      Node res = linkedlist.find(3);
      if (res != null) {
          System.out.println(res.data);
      } else {
          System.out.println("見つからない");
      }
      Node res2 = linkedlist.find(7);
      if (res2 != null) {
          System.out.println(res2.data);
      } else {
          System.out.println("見つからない");
      }


      LinkedListStudy linkedlist2 = new LinkedListStudy();
      linkedlist2.add(1);
      linkedlist2.add(2);
      linkedlist2.add(3);
      linkedlist2.add(4);
      linkedlist2.add(5);
      linkedlist2.add(6);
      linkedlist2.add(7);
      linkedlist2.add(8);
      linkedlist2.add(9);
      linkedlist2.add(10);

      linkedlist2.print();

      Node center = linkedlist2.center();
      System.out.println(center.data);
    }

    void add(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node(data);
    }

    void add(int pos, int data) {
      if (head == null) {
        head = new Node(data);
        return;
       }

      if(pos <= 0) return;

      if(pos == 1) {
        addFirst(data);
        return;
      }

       Node current = head;

       for(int i = 0; i < pos-2; i++) {
         if(current.next == null) break;
         current = current.next;
       }

       Node newNode = new Node(data);
       Node next = current.next;
       current.next = newNode;
       newNode.next = next;
    }

    void addFirst(int data) {
      Node newNode = new Node(data);
      newNode.next = head;
      head = newNode;
    }

    Node find(int data) {
      Node current = head;

      while (current != null && current.data != data) {
        current = current.next;
      }

      return current;
    }

    void reverse() {
      Node prev = null;
      Node current = head;
      Node next;

      while(current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
      }
      head = prev;
    }

    Node center() {
      Node fast = head;
      Node slow = head;
      while(fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
        slow = slow.next;
      }
      return slow;
    }

    void delete(int data) {
      if(head == null) return;
      
      if(head.data == data) {
        head = head.next;
        return;
      }
      
      Node current = head;
      
      while (current.next != null && current.next.data != data) {
        current = current.next;
      }

      if(current.next != null) {
        current.next = current.next.next;
      }
    }

    void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println(""); 
    }

    void printHead() {
      System.out.println(head.data);
    }
}

