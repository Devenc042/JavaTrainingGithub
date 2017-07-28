package Devendra.assignment2;

public class AllPermutation {
	
	public static void main(String[] args)
    {
		int v = 122;
//		int level = 2;
		
		
		int number = v;
		int digit;
		String str = "";
		
		while(number!=0) {
			digit = number%10;
			number = number/10;
			str = str + (char) (digit+48);
		}

        int n = str.length();
        AllPermutation permutation = new AllPermutation();
        permutation.permute(str, 0, n-1);
    }
	
	/**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
 
    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
