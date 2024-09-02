class Solution {

    List<List<Integer>>[] path;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        
        path = new ArrayList[graph.length];

       

        return  getPath(graph,0);
    }

    private List<List<Integer>> getPath(int[][] graph,int pos){

        if(pos == graph.length-1){

            if(path[pos]==null){

                path[pos] = new ArrayList();    

                List<Integer> a = new ArrayList();

                a.add(pos);

                List<List<Integer>> vv = new ArrayList();

                vv.add(a);

                path[pos] = vv;
            }

            
            return path[pos];

        }

        if( path[pos]!=null){
            return path[pos];
        }

        if(path[pos]==null){
            path[pos] = new ArrayList();
        }

        List<List<Integer>> ans = new ArrayList();

        
        for(int i=0;i<graph[pos].length;i++){

            List<List<Integer>> pathValues = getPath(graph,graph[pos][i]);

            for(int j=0;j<pathValues.size();j++){

                List<Integer> val = new ArrayList();

                val.add(pos);

                val.addAll(pathValues.get(j));

                ans.add(val);
            }
            

        }

        if(ans!=null && ans.size()>0){  
            path[pos].addAll(ans);
        }

        return path[pos];

    }
}