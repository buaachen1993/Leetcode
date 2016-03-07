package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * 51. N-Queens 
 * @author chandler
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that 
 * no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 Solution:
   分析arraylist和linkedlist,前者在get和set上有优势，后者在add和remove上有优势
   首先选定queen的位置，然后打印。可以用数组表示queen的位置，考虑如何遍历所有的情况。
 两个问题，首先是如何找到一个可行解，然后是如果遍历所有的解。
 只需要一个一维数组就可以维护了！queen的位置表示行数，储存的数表示列数，真是精巧啊！必须使用数组实现，否则会导致错误。
 针对第二个问题似乎有点难处理，找到一个可行解记录下来，然后回溯遍历。仔细考虑一下分函数的设计。
 */
public class N_Queens {
    public List<List<String>> solveNQueens(int n) {
    	List<List<String>> result = new LinkedList<List<String>>();
    	int[] queen = new int[n];
    	findNQueens(queen, n, 0 ,result);
    	return result;
    }
    
    public void findNQueens(int[] queen,int n,int row,List<List<String>> result){//生成皇后的序列
    	if(row == n)
    	{
    		//打印
    		List<String> solution = new LinkedList<String>();
    		String rowString = "";
    		for(int i = 0; i < queen.length ; i++)
    		{
    			for(int j = 0; j< queen.length ;j++)
    			{
    				if(j != queen[i])
    					rowString += ".";
    				else
    					rowString += "Q";
    			}
    			solution.add(rowString);
    			rowString = "";
    		}
    		result.add(solution);
    		return;
    	}
    	for(int column = 0;column < n;column++)
    	{
    		if(isValid(queen, row, column)){
    			queen[row] = column;
    			findNQueens(queen, n, row+1,result);//本层可以放下queen则进入下面一层寻找位置
    		}
    	}

    }
    //判断当前位置是否可以放置queen
    public boolean isValid(int[] queen,int row,int column)
    {

        for(int queenrow = 0;queenrow < row; queenrow ++){//注意！！！！！！这里只需要判定到row就可以了！！！因为后面的queen位置还没有确定
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
    	N_Queens test = new N_Queens();
    	System.out.println(test.solveNQueens(4));
    }
}
