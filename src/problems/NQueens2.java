package problems;
/***
 * 52. N-Queens II 
 * @author chandler
 *Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueens2 {
	public int totalNQueens(int n) {
		int res = 0;
		int[] queen = new int [n];
		res = findNQueens(queen, n, 0, 0);
		return res;
	}
	public int findNQueens(int[] queen,int n,int row,int solutionNum){//生成皇后的序列
		if(row == n)
		{
	    	return solutionNum+1;
	    }
	    for(int column = 0;column < n;column++)
	    {
	    	if(isValid(queen, row, column)){
	    		queen[row] = column;
	    		solutionNum = findNQueens(queen, n, row+1,solutionNum);//本层可以放下queen则进入下面一层寻找位置
	    	}
	    }
	    return solutionNum;
	}
	public boolean isValid(int[] queen,int row,int column)
	{
		for(int queenrow = 0;queenrow < row; queenrow ++)//注意！！！！！！这里只需要判定到row就可以了！！！因为后面的queen位置还没有确定
		{
	        int queenCol  = queen[queenrow];
	        if(queenCol ==  column)
	        	return false;
	        	//处理两种斜对角
	        if((queenCol - column) == (queenrow - row))
	        	return false;
	        if((queenCol - column) == (row - queenrow))
	        	return false;
	    }
	    return true;
	 }
	 public static void main(String args[]){
	    	NQueens2 test = new NQueens2();
	    	System.out.println(test.totalNQueens(8));
	    }
 
}
