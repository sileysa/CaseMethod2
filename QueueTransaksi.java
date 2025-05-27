public class QueueTransaksi {
    TransaksiPengisian[] data;
    int front, rear, size, max;

    public QueueTransaksi(int kapasitas) {
        max = kapasitas;
        data = new TransaksiPengisian[max];
        size = 0;
        front = rear = -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void enqueue(TransaksiPengisian transaksi) {
        if (isFull()) {
            System.out.println("Queue transaksi penuh!");
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % max;
            }
            data[rear] = transaksi;
            size++;
        }
    }

    public TransaksiPengisian dequeue() {
        if (isEmpty()) {
            System.out.println("Queue transaksi kosong!");
            return null;
        } else {
            TransaksiPengisian temp = data[front];
            size--;
            if (isEmpty()) {
                front = rear = -1;
            } else {
                front = (front + 1) % max;
            }
            return temp;
        }
    }

    public void tampilkanTransaksi() {
        if (isEmpty()) {
            System.out.println("Tidak ada transaksi.");
        } else {
            int i = front;
            while (true) {
                data[i].tampilkanTransaksi();
                if (i == rear) break;
                i = (i + 1) % max;
            }
        }
    }

    public void clear() {
        front = rear = -1;
        size = 0;
        System.out.println("Queue transaksi dikosongkan.");
    }

    public int getSize() {
        return size;
    }
}