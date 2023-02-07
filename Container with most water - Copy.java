class Solution {
    public int maxArea(int[] height) {
        int maxwater = 0;
        int lp=0, rp= height.length-1;
        
        while(lp<rp){
            //calc area
            int ht = Math.min(height[lp], height[rp]); 
            int width = rp-lp;
            int area= ht*width;
            maxwater = Math.max(area,maxwater);
            
            //update area
            if(height[lp]<height[rp]) {  //jo chota hoga vo update hoga
                lp++;
            }			//paani choti line se control hoga woh logic h
            else {
                rp--;
            }
        }
        return maxwater;
    }
}

/*
int maximumArea = Integer.MIN_VALUE;
        // Left and right pointers
        int left = 0;
        int right = height.length - 1;
        // Loop until left and right meet
        while (left < right) {
            // Shorter pole/vertical line
            int shorterLine = Math.min(height[left], height[right]);
            // Update maximum area if required
            maximumArea = Math.max(maximumArea, shorterLine * (right - left));
            // If there is a longer vertical line present
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maximumArea;
*/