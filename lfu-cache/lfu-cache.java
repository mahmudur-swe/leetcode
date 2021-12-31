
class Node{
    Node left;
    Node right;
    int val;
    int key;
    int count;
    public Node(){}
}

class DQueue{
    
    Node head;
    Node tail;
    
    public DQueue(){
        head = new Node();
        tail = new Node();
        head.right = tail;
        tail.left = head;
    }
    
    public void deleteNode(Node node){
        try{
            node.left.right = node.right;
            node.right.left = node.left;
        }catch(Exception e){
            System.out.println("mode " + node);
            System.out.println("mode " + node.val);
        }
    }
    
    public void insert(Node node){
        
        node.left = head;
        node.right = head.right;
        
        head.right.left = node;
        head.right = node;
        
    }
    
    public void insert(Node node1,Node node2){
        
        node2.right = node1.right;
        node2.left = node1;
        node1.right.left = node2;
        node1.right = node2; 
        
    }
    
    public void delete(){
        
        Node node = tail.left;
        tail.left = node.left;
        node.left.right = tail;
        
    }
    
    public Node getLast(){
        return tail.left;
    }
    
    public Node getFirst(){
        return head.right;
    }
    
}

class LFUCache {

    Map<Integer,DQueue> countNode = new HashMap();
    
    DQueue counter = new DQueue();
    
    Map<String,Node> counterMap = new HashMap();
    
    Map<Integer,Node> keyMap = new HashMap();
    
    PriorityQueue<Integer> counts = new PriorityQueue(Collections.reverseOrder());
    
    int capacity = 0;
    int action = 0;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        
        if(capacity==0){
            return -1;
        }
        
        
        //System.out.println("====== Get " + key +" Get======");
        
        if(!keyMap.containsKey(key)){
            return -1;
        }
        
        
        Node node = keyMap.get(key);
        
        //System.out.println("Get " + key +" " + node.count);
        
        DQueue dQueue = countNode.get(node.count);
        
        dQueue.deleteNode(node);
        
        Node cNode = counterMap.get(node.count+"");
       
        //System.out.println("Get " + key +" "+cNode);
        //System.out.println("Get " + key + " cNode " +cNode.count);
        
        cNode.count--;
        
        node.count++;
        
        Node cNode2 = counterMap.get(node.count+"");
        
        if(cNode2 == null){
            cNode2 = new Node();
            cNode2.val = node.count;
            cNode2.count = 1;
            counter.insert(cNode,cNode2);
            counterMap.put(node.count+"",cNode2);
            //System.out.println("Empty Cnode2 => " + key + " " + counterMap.get(node.count+"").count + " "+node.count);
        }else{
            cNode2.count++;
            counterMap.put(node.count+"",cNode2);
            //System.out.println("cNode2 => " + key + " " + cNode2.count + " "+node.count);
        }
        
        if(cNode.count==0){
            counter.deleteNode(cNode);
            //System.out.println("Del "+ key +" " + cNode.count);
            counterMap.remove((node.count-1)+"");
        }
        
        
        DQueue dQueue2 = countNode.getOrDefault(node.count,new DQueue());
        
        dQueue2.insert(node);
        
        countNode.put(node.count,dQueue2);
        
        //System.out.println("Output "+key +" "+ node.val + " " + node.count);
        
        return node.val;
        
    }
    
    public void put(int key, int value) {
        
        if(capacity==0){
            return;
        }
        
        //System.out.println("====== put " + key +" " + value +" put======");
        
        Node node = keyMap.get(key);
        
        if(node == null){
            
            node = new Node();
            node.val = value;
            node.key = key;
            node.count = 1;
            
            
            if(action == capacity){
            
                Node first = counter.getFirst();
                
                first.count--;
                
                if(first.count==0){
                    counter.deleteNode(first);
                    counterMap.remove(first.val+"");
                }
                
                //System.out.println("First "+ first.val);
                
                Node mapNode = counterMap.get(first.val+"");
                
                
                
                
                DQueue dQueue = countNode.get(first.val);
                
                Node xx = dQueue.getLast();
                
                keyMap.remove(xx.key);
                
                //System.out.println("xx " + xx.key);
                
//                 mapNode.count--;
                
//                 if(mapNode.count==0){
//                     counterMap.remove(first.val+"");
//                 }
                
                dQueue.deleteNode(xx);
            
            }else{
                action++;
            }
            
        }else{
            node.val = value;
            node.count++;
        }
        
        if(node.count>1){
                
            DQueue dQueue = countNode.get(node.count-1);
            dQueue.deleteNode(node);
                
        }
            
        DQueue dQueue2 = countNode.getOrDefault(node.count,new DQueue());
        dQueue2.insert(node);
                
        countNode.put(node.count,dQueue2);
        
        int c = node.count-1;
        
        Node cNode = counterMap.get(c+"");
        
        if(cNode!=null){
            cNode.count--;
            //System.out.println("cNode => " + key + " " + cNode.count + " " + node.count);
        }
        
        Node cNode2 = counterMap.get(node.count+"");
        
        if(cNode2 == null){
            cNode2 = new Node();
            cNode2.val = node.count;
            cNode2.count = 1;
            if(cNode!=null){
                counter.insert(cNode,cNode2);
            }else{
                counter.insert(cNode2);
            }
            counterMap.put(node.count+"",cNode2);
            //System.out.println("Empty Cnode2 => " + key + " " + counterMap.get(node.count+"").count + " "+node.count);
        }else{
            cNode2.count++;
            counterMap.put(node.count+"",cNode2);
            //System.out.println("cNode2 => " + key + " " + cNode2.count + " "+node.count);
        }
        
        if(cNode!=null && cNode.count == 0){
            counter.deleteNode(cNode);
            counterMap.remove((node.count-1)+"");
        }
            
        
        
        
        //System.out.println(key +" " + node.val +" " + node.count+ " " + node.left+" "+ node.right);
        
        //System.out.println("Put" +" " + key + " "+node.count +" " + counterMap.get(node.count+"").count);
        
        keyMap.put(key,node);
           
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */