package list;

public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void setHead(Node head) {
        this.head = head;
        this.incSize();
    }

    public Node getHead() {
        return this.head;
    }

    public void incSize() {
        this.size++;
    }

    public void decSize() {
        this.size--;
    }

    public int getSize() {
        return this.size;
    }

    public void add(String editor,String title) {
        Node isFound = this.searchData(editor);

        if (isFound == null) {
            this.setHead(new Node(new Data(editor,title), this.getHead()));
        } else {
            isFound.getData().setTitle(title);
            isFound.getData().addFreq();
        }

    }
    
    public void displayWithTitle(String editor) {
        Node isFound = this.searchData(editor);
        if (isFound != null) {
            System.out.print(isFound.getData().getName() + " mengedit artikel sebanyak " + isFound.getData().getFreq() + "\n");
            for (int i = 0; i< isFound.getData().getFreq() ; i++) {
                System.out.println((i+1) + ". " + isFound.getData().getTitle(i));
            }
            System.out.println("\n");
        } else {
            System.out.print("Nama dari " + editor + " tidak ditemukan.");
        }
    }


    public void displayWithoutTitle() {
        Node current = this.getHead();

        while (current != null) {
            System.out.println(current.getData().getName() + " mengedit " + current.getData().getFreq() + " artikel");
            if (current.getNext() == null)
                break;
            current = current.getNext();
        }
        System.out.println("\n");
    }

    public void InsertionSort() {
        Node current = this.getHead();
        Data tempData;
        while (current.getNext() != null) {
            while (current.getData().getName().compareTo(current.getNext().getData().getName()) > 0) {
                tempData = current.getNext().getData();
                current.getNext().setData(current.getData());
                current.setData(tempData);
                current = this.getHead();
            }
            current = current.getNext();

        }
    }

    public Node searchData(String editor) {
        Node current = this.getHead();

        while (current != null) {
            if (current.getData().getName().equals(editor))
                return current;
            if (current.getNext() == null)
                break;
            current = current.getNext();
        }

        return null;
    }

    public void searchContainsEditor(String editor) {
        Node current = this.getHead();

        while (current != null) {
            if (current.getData().getName().toLowerCase().contains(editor.toLowerCase())) {
                System.out.println(">>> " + current.getData().getName() + " memiliki total artikel yang diedit sebanyak " + current.getData().getFreq());
            }
            if (current.getNext() == null) {
                break;
            }
            current = current.getNext();
        } 
        System.out.println("\n");
    }
}
