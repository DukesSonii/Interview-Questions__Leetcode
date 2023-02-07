class Solution {
    public boolean isMatch(String s, String p) {
            int n = s.length();
        int m = p.length();
        
        boolean dp[][] = new boolean[n+1][m+1];
        
        //initialize
        dp[0][0] = true;
        
        //pattern =" "
        for(int i=1;i<n+1;i++){
            dp[i][0]=false;
        }
        
        //s=""
        for(int j=1;j<m+1;j++){
            if(p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];  //true hoga toh true or false h toh false
            } 
            //else by default all values are false
        }
        
        
        //bottom up code
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //case 1
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                
                //case 2 
                else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        //str -> n, pattern -> m
        return dp[n][m];

    }
}