package devendra.assignment6_7.experiments;

public class Node<DataType> {
	
    protected DataType data;
    protected Node<DataType> link;

    /*  Constructor  */
    public Node()
    {
        link = null;
        data = null;
    }    

    /*  Constructor  */
    public Node(DataType d)
    {
    	this.data = d;
    }

    /*  Constructor  */
    public Node(Node<DataType> n)
    {
    	link = n;
    }
    
    /*  Constructor  */
    public Node(DataType d,Node<DataType> n)
    {
        data = d;
        link = n;
    }    

    /*  Function to set link to next Node  */
    public void setNextNode(Node<DataType> n)
    {
        link = n;
    }    

    /*  Function to get link to next node  */
    public Node<DataType> getNextNode()
    {
        return link;
    }    

    /*  Function to get data from current Node  */
    public DataType getData()
    {
        return data;
    }
    
    /*  Function to set data to current Node  */
    public void setData(DataType d)
    {
        data = d;
    }    

    /*  Function to covert DataType data to String data  */
    public String toString(DataType d)
    {
    	if(d==null) return null;
    	else return d.toString();
    		
    }

}
