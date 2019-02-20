//Brandon Kreiser

public class LinkedList<E>
{

    private int length;
    private Node<E> firstPointer;
    private Node<E> lastPointer;

    public LinkedList()
    {
        length = 0;
        firstPointer = null;
        lastPointer = null;
    }
    

    public E getFirst()
    {
        if(length <= 0)
        {
            throw new EmptyListException("The list is empty!");
        }

        return firstPointer.data;
    }
    
    public E getLast()
    {
        if(length <= 0)
        {
            throw new EmptyListException("The list is empty!");
        }

        return lastPointer.data;
    }
    
    public E get(int position)
    {

        //Exceptions for a position greater than the length & a length less than zero.
        if(position > length)
        {
            throw new IllegalPositionException("You entered a number greater than the current length of the list.");
        }
        else if(length <= 0)
        {
            throw new IllegalPositionException("You entered a number less than zero or equal to zero.");
        }

        Node<E> currentNode = firstPointer;

        //Finds the proper posi
        if(position == 1)
        {
            return firstPointer.data;
        }
        else if(position == length)
        {
            return lastPointer.data;
        }
        else
        {
            for(int index = 0; index < position - 1; index++)
            {
                currentNode = currentNode.next;
            }

            return currentNode.data; 
        }   
    }
    
    public int getLength()
    {
        return length;
    }
    
    public void removeFirst()
    {
        if(length == 0)
        {
            throw new IllegalRemoveException("The list is empty!");
        }

        if(length == 1)
        {
            firstPointer = null;
        }
        else
        {
            firstPointer = firstPointer.next;  
        }

        length--;      
    }
    
    public void removeLast()
    {
        if(length < 0)
        {
            throw new IllegalRemoveException("The list is empty!");
        }
        else
        {
            if(length == 1)
            {
                firstPointer = null;
                lastPointer= null;
            }
            else
            {
                Node<E> currentNode = firstPointer;

                for(int index = 1; index < length - 1; index++)
                {
                    currentNode = currentNode.next;
                }
                
                lastPointer = currentNode;
                lastPointer.next = null;
            }

            length--;
        }
        
    }

    public void append(E element)
    {
        Node<E> newNode = new Node<E>(element, null);

        if(length == 0)
        {
            firstPointer = newNode;
            lastPointer = newNode;
        }
        else
        {
            lastPointer.next = newNode;
            lastPointer = newNode;
        }
        newNode.data = element;

        length++;
    }
    
    public void prepend(E element)
    {
        Node<E> node = new Node<E>(element, firstPointer);

        if(length == 0)
        {
            firstPointer = node;
            lastPointer = node;
        }
        else
        {
            node.data = element;
            node.next = firstPointer;
            firstPointer = node;
        }
        
        length++;
    }
    
    public void insert(E element, int position)
    {
        if(length <= 0)
        {
            throw new IllegalPositionException("The list is empty!");
        }

        if(position == 1)
        {
            prepend(element);
        }
        else if(position == length + 1)
        {
            append(element);
        }
        else
        {
            Node<E> nodeToBeInserted = new Node<E>(element, null);
            Node<E> currentNode = firstPointer;

            for(int index = 0; index < position - 2; index++)
            {
                currentNode = currentNode.next;
            }

            nodeToBeInserted.next = currentNode.next;
            currentNode.next = nodeToBeInserted;

            length++;
        }
    }

    public void output()
    {
        if(length > 0)
        {
            Node<E> currentNode = firstPointer;

            while(currentNode != lastPointer)
            {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
        
            System.out.println(lastPointer.data);
        }
    }
}