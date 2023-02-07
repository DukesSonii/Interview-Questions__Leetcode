class Solution {
    public int[][] merge(int[][] intervals) {
        //dompare krlo intervals ke saare starting points ko 
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        Stack<int[]> stack = new Stack();
        stack.add(intervals[0]);    //pushing 1st interval
        
        //2nd interval se compare krenge
        for(int i=1;i<intervals.length;i++){
            //1st interval has laready been added
            int startpoint2 = intervals[i][0];  //2nd interval ka start point isliye 2
            int endpoint2 = intervals[i][1];    // "    "       "  end   "   "       "
            
            //first interval stack mai h toh usse pop kro
            int poparray[] = stack.pop();
            
            //1st interval ka start point or end point
            int startpoint1 = poparray[0];  //0 pos pe startpt1 hoga 
            int endpoint1 = poparray[1];
            
            //1 3
            //2 6  inko comapre
            int endmax = Math.max(endpoint2,endpoint1);
            //first interval ka endpoint second interval ke starting point se jada hona chaiye toh merge kro
            if(endpoint1 >= startpoint2){
                int [] merge = new int[]{startpoint1,endmax};
                stack.add(merge);      //merge karne ke baad stack mai dal do 
            }else{
                //merge nh kia toh usko stack mai push krdo 
                stack.add(poparray);
                stack.add(intervals[i]);    //stack mai current interval dala taki yeh inteval baad mai compare ho ske 
            }        
        }
        //ab yaha se stack ko khali krna h 
        int [][] output = new int [stack.size()][2]; //st ke size h utna intervals h or col 2 h st point, ep
        for(int i=output.length-1;i>=0;i--){    //stack mai ulta niklega toh isme bh ulta hi fill hoga 
            int []pop = stack.pop();
            output[i][0] = pop[0];  //o/p mai 0th pos pe starting point dalte rahenge 
            output[i][1] = pop[1];
        }
        return output;
    }                           
}
