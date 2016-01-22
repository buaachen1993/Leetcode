package uitl;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Enumeration;


public class Hashtable_test {
	//哈希表测试
	public static void main(String[] args) {
		//key value
		Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();
		//get 和put进行读取
	    numbers.put("one", 1);
	    numbers.put("two", 2);
	    numbers.put("three", 3);
	    numbers.put("four", 4);
	    numbers.put("five", 5);

	    Integer n = numbers.get("six");
	    Integer nn = numbers.get("one");
    
	    if(n != null)
	    	System.out.println(n);
	    //遍历方法1
	    Enumeration<String> en = numbers.keys(); 
	    while(en.hasMoreElements())
	    {
		    System.out.println(en.nextElement());
	    }
	    //遍历方法2 采用set的遍历方法
	    for(Iterator<String>   it   =   numbers.keySet().iterator();   it.hasNext();   )   {   
            String   key   =   (String)   it.next();   
            Object   value   =   numbers.get(key);   
            System.out.println(key+value);
        }  
	 }
}
