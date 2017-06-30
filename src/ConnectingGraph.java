
public class ConnectingGraph {
    private int[] group = null;

    private int find(int x) {//2
        
        return group[x];
    }

    public ConnectingGraph(int n) {
        // initialize your data structure here.
        group = new int[n + 1];
        for (int i = 1; i <= n; i++){
            group[i] = i;
        }
    }

    public void connect(int a, int b) {
        // Write your code here
        if (find(a) == find(b)){
            return;
        } else {
            int ida = find(a);
            int idb = find(b);
            for (int i = 1; i < group.length; i++){
                if (find(i) == ida){
                    group[i] = idb;
                }
            }
        }
        return;
    }
        
    public boolean  query(int a, int b) {
        // Write your code here
        return find(a) == find(b);
        
    }
}

//这是一个 Union find的题，Union find用于判断点与点之间是否联通，当然可以用DFS，但Union find更简洁，但不能
//返回路径
//Union Find 举例，1-n 个元素，开始各自为一组，随着连接，把他们的组数进行归并，一般用数组进行操作，index表示
//第几个元素，对应的值表示该元素属于的组别