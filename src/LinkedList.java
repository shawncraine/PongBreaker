class Link {
	public Block data;
	public Link previous;
	public Link next;
}

class LinkedList {
    private Link first;   // We can get anywhere from here
    private Link last;    // Refers to the last element

    // Ops: 2 -> O(1)
    public LinkedList() {
    	first = null;
    	last = null;
    }

    // Ops: 1 -> O(1)
    public boolean isEmpty() {
    	return (first == null);
    }

    // Ops: 8  -> O(1)
    public void insertFirst(Block x) {
       // Create a new link
       Link newLink = new Link();
       newLink.data = x;

       // Put it at the front
       newLink.next = first;
       first = newLink;
       if (first.next != null)
          first.next.previous = first;

       // Change last if it's the only element
       if (last == null)
    	   last = newLink;
    }

    // Ops: 7  -> O(1)
    public void insertLast(Block x) {
    	if (isEmpty())
    	{
    		insertFirst(x);
    		return;
    	}

    	// Create a new link
        Link newLink = new Link();
        newLink.data = x;

        // Put it at the end
        last.next = newLink;
        newLink.previous = last;
        last = newLink;

        // Change first if it's the only element
        if (first == null)
     	   first = newLink;     
    }

    // Ops: 4  -> O(1)
    public void deleteFirst() {
    	// no items in list
    	if(first == null)
    		return;
    	// one element in list
    	else if(first == last)
    	{
    		first = null;
    		last = null;
    		return;
    	}
    	// two+ elements in list
    	else{
    		first = first.next;
    		first.previous = null;
    		return;
    	}
    }

    // Display the entire list
    // Ops: 2n + 1  -> O(n)
    public void displayForward() {
    	Link current = first;   // Hop through the list
    	
    	while (current != null) {
    	   System.out.print(current.data+" "); // Print
    	   current = current.next;  // Advance to next
    	}
    	
    	System.out.println();  // Newline at the end
    }

    // Display the entire list
    // Ops: 2n + 1  -> O(n)
    public void displayBackward() {
    	Link current = last;   // Hop through the list

    	while (current != null) {
    	   System.out.print(current.data+" "); // Print
    	   current = current.previous;  // Advance to next
    	}

    	System.out.println();  // Newline at the end
    }

    // Return true if x is there,
    // and false if it's not there
    // Ops: 2.5n+2  -> O(n)
    public boolean find(Block x) {
        Link current = first;  // current is init. first
        Link current2 = last;  // current2 is init. last

        while (current.previous != current2) {
              if (current.data == x)   // Found!
            	  return true;
              if (current2.data == x)  // Found!
            	  return true;
              if (current == current2)
            	  return false;
        	  current = current.next;  // Forward
        	  current2 = current2.previous; // Backward
        }

        return false;
    }

    // Ops: 2  -> O(1)
    public void deleteLast() {
    	// nothing in list
    	if(last == null)
    		return;
    	// one item in list
    	else if(last.previous == null)
    	{
    		first = null;
    		last = null;
    		return;
    	}
    	// two+ items in list
    	Link prev = last.previous;
    	// delete reference to last item in list
    	prev.next = null;
    	// update last to point to new last element
    	last = prev;
    }
    
    public Block peekFirst()
    {
    	return first.data;
    }
    public Block peekLast()
    {
    	return last.data;
    }

    // Ops: 6n + 2
    public void delete(Block x) {
    	Link prev = null;
    	Link current = first;  // current is first

    	while (current != null) {
    		// Found!
    		if (current.data == x) {
    			prev.next = current.next;
    			current.next.previous = prev;
    		}

    		// At all times, previous is one behind current
    		prev = current;
    	    current = current.next;		
    	}
    }
}