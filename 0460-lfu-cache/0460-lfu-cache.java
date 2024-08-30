class LFUCache {

    
    Node cStart;

    HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
    HashMap<Integer, Node> endNodes = new HashMap<Integer, Node>();
    HashMap<Integer, Node> counterNode = new HashMap<Integer, Node>();


    Node[] counts = new Node[100001]; 

    int capacity = 0;
    int cacheSize = 0;
    

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {

        Node count = counts[key];

       // System.out.println("Get For: " + key +" " + counts[1]);


        if(count!=null){
            
            updateNodes(count);
            
          //  System.out.println("Get:: " + count.key +" " + count.value +" " + count.count);

            return count.value;

        }

        return -1;
        
    }
    
    public void put(int key, int value) {
        
        Node count = counts[key];

        if(count == null){
            count = new Node(key,value);
        }

        count.value = value;
       
        updateNodes(count);

    }


    private void addToSingleCount(){


         Node counter = counterNode.get(1);

         if(counter !=null){

            counter.count++;

         }else{

            counter = new Node(1,1);
            counter.count = 1;

            if(cStart!=null && cStart.key > 1 ){
                cStart.pre = counter;
                counter.next = cStart;
            }

           
       
         }
        
        counterNode.put(1,counter);

        cacheSize++;
        cStart = counter;

    }


    private void removeCountSpecificNodeAndAddNext(int count){

        Node counter = counterNode.get(count);

        //System.out.println("NodeAndAddNext " + count);
        
        if(counter!=null){

           // System.out.println("Next " + counter.key +" " + counter.count);

            Node nextNode = counterNode.get(count+1);

            counter.count--;

            if(nextNode == null){

                nextNode = new Node(count+1,1);

                nextNode.count = 1;

                if(counter.next!=null){
                    counter.next.pre =  nextNode;
                }

                nextNode.next = counter.next;

                nextNode.pre = counter;

                counter.next = nextNode;

                counterNode.put(count+1,nextNode);

            }else{
                nextNode.count++;
                counterNode.put(count+1,nextNode);
            }
            

            if(counter.count == 0){

                counterNode.put(count,null);
                
                if(counter.pre == null){
                    cStart = nextNode;
                    nextNode.pre = counter.pre;
                }else{
                    counter.pre.next = nextNode;
                    nextNode.pre = counter.pre;
                }

            }

            //counterNode.put(count,cStart);

            

        }else{
            System.out.println("Null counter " + count);
        }

    }

    private void removeLeastFrequenctNode(){

        Node counterStart = cStart;

        if(cStart!=null){

            int count = cStart.key;

            Node startNode = nodes.get(count);
            Node endNode = endNodes.get(count);

            counts[startNode.key] = null;

            nodes.put(count,startNode.next);

            if(startNode.next!=null){
                startNode.next.pre = null;
            }
           
            if(startNode.next == null){
                endNodes.put(count,null);
            }

            cStart.count--;

            if(cStart.count == 0){

                counterNode.put(cStart.key,null);

                if(cStart.next!=null){
                    cStart.next.pre = null;
                }

                cStart = cStart.next;

            }

            cacheSize--;

        }else{
            System.out.println("cStart counter " + cStart.key);
        }

    }


    private void removeFromCountMap(int count,Node node){

       // Node mapNode = nodes.get(count);

        if(node.next!=null){
            node.next.pre = node.pre;
        }

        if(node.pre!=null){
            node.pre.next = node.next;
        }

        if(node.pre == null){
            nodes.put(count,node.next);
        }

        if(node.next == null){
            endNodes.put(count,node.pre);
        }

    }

    private void addNodeCount(int count,Node node){

        Node mapNode = endNodes.get(count);

        Node start =  nodes.get(count);

        if(start == null){
            node.pre = null;
            nodes.put(count,node);
        }else{
            mapNode.next = node;
        }

        node.pre = mapNode;
        node.next = null;

        endNodes.put(count,node);

    }




    private void updateNodes(Node node){

       // System.out.println("Update node " + node.key +"  " + node.value + " " + node.count);

        if(counts[node.key] == null && cacheSize+1> capacity){
            //System.out.println("remove extra node");
            removeLeastFrequenctNode();
        }

        if(counts[node.key] == null){

           // System.out.println("Single " + node.key);
            addToSingleCount();

        }else{

          //  System.out.println("Update " + " " + node.key + " " + counts[node.key].count);

            removeCountSpecificNodeAndAddNext(counts[node.key].count);

        }

        removeFromCountMap(node.count,node);

        node.count++;

        addNodeCount(node.count,node);

        counts[node.key] = node;

        //System.out.println("Key " + counts[node.key].key +" " + counts[node.key].value +" " + counts[node.key].count);

        

    }




    static class Node{
        int key;
        int value;
        int count = 0;
        Node pre;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
            this.count = 0;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */