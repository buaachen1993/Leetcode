package problems;
/***
 * 72. Edit Distance 
 * @author chandler
 *Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 * (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
Subscribe to see which companies asked this question
Solution:
首先考虑长度不相等的情况，distance首先等于两者的差值。
1、对于插入字符 需要考虑在什么位置插入的问题  
2、对于删除 需要考虑删除哪一个字符的问题
3、对于替换，考虑的问题则相对少一点，只需要从头到尾访问一遍就可以
这种思路对于插入字符和删除字符显然很难处理 我们采用减治算法的思想 i,j分别表示两个字符串的下标 1——i
1. d[0, j] = j;
2. d[i, 0] = i;
3. d[i, j] = d[i-1, j - 1] if A[i] == B[j]
4. d[i, j] = min(d[i-1, j - 1], d[i, j - 1], d[i-1, j]) + 1  if A[i] != B[j]
//这道题的数组下标需要仔细考虑
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0)//如果有字符串为空
        	return word2.length();
        if(word2.length() == 0)
        	return word1.length();    
        int[][] distance = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i <= word1.length();i++)
        	distance[i][0] = i;
        for(int j=0;j <= word2.length();j++)
        	distance[0][j] = j;
        
        for(int i = 1;i <= word1.length();i++)
        	for(int j = 1 ; j <= word2.length();j++)
        	{
        		if(word1.charAt(i-1) == word2.charAt(j-1))
        			distance[i][j] = distance[i-1][j-1];
        		else{
        			distance[i][j] =Math.min(Math.min(distance[i-1][j],distance[i][j-1]), distance[i-1][j-1]) +1;
        		}	
        	}
        return distance[word1.length()][word2.length()];
 
    }
	public static void main(String args[])
	{
		EditDistance test = new EditDistance();
		String s1 = "distance";
		String s2 = "springbok";
		System.out.println(test.minDistance(s1, s2));
	}
}
