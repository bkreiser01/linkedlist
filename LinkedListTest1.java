//Paul Eppley
//This class is a driver that tests the LinkedList class.

public class LinkedListTest1
{
    public static void main(String[] args)
    {   
        LinkedList<Integer> list = new LinkedList<Integer>();

        //Let's append some integers.  Note that we're using autoboxing.
        list.append(8);
        list.append(12);
        list.append(0);
        list.append(6);
        list.append(1);

        System.out.println("append");
        System.out.print("List contains: ");
        list.output();
        System.out.println("Should be:     8 12 0 6 1");

        //Let's try some prepends, now.
        System.out.println("");
        System.out.println("prepend");

        list.prepend(19);
        list.prepend(5);
        list.prepend(9);

        System.out.print("List contains: ");
        list.output();
        System.out.println("Should be:     9 5 19 8 12 0 6 1");

        //Now we can try some inserts, including at the beginning and end.
        System.out.println("");
        System.out.println("Insert 99 at pos 4");
        
        list.insert(99, 4);
        System.out.print("List contains: ");
        list.output();
        System.out.println("Should be:     9 5 19 99 8 12 0 6 1");

        System.out.println("");
        System.out.println("Insert at 2 at the beginning");

        list.insert(2, 1);
        System.out.print("List contains: ");
        list.output();
        System.out.println("Should be:     2 9 5 19 99 8 12 0 6 1");

        System.out.println("");
        System.out.println("Insert 3 at end");

        list.insert(3, 11);
        System.out.print("List contains: ");
        list.output();
        System.out.println("Should be:     2 9 5 19 99 8 12 0 6 1 3");

        //Next, let's try some removeFirst operations.
        System.out.println("");
        System.out.println("removeFirst");

        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        System.out.print("List contains: ");
        list.output();
        System.out.println("Should be:     19 99 8 12 0 6 1 3");

        //Now we'll do a couple of removeLast operations.
        System.out.println("");
        System.out.println("removeLast");

        list.removeLast();
        list.removeLast();
        System.out.print("List contains: ");
        list.output();
        System.out.println("Should be:     19 99 8 12 0 6");

        //Next, we'll test getFirst and getLast.
        System.out.println();
        System.out.println("getFirst");
        System.out.println("First element should be 19 and is " + list.getFirst());
        System.out.println();
        System.out.println("getLast");
        System.out.println("Last element should be 6 and is " + list.getLast());

        //Let's also test the get() method.
        System.out.println();
        System.out.println("get");
        System.out.println("The fourth element should be 12 and is " + list.get(4));

        //Now we'll removeFirst until there are none left.  There should be no crash and
        //no output.
        while(list.getLength() != 0)
            list.removeFirst();

        System.out.print("Nothing should be here {");
        list.output();
        System.out.println("}");

        //Now we'll create a new list containing a different type of object.
        LinkedList<String> stringList = new LinkedList<String>();

        //Let's test a special case--inserting into an empty list.
        stringList.insert("First String", 1);
        System.out.print("List contains: ");
        stringList.output();
        System.out.println("Should be:     First String");

        //Now we'll test removeLast when only one element exists in the list.
        stringList.removeLast();
        System.out.print("List contains: ");
        stringList.output();
        System.out.println("Should be:");

        //Put other tests here!

        //Finally, we'll throw an exception.
        System.out.println("We're about to remove from an empty list.");
        stringList.removeFirst();
    }
}