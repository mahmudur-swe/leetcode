class LRUCache {

    Node[] nodeMapper = new Node[10001];

    int capacity = 0;
    int currentCacheSize = 0;

    Node startNode = null;
    Node endNode = null;

    
    List<String> cacheList = new ArrayList();


    public LRUCache(int capacity) {
        this.capacity = capacity;
       
    }
    
    public int get(int key) {
        Node node = nodeMapper[key];
        if(node!=null){
            addOrUpdateCache(key,node);
            return node.data;
        }
        return -1;
    }
    
    public void put(int key, int value) {

        Node node = nodeMapper[key];

        if(node == null){
            node = new Node(key,value);
        }else{
            node.data = value;
        }

        addOrUpdateCache(key,node);
        
    }


    private Node removeCache(int key){

        Node maper = nodeMapper[key];

        return removeCache(maper);

    }

    private Node removeCache(Node maper){

        if(maper==null){
            return null;
        }

        currentCacheSize--;

        Node start = maper.pre;
        Node end = maper.next;

        if(start == null){
            startNode = end;
           
        }else{
            start.next = end;
           
        }

        if(end == null){
            endNode = start;
        }else{
            end.pre = start;
           
        }
        
        nodeMapper[maper.key] = null;

        return maper;
    }


    private void addOrUpdateCache(int key, Node node){

        if(nodeMapper[key] == null && currentCacheSize+1>capacity){
            
            
            removeCache(endNode);
        }

        if(nodeMapper[key]!=null){
            removeCache(nodeMapper[key]);
        }

        currentCacheSize++;

        nodeMapper[key] = node;

        node.pre = null;
        node.next = startNode;

        if(startNode!=null){
            startNode.pre = node;
        }   

        startNode = node;
        startNode.pre = null;

        if(endNode == null){
            endNode = startNode;
        }     

        
    
    }



    static class Node {
        int data = -1;
        int key = 0;
        Node next;
        Node pre;

        // Constructor
        public Node(int key,int data) {
            this.data = data;
            this.key = key;
            this.next = null;
            this.pre = null;
        }
    }


}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */