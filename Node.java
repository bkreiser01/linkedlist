//Brandon Kreiser

public class Node<E>
{
    public E data;
    public Node<E> next;

    public Node(E element, Node<E> nextNode)
    {
        data = element;
        next = nextNode;
    }
}