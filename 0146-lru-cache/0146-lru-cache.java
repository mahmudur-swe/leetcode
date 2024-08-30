
class Node{
    int value = -1;
    int key = -1;
    Node pre;
    Node next;
    public Node(){
        
    }
}

class DLinkedList{
    
    Node head;
    Node tail;
    
    int size = 0;
    
    public DLinkedList(){
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }
    
    public void insert(Node node){
        
        
        //System.out.println("pre head next " + head.next.key + " " + head.next.value);
        
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
        
        
        //System.out.println("current head next " + head.next.key + " " + head.next.value);
        
        size++;
        
    }
    
    public Node getLast(){
        return tail.pre;
    }
    
    public void remove(Node node){
        
        //System.out.println("tail pre" + tail.pre.key +" "+tail.pre.value);
        //System.out.println("remove node" + node.key +" "+node.value);
        
        
        node.pre.next = node.next;
        node.next.pre = node.pre;
        
        size--;
    }
    
    public void removeLast(){
        
        remove(tail.pre);
        
    }
    
    
}

class LRUCache {
    

    Map<Integer,Node> map = new HashMap();
    
    int capacity;
    
    DLinkedList linkedList = new DLinkedList();
    
    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        linkedList = new DLinkedList();
        
        
    }
    
    public int get(int key) {
        
        //System.out.println("=======get==========");
        //System.out.println("get " + key);
        
        Node node = map.get(key);
            
        if(node!=null){
            linkedList.remove(node);
            linkedList.insert(node);
            return node.value;    
        }
        
        return -1;
        
    }
    
    public void put(int key, int value) {
        
        
        //System.out.println("=======put==========");
        
        //System.out.println("insert " + key + " " + value);
        
        Node node = null;
         
        if(map.containsKey(key)){
            node = map.get(key);
            linkedList.remove(node);
            node.value = value;
            linkedList.insert(node);
         }else{
            
            if(linkedList.size == capacity){
                Node last = linkedList.getLast();
                
                //System.out.println("remove" + last.key + " " + last.value);
                
                if(last!=null){
                    map.remove(last.key);
                    linkedList.remove(last);
                }
              
            }
            
            node = new Node();
            node.key = key;
            node.value = value;
            map.put(key,node);
            linkedList.insert(node);
            
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */