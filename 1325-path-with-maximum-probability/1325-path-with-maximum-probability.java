class Solution {


    double[] visited;

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        visited = new double[n];



        visited[start_node] = 1;

        int top = start_node;

        for (top = 0; top < n; top++) {

            //if (paths[top] != null) 
            {
                
                boolean hasUpdate = false;

                for (int j = 0; j < edges.length; j++) {

                    
                    int start = edges[j][0];
                    int end = edges[j][1];
                    double prob = succProb[j];

                    if(visited[end] < visited[start] * prob ){
                        visited[end] =  visited[start] * prob;
                        hasUpdate = true;
                    }

                   if(visited[start] < visited[end] * prob ){
                        visited[start] = visited[end] * prob;
                        hasUpdate = true;
                    }

                }

                if(!hasUpdate){
                   // break;
                }

                // for (int i = 0; i < paths[top].size(); i++) {

                //     int nextNode = paths[top].get(i);

                //     visited[nextNode] = Math.max(visited[nextNode], visited[top] * probability[top].get(i));

                //     // System.out.printf(top + " " + nextNode +" " + visited[nextNode] + "\n");

                // }

            }

        }

        return visited[end_node];

    }

}