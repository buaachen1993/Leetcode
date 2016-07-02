package problems;
/***
 * 12. Integer to Roman
 * @author chandler
 *Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
Subscribe to see which companies asked this question
Solution: 范围是1到3999 通过打表的方法提高效率 避免了很多问题
TODO：完全的规则方法
 */
public class Integer2Roman {
    public String intToRoman(int num) {
        String Roman = "";
        //length = 13
        //通过打表的方法避免了左减的出现，全部转化成了右加的问题 即使是最大的数也可以
        String symbol[]={"M", "CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};    
        int    value[]= {1000, 900,500, 400,100,  90, 50, 40 , 10, 9  , 5 ,  4 , 1}; 
        for(int i = 0;num != 0;i++)
        {
        	while(num >= value[i])
        	{
        		num = num - value[i];
        		Roman = Roman + symbol[i];
        	}
        }
        return Roman;
    }
    public static void main(String args[]){
    	Integer2Roman test = new Integer2Roman();
    	System.out.println(test.intToRoman(3999));
    }

}
