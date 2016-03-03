package problems;
/***
 * 8. String to Integer (atoi)
 * @author chandler
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. 
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
   Solution:
          主要考虑以下情况：这道题没有太大的难度，主要是考虑清楚各种情况即可
   1、开始有空格
   2、读入正负
   3、忽略非数字字符
   4、没有数字
   5、数字超限 比较难处理
   
 */
public class Atoi {
	public int myAtoi(String str) {
		  String number = "";
		  str = str.trim();//抛弃多余的空格
		  System.out.println(str);
		  char[] string = str.toCharArray();
		  boolean ispositive = true;
		  int i = 0;
		  if(i == str.length())//全空或全0
			  return 0;
		  //接下来需要判定首字母是否合法，应当是数字或者正负号则合法
		  if(string[i] == '-' )
		  {
			  ispositive = false;
			  i++;
		  }
		  else 
			  if(string[i] == '+')
				  i++;
		  if(i<str.length()&&string[i] >= '0' && string[i] <='9')
		  {
			  number += string[i];
			  i++;

			  while(i<str.length()&&string[i] >= '0' && string[i] <='9')
			  {
				  number += string[i];
				  i++;
			  }
			  if(ispositive == true){
				  try{

					  return Integer.valueOf(number).intValue();
				  }catch(Exception e){
					  	return 2147483647;//数据溢出，返回最大值
				  }finally{
				  }
			  }
			  else
				  try{
					  return -Integer.valueOf(number).intValue();
				  }catch(Exception e){
					  	return -2147483648;//数据溢出 返回最小值
				  }finally{
				  }
		  }
		  else
			  return 0;
		
		  
	    }
		public int myAtoi2(String str) {//应该快在了不需要调用integer的方法
			if (str == null || str.length() < 1)
				return 0;
		 
			// trim white spaces
			str = str.trim();
		 
			char flag = '+';
		 
			// check negative or positive
			int i = 0;
			if (str.charAt(0) == '-') {
				flag = '-';
				i++;
			} else if (str.charAt(0) == '+') {
				i++;
			}
			// use double to store result
			double result = 0;
		 
			// calculate value
			while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				result = result * 10 + (str.charAt(i) - '0');
				i++;
			}
		 
			if (flag == '-')
				result = -result;
		 
			// handle max and min
			if (result > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
		 
			if (result < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		 
			return (int) result;
				
		}

	  	public static void main(String args[])
	  	{
			 Atoi test = new Atoi();
			 System.out.println(test.myAtoi("     10"));
	  	}
}
