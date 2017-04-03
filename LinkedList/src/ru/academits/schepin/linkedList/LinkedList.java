package ru.academits.schepin.linkedList;

 class LinkedList {
    private static class Entry<E> {
        E element;
        Entry<E> next;
        Entry<E> prev;

        Entry(E element, Entry<E> next, Entry<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }


}
