public class SortedTopicList 
{

	private class ListNode
	{
		private Object data;	// representing data stored in the node
		private ListNode next;	// representing the next node in the list
		
		public ListNode()
		{
			this.data = null;	// "this" is a reference to the current object
			this.next = null;	// 
		}
		
		public ListNode(Ojbect inputData)
		{
			this.data = inputData;
			this.next = null;
		}
			
		public Object getData()
		{
			return data;
		}
		
		public void setData(Object data)
		{
			this.data = data;
		}
		
		public ListNode getNext(){
			return next;
		}
		
		public void setNext(ListNode next)
		{
			this.next = next;
		}
	}
	
	public void add(Object inputData) {
        ListNode node = new ListNode(inputData);

        /* Make sure we cater for the case where the list is empty */
        if (this.firstNode.getData() == null) {
          this.firstNode = node;
          this.lastNode = node;
        }
        else {
          this.lastNode.setNext(node);
          this.lastNode = node;
        }

        this.size++;
      }

	
      public void remove(Object inputData) {
        ListNode currentNode = this.firstNode;

        if (this.size == 0) {
          return;
        }

        boolean wasDeleted = false;

        /* Are we deleting the first node? */
        if (inputData.equals(currentNode.getData())) {

          /* Only one node in list, be careful! */
          if (currentNode.getNext() == null) {
            this.firstNode.setData(null);
            this.firstNode = new ListNode();
            this.lastNode = this.firstNode;
            this.size--;
            return;
          }

          currentNode.setData(null);
          currentNode = currentNode.getNext();
          this.firstNode = currentNode;
          this.size--;
          return;
        }

        while (true) {
          /* If end of list, stop */
          if (currentNode == null) {
            wasDeleted = false;
            break;
          }

          /* Check if the data of the next is what we're looking for */
          ListNode nextNode = currentNode.getNext();
          if (nextNode != null) {
            if (inputData.equals(nextNode.getData())) {

              /* Found the right one, loop around the node */
              ListNode nextNextNode = nextNode.getNext();
              currentNode.setNext(nextNextNode);

              nextNode = null;
              wasDeleted = true;
              break;
            }
          }

          currentNode = currentNode.getNext();
        }

        if (wasDeleted) {
          this.size--;
        }
      }

      public void remove(Object [] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
          this.remove(inputArray[i]);
        }
      }
      
      public int size() {
        return this.size;
      }
}


	
	
