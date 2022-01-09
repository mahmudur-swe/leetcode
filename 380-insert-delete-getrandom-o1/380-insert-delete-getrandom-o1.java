// class Node{
//     int val;
//     Node next;
//     Node pre;
//     public Node(){}
// }

// public DList{
    
//     Node head;
//     Node tail;
    
//     public DList(){
        
        
        
//     }
    
// }

class RandomizedSet {

    Map<Integer,Integer> valMap = new HashMap();
    
    Map<Integer,Integer> posMap = new HashMap();
    
    int curPos  = 0;
    
    Random rand;
    
    public RandomizedSet() {
        rand  = new Random();
    }
    
    public boolean insert(int val) {
        if(valMap.containsKey(val)){
            return false;
        }
        
        valMap.put(val,++curPos);
        posMap.put(curPos,val);
        
        return true;
    }
    
    public boolean remove(int val) {
        if(!valMap.containsKey(val)){
            return false;
        }
        
        int pos = valMap.get(val);

        int val2 = posMap.get(curPos);
        
        posMap.put(pos,val2);
        
        valMap.put(val2,pos);
        
        posMap.remove(curPos--);
        valMap.remove(val);
        
    
        
        return true;
    }
    
    public int getRandom() {
       
        return posMap.get(rand.nextInt(curPos)+1);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */