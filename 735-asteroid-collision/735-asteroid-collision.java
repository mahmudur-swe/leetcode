class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        boolean[] isDestroy = new boolean[asteroids.length];
        
        Stack<Integer> stack = new Stack();
        
        for(int i=0;i<asteroids.length;){
            
            if(stack.size()==0){
                stack.add(asteroids[i]);
                i++;
            }else{
                int top = stack.peek();
                //System.out.println(top +" "+ asteroids[i] );
                if(top < 0 && asteroids[i]<0){
                    stack.add(asteroids[i]);
                    i++;
                }else if(top>0 && asteroids[i]>0){
                    stack.add(asteroids[i]);
                    i++;
                }else if(top<0 && asteroids[i]>0){
                    stack.add(asteroids[i]);
                    i++;
                }
                else if(Math.abs(top) == Math.abs(asteroids[i])){
                    
                    stack.pop();
                    i++;
                        
                }else if(Math.abs(top) < Math.abs(asteroids[i])){
                    
                    stack.pop();
                    
                    
//                     System.out.println("pop" + top +" "+ asteroids[i] );
                    
//                     while(stack.size()>0 && Math.abs(stack.peek())<Math.abs(asteroids[i])){
                        
//                         stack.pop();
                        
                    
//                     }
                    
//                     stack.add(asteroids[i]);
                    
                }else{
                    i++;
                }
                
            }
            
//         Iterator value = stack.iterator();
  
//         // Displaying the values
//         // after iterating through the stack
//         System.out.println("The iterator values are: ");
//         while (value.hasNext()) {
//             System.out.println(value.next());
//         }

            
        }
        
            int[] ans  = new int[stack.size()];
            int n = stack.size()-1;
            while(stack.size()>0){
                ans[n--] = stack.pop();
            }
            return ans;
        
    }
}