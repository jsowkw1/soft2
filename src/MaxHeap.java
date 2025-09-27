import java.util.ArrayList;

public class MaxHeap {
    private ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    // Вставка нового элемента
    public void insert(int val) {
        heap.add(val);
        int i = heap.size() - 1;
        while (i > 0 && heap.get((i - 1) / 2) < heap.get(i)) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }


    public int extractMax() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");

        int max = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapify(0);
        }

        return max;
    }

    // Увеличение ключа в позиции index
    public void increaseKey(int index, int newValue) {
        if (index < 0 || index >= heap.size()) throw new IllegalArgumentException("Invalid index");
        if (newValue < heap.get(index)) throw new IllegalArgumentException("New value must be greater");

        heap.set(index, newValue);

        // поднимаем элемент вверх, если нарушена структура кучи
        while (index > 0 && heap.get((index - 1) / 2) < heap.get(index)) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // Вспомогательная функция heapify (просеивание вниз)
    private void heapify(int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }

        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    // Обмен элементов
    private void swap(int i, int j) {
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }


    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();

        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(30);
        maxHeap.insert(15);

        System.out.println("Heap: ");
        maxHeap.printHeap();

        System.out.println("Extract max: " + maxHeap.extractMax());
        maxHeap.printHeap();

        maxHeap.increaseKey(2, 50);
        System.out.println("After increaseKey: ");
        maxHeap.printHeap();
    }
}

