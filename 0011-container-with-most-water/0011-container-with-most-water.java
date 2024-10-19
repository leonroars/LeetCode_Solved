/*

 0. Approach : O(n)
    1) Find the first wall pair and calculate the amount of water & save it.
       - The first wall pair is established when both left & right cursor finds non-zero height walls.
       - Left first, then find right.
    2) Shorter wall determines current amount of water.
       Thus, once first wall pair found, move the shorter side cursor.(Hoping for longer one).
    3) When moving cursor for left and right,
      - If longer one than previous one found, calculate the amount of water and update the maximum if it's needed.
      - For shorter one, skip it.
    4) When left and right cursor crosses, the search ends.
    
 */

class Solution {
    public int maxArea(int[] height) {
        int maxByFar = 0;
        int currentLeft = 0; // Left wall cursor.
        int currentRight = height.length - 1; // Right wall cursor.
        
        // 1. Finding the first left & right wall.
        while(height[currentLeft] == 0){currentLeft++;}
        while(height[currentRight] == 0){currentRight--;}
        
        
        
        while(currentLeft < currentRight){
            // Find which one is shorter.
            int shorterWall = (height[currentLeft] <= height[currentRight]) ? (currentLeft) : (currentRight);
            // The amount of water that can be stored by currentLeft & currentRight.
            int currentWater = (currentRight - currentLeft) * height[shorterWall];
            // Updates maxByFar if it's needed.
            if(currentWater > maxByFar){maxByFar = currentWater;}
            
            // Moving pointers.
            if(shorterWall == currentLeft){currentLeft++;}
            else{currentRight--;}
        }
        
        return maxByFar;
    }
}