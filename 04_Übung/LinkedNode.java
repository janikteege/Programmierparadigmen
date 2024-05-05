// Zusammenarbeit: Janik Teege, Nele Hüsemann


public class LinkedNode<E extends Comparable<E>> {

    private Node head; // reference to the first node in the list
    
    private class Node {
        
        private E item;      // reference to the item stored at this node
        private Node nextNode;    // reference to the subsequent node in the list
        
        private Node() {
            this(null, null);
        }
        
        private Node(E element, Node next) {
           item = element;   // creates a node with the given item
           nextNode = next;  // and next mode.
        }         
        
        public E getElement( ) { return item; } // Accessor methods
        public Node getNextNode( ) { return nextNode; } 
        public void setElement (E element) { this.item = element; }
        public void setNextNode(Node Node) { this.nextNode = Node; }        
    }
    
    public LinkedNode() {
        this.head = null;
    }
    
    public void insert(E item) {
        if (head == null) {
            head = new Node(item, null);
        } else {
            Node current = head;

            // If the item is less than the head, insert it at the beginning
            if (current.getElement().compareTo(item) > 0) {
                head = new Node(item, current);
                return;
            }

            // Find the correct position to insert the item
            while (current.getNextNode() != null && current.getNextNode().getElement().compareTo(item) < 0) {
                current = current.getNextNode();
            }

            Node newNode = new Node(item, current.getNextNode());
            current.setNextNode(newNode);
        }
    }
    
    public boolean contains(E item) {
        Node current = head;
        while (current != null) {
            if (current.getElement().equals(item)) {
                return true;
            }
            current = current.getNextNode();
        }
        return false;
    }
    
    public int getLength() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNextNode();
        }
        return count;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.getElement());
            sb.append("->");
            current = current.getNextNode();
        }
        sb.append("null");
        return sb.toString();
    }


    public static void main(String[] args) {
        // test your code
        LinkedNode<Integer> list = new LinkedNode<>();
        System.out.println("Empty Length: " + list.getLength());
        System.out.println("Empty: " + list);
        list.insert(4);
        System.out.println("Add 4: " + list);
        list.insert(5);
        System.out.println("Add 5: " + list);
        list.insert(1);
        System.out.println("Add 1: " + list);
        list.insert(3);
        System.out.println("Add 3: " + list);
        list.insert(6);
        System.out.println("Add 6: " + list);
        list.insert(2);
        System.out.println("Add 2: " + list);
        list.insert(5);
        System.out.println("Add second 5: " + list);  

        // test contains
        System.out.println("Contains 4: " + list.contains(4));
        System.out.println("Contains 5: " + list.contains(5));
        System.out.println("Contains 115: " + list.contains(115));
        
        // test getLength
        System.out.println("Length: " + list.getLength());
    }
}