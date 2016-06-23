package problems;

import javax.print.attribute.standard.NumberUpSupported;

/***
 * 6. ZigZag Conversion
 * @author chandler
 *The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
Solutions:
1、 按照zigzag的顺序对字符串进行存储 
2、纯数学问题 注意序号的变化周期

 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
    	String[] rows = new String[numRows];
    	//防止null产生
		for(int j = 0;j< numRows;j++)
		{
			rows[j] = "";
		}
    	char[] input = s.toCharArray();
    	int len = s.length();
//    	if(len == 0 || numRows  < 2 )
//    		return s;
    	for(int i =0;i< len;)
    	{
    		//zig
    		for(int j = 0;j< numRows&&i < len;j++)
    		{
//    			System.out.println(input[i]);
    			rows[j] += input[i++];
    			
    		}
    		//zag
    		for(int j = numRows-2;j >0&&i < len;j--)
    		{
//    			System.out.println(input[i]);
    			rows[j] += input[i++];
    		}
    	}
    	String result = "";
		for(int j = 0;j< numRows;j++)
		{
//			System.out.println(rows[j]);
			result +=rows[j];
		}
    	return result;

    }
    public static void main(String args[])
    {
    	ZigZagConversion test = new ZigZagConversion();
    	System.out.println(test.convert("PAYPALISHIRING", 1));
    }
}
