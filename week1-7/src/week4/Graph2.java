package week4;

public class Graph2 {
    int vertices;
    int adjacency_matrix[][];
    Graph2(int v){
        vertices=v;
        adjacency_matrix=new int[vertices][vertices];
    }
    void addEdge(int source,int destination,int weight) {
        adjacency_matrix[source][destination]=weight;
        adjacency_matrix[destination][source]=weight;
    }
    public void shortDistanceDiaxtera(int source, int destination) {
        boolean [] visited=new boolean[vertices];
        int distance[]=new int[vertices];
        int prevpath[]=new int[vertices];
        for(int i=0;i<vertices;i++) {
            distance[i]=Integer.MAX_VALUE;
            prevpath[i]=-1;
        }
        distance[source]=0;
        for(int i=0;i<adjacency_matrix.length;i++) {
            int minvertex=findMinVertex(distance,visited);
            visited[minvertex]=true;
            for(int j=0;j<adjacency_matrix.length;j++) {
                if(adjacency_matrix[minvertex][j]!=0 & !visited[j] && distance[minvertex]!=Integer.MAX_VALUE ) {
                    int newdistance=distance[minvertex]+adjacency_matrix[minvertex][j];
                    if(newdistance<distance[j]) {
                        distance[j]=newdistance;
                        prevpath[j]=minvertex;
                    }
                }
            }
        }
            System.out.println("shortest distance is= "+distance[destination]);
            int crawl=destination;
            LinkedList path=new LinkedList();
            path.addNode(crawl);
            while(prevpath[crawl]!=-1) {
                path.addNode(prevpath[crawl]);
                crawl=prevpath[crawl];
            }
            System.out.println("shortest path is ");
            for(int j=path.Size()-1;j>=0;j--) {
                System.out.println(path.get(j));
            }
    }
    public int findMinVertex(int distance[], boolean visited []) {
        int minvertexs=-1;
        for(int i=0;i<vertices;i++) {
            if(!visited[i] & (minvertexs==-1 || distance[i]<distance[minvertexs])) {
                minvertexs=i;
            }
        }
        return minvertexs;
    }
    public void printGraph() {
        System.out.println("Graph is");
        for(int i=0;i<vertices;i++) {
          for(int j=0;j<vertices;j++) {
              System.out.print(adjacency_matrix[i][j]+" ");
          }
          System.out.println("");
        }
    }
    public void printEdges() {
        for(int i=0;i<vertices;i++) {
            System.out.print("vertex "+i+ " is connected to ");
           for(int j=0;j<vertices;j++) {
               if(adjacency_matrix[i][j]!=0) {
                   System.out.print(j+" ");
               }
           }
           System.out.println("");
        }
    }
    public int solution(String resturents) {
        int n=resturents.length();
        char[] resturent=resturents.toCharArray();
        int[][] map=new int[n][26]; 
         int indegree[] = new int[vertices]; 
         int topo[] = new int[vertices]; 
            for(int i = 0;i<vertices;i++) {
               for(int j=0;j<vertices;j++) {
                   if(adjacency_matrix[i][j]!=0) {
                       indegree[j]++;
                   }  
               }
            }
            Queues queue=new Queues();
            for(int i = 0;i<vertices;i++) {
                if(indegree[i] == 0) {
                    map[i][resturent[i]-'a']=1;
                    queue.enqueue(i); 
                }
            }
            int cnt=0;
            int res=0;
            while(queue.size()>0) {
                int node = queue.dequeue();
                topo[cnt]=node;
                cnt++; 
                int max=getMax(map[node]);
                res=Math.max(res,max);
                for(int j=0;j<vertices;j++) {
                     if(adjacency_matrix[node][j]!=0) {
                    for(int i=0;i<26;i++){
                map[j][i]=Math.max(map[j][i],map[node][i] + (resturent[j]-'a'==i?1:0));
                      }
                    indegree[j]--; 
                    if(indegree[j] == 0) {
                        queue.enqueue(j); 
                         }
                     }
                }
            }
            return cnt==n?res:-1;
        }
        private int getMax(int[] num){
            int max=num[0];
            for(int n:num){
                max=Math.max(n,max);
            }
            return max;
        }
    public static void main(String [] args) {
        Graph2 graph = new Graph2(5);
        graph.addEdge(0, 1,6);
        graph.addEdge(0, 2,1);
        graph.addEdge(1, 2,2);
        graph.addEdge(1, 3,2);
        graph.addEdge(2, 3,1);
        graph.addEdge(1, 4,5);
        graph.addEdge(3, 4,5);
        graph.printGraph();
        graph.printEdges();
        graph.shortDistanceDiaxtera(0, 4);
    }
}