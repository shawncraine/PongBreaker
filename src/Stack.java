class Stack {
	private int[] arr; // Same as before
	private int maxSize; // Same as before
	private int top; // Index of the top of the stack

	public Stack(int size) {
		arr = new int[size];
		maxSize = size;
		top = -1; // Initially -1
	}
	
	// Operations: 3 -> O(1)
	public void push(int value) {
		// If the stack is full, don't do it!
		if (isFull())
			return;
		// Increment top
		top++;
		// Put the value there
		arr[top] = value;
	}
	
	// Operations: 3 -> O(1)
	public int pop() {
		// If the stack is empty, do not pop!
		if (isEmpty())
			return ' ';
		// Get the value on top
		int val = arr[top];
		// Delete it
		top--;
		// Return it
		return val;
	}

	// Operations: 0 -> O(1)
	public int peek() {
		// Return the element on top
		return arr[top];
	}

	// Operations: 0 -> O(1)
	public boolean isEmpty() {
		return (top == -1);
	}

	// Operations: 0 -> O(1)
	public boolean isFull() {
		return (top == maxSize - 1);
	}
}