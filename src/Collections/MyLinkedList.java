package Collections;

import java.util.Arrays;

public class MyLinkedList<E> {
    private Node<E> head;
    private int size;

    public boolean add(E value) {
        if(head == null) {
            head = new Node<>(value);
        } else {
            Node<E> temp = head;

            while (temp.getNext() != null) {
                temp = temp.getNext();
            }

            temp.setNext(new Node<>(value));
        }

        this.size++;
        return true;
    }

    public int getSize() {
        return size;
    }

    public void remove (int index) throws IndexOutOfBoundsException {
        checkElementIndex(index);

        if (index == 0 ) {
            head = head.getNext();
            size--;
            return;
        }

        Node<E> temp = head;
        int idx = 0;

        while (temp != null) {
            if (idx == index - 1) {
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            }

            idx++;
            temp = temp.getNext();
        }
        //[1] -> [2] -> [3] -> [4]
    }

    public E get(int index) throws IndexOutOfBoundsException {
        checkElementIndex(index);
        return node(index).getValue();
    }

    private Node<E> node(int index) throws IndexOutOfBoundsException {
        Node<E> temp = head;
        int idx = 0;
        while (temp != null) {
            if (idx == index) return temp;

            idx++;
            temp = temp.getNext();
        }

        throw new IndexOutOfBoundsException();
    }

    private void checkElementIndex(int index) throws IndexOutOfBoundsException {
        if(!isElementIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public String toString() {
        int[] result = new int[size];

        Node<E> temp = head;

        int index = 0;
        while (temp != null) {
            result[index++] = (int) temp.getValue();
            temp = temp.getNext();
        }

        return Arrays.toString(result);
    }

    private static class Node<E> {
        E value;
        private Node<E> next;

        public Node (E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }
        public void setValue(E value) {
            this.value = value;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
