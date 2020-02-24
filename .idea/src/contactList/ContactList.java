package contactList;

import contactADT.ContactADT;

public class ContactList<Person> implements ContactADT<Person> {
    private Node<Person> head = null;
    public int size = 0;

    private Node<Person> getNode(int index) {
        Node<Person> response = head;
        for (int i = 0; i < index && response != null; i++) {
            response = response.getNext();
        }
        return response;
    }

    private boolean addFirst(Person data) {
        head = new Node<>(data, null);
        size++;
        return true;
    }

    private boolean addAfter(Person data, Node<Person> node) {
        node.next = new Node<>(data, node.next);
        size++;
        return true;
    }

    private boolean add(Person data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            return addFirst(data);
        } else {
            Node<Person> temp = getNode(index - 1);
            return addAfter(data, temp);
        }
    }

    @Override
    public boolean add(Person data) {
        return add(data, size);
    }

    public Person view(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            Person data = this.getNode(0).getData();
            return data;
        } else {
            Person data = this.getNode(index).getData();
            return data;
        }
    }

    @Override
    public void view() {
        System.out.println("---Here are all your contacts---");
        for (int i = 1; i <= size; i++) {
            Person data = this.getNode(i - 1).getData();
            System.out.println(data);
        }
    }

    private Person deleteFirst() {
        Person response = null;
        Node<Person> temp = head;
        if (head != null) {
            head = head.getNext();
        }
        if (temp != null) {
            size--;
            response = temp.getData();
        }
        return response;
    }

    private Person deleteAfter(Node<Person> node) {
        Person response = null;
        Node<Person> temp = node.getNext();
        if (temp != null) {
            node.next = temp.getNext();
            size--;
            response = temp.getData();
        }
        return response;
    }

    public Person delete(int index) {
        Person response = null;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            deleteFirst();
        } else {
            Node<Person> temp = getNode(index - 1);
            response = deleteAfter(temp);
        }
        return response;
    }

    @Override
    public Person delete() {
        return delete(size - 1);
    }

    private class Node<Person> {
        private Person data;
        private Node<Person> next;

        public Node(Person data, Node<Person> next) {
            this.data = data;
            this.next = next;
        }

        public Person getData() {
            return data;
        }

        private Node<Person> getNext() {
            return next;
        }
    }
}