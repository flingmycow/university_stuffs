public class SLList
{

	protected Element head;
	protected Element tail;
	
	public final class Element
	{
		Object data;
		Element next;
		
		Element (Object data, Element next)
		{
			this.data;
			this.next;
		}
		
		public Object getData()
		{
			return data;
		}
		
		public Element getNext()
		{
			return next;
		}
		
	}
}

class Test
{
	
	public static void main(String[] args)
	{
		SSList list = new SSList();
		
		list.insert(1, 3);
		list.insert(4, 6);
		list.insert(7, 9);
		
		system.out.println(data);
		system.out.println(next);
	}
}
