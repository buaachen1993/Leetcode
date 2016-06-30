package problems;
/***
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the
 *  container contains the most water.
Note: You may not slant the container.
 * @author chandler
 * Solutions:
 * 总算读懂题目意思了，寻找隔板和底板构成的最大的容积
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int n = height.length;
        int left = 0;int right = n-1;
        //从两边向中间检索
        while(left<right)
        {
        	 max = Math.min(max, Math.min(height[left], height[right])*(right-left));
        	 if(height[left] < height[right])//处理左界
        	 {
        		 int k = left;
        		 while(k<right&&height[k] <= height[left])
        			 k++;
        		 left = k;
        	 }
        	 else
        	 {
        		 int k = right;
        		 while(k>left&&height[k] <= height[right])
        			 k--;
        		 right = k;
        	 }
        }
        return max;
    }
}
