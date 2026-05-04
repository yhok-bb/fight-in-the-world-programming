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
      boolean hasCycle = linkedlist2.hasCycle();
      System.out.println(hasCycle);

      Node center = linkedlist2.center();
      System.out.println(center.data);
      System.out.println(linkedlist2.isPalindrome()); // 回文(false)

      // 回文(true)
      LinkedListStudy pal1 = new LinkedListStudy();
      pal1.add(1);
      pal1.add(3);
      pal1.add(5);
      pal1.add(3);
      pal1.add(1);

      System.out.println(pal1.isPalindrome());

      // merge
      LinkedListStudy list1 = new LinkedListStudy();
      list1.add(1);
      list1.add(3);
      list1.add(5);

      LinkedListStudy list2 = new LinkedListStudy();
      list2.add(2);
      list2.add(4);
      list2.add(6);

      // マージ
      Node mergedHead = list1.merge(list1.head, list2.head);

      // 結果を表示
      Node current = mergedHead;
      while (current != null) {
          System.out.print(current.data + " -> ");
          current = current.next;
      }
      System.out.println("null");
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

    Node reverse(Node head) {
      Node prev = null;
      Node current = head;

      while (current != null) {
        Node next = current.next;
        current.next = prev;
        prev = current;
        current = next;
      }
      return prev;
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

    boolean hasCycle() {
      Node fast = head;
      Node slow = head;

      while(fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;

        if(fast == slow) return true;
      }
      return false;
    }

    boolean isPalindrome() {
      Node left = center();
      Node right = reverse(left.next);

      Node p1 = head;
      Node p2 = right;

      while (p2 != null) {
        if (p1.data != p2.data) return false;
        p1 = p1.next;
        p2 = p2.next;
      }

      // 戻す
      left.next = reverse(right);

      return true;
    }

    Node merge(Node l1, Node l2) {
      Node dummy = new Node(0);
      Node tail = dummy;
      while(l1 != null && l2 != null) {
        if(l1.data < l2.data) {
          tail.next = l1;
          tail = tail.next;
          l1 = l1.next;
        } else {
          tail.next = l2;
          tail = tail.next;
          l2 = l2.next;
        }
      }
      tail.next = (l1 != null) ? l1 : l2;
      return dummy.next;
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

