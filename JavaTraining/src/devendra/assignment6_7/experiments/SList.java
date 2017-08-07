package devendra.assignment6_7.experiments;

public class SList<DataType> {
	
    protected Node<DataType> start;
    protected Node<DataType> end ;
    public int size ;

    /*  Constructor  */
    public SList()
    {
        start = null;
        end = null;
        size = 0;
    }
    
    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        return (start == null);
    }

    /*  Function to get size of list  */
    public int getSize()
    {
        return size;
    }    

    /*  Function to insert an element at start  */
    public void insertAtStart(DataType val)
    {
        Node<DataType> nptr = new Node<DataType>(val, null);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            nptr.setNextNode(start);
            start = nptr;
        }
    }

    /*  Function to insert an element at end  */
    public void insertAtEnd(DataType val)
    {
        Node<DataType> nptr = new Node<DataType>(val,null);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            end.setNextNode(nptr);
            end = nptr;
        }
    }

    /*  Function to insert an element at position  */
    public void insertAtPos(DataType val , int pos)
    {
        Node<DataType> nptr = new Node<DataType>(val, null);                
        Node<DataType> ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size; i++) 
        {
            if (i == pos) 
            {
                Node<DataType> tmp = ptr.getNextNode();
                ptr.setNextNode(nptr);
                nptr.setNextNode(tmp);
                break;
            }
            ptr = ptr.getNextNode();
        }
        size++ ;
    }

    /*  Function to delete an element at position  */
    public void deleteAtPos(int pos)
    {        
        if (pos == 1) 
        {
            start = start.getNextNode();
            size--; 
            return ;
        }
        if (pos == size) 
        {
            Node<DataType> s = start;
            Node<DataType> t = start;
            while (s != end)
            {
                t = s;
                s = s.getNextNode();
            }
            end = t;
            end.setNextNode(null);
            size --;
            return;
        }
        Node<DataType> ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                Node<DataType> tmp = ptr.getNextNode();
                tmp = tmp.getNextNode();
                ptr.setNextNode(tmp);
                break;
            }
            ptr = ptr.getNextNode();
        }
        size-- ;
    }    

    /*  Function to display elements  */
    public void display()
    {
        System.out.print("\nSingly Linked List = ");
        if (size == 0)
        {
            System.out.print("empty\n");
            return;
        }    
        if (start.getNextNode() == null) 
        {
            System.out.println(start.getData() );
            return;
        }
        Node<DataType> ptr = start;
        System.out.print(start.getData()+ "->");
        ptr = start.getNextNode();
        while (ptr.getNextNode() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getNextNode();
        }
        System.out.print(ptr.getData()+ "\n");
    }    

    
    
    private Node<DataType> head = new Node<DataType>();
    SListIterator<DataType> iterator()
    {
    	return new SListIterator<DataType> (head);
    }
    public String toString()
    {
    	if(head.link == null) return "SList: []";
    	
    	SListIterator<DataType> it = this.iterator();
		StringBuilder s = new StringBuilder(); 
		s.append("SList: [");
		while(it.hasNext()) {
			s.append(it.next().data + (it.hasNext() ? ", " : ""));
		}
		return s + "]";
    }

}
	

