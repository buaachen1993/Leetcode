package problems;
/***
 * 171. Excel Sheet Column Number
 * @author chandler
 *Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 

 */
public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		int column_number = 0;
		char[] title = s.toCharArray();
		for(int i =s.length()-1 ; i >=0 ;i--)
		{
			column_number += (title[i] - '@')*(Math.pow(26,(s.length()-1-i)));
		}
		return column_number;
	}
	public static void main(String args[])
	{	
		ExcelSheetColumnNumber test = new ExcelSheetColumnNumber();
		System.out.println(test.titleToNumber("Z"));
	}
}
