public class LinkedListAntrian {
    Node head;
    Node tail;
    int size;

    public LinkedListAntrian() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void tambahAntrian(Kendaraan kendaraan) {
        Node baru = new Node(kendaraan);
        if (isEmpty()) {
            head = tail = baru;
        } else {
            tail.next = baru;
            tail = baru;
        }
        size++;
    }

    public Kendaraan layaniKendaraan() {
        if (isEmpty()) return null;
        Kendaraan data = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return data;
    }

    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println(">> Antrian kosong.");
            return;
        } else {
            Node current = head;
            while (current != null) {
            current.data.tampilkanInformasi();
            current = current.next;
            }
        }
    }

    public int hitungAntrian() {
        return size;
    }
}