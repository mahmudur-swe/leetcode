class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x<10){
            return true;
        }
        
        int input = x;
        int reverse = 0;
        
        while(input>0){
            
            reverse = reverse*10 + (input%10);
            input /= 10;
            
        }
        
        //System.out.println(reverse);
        
        return x == reverse;
    }
}

/*

Time = O(1)
Space = O(1)

If negtive return false

if positive -> reverse the integer and assign to a long variable
and check weather two are same or not.

same = true

*/