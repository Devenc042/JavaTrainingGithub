package devendra.assignment6_7.experiments;

public class SListIterator<DataType> 
{
	
	Node<DataType> current;
	SListIterator(Node<DataType> link) 
	{
		current = link;
	}
	
	public boolean hasNext() 
	{
		return current.getNextNode() != null;
	}
	
	public Node<DataType> next() 
	{
		current = current.getNextNode();
		return current;
	}
	
	public void insert(DataType data) 
	{
		current.link = new Node<DataType>(data, current.link);
		current = current.link;
	}	
	
	public void remove() 
	{
		if(current.link != null) {
			current.link = current.link.link;
		}
	}
}