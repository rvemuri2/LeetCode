class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        temp.add(0);
        dfs(0, res, temp, graph);
        return res;
    }

    public void dfs(int u, List<List<Integer>> res, List<Integer> temp, int[][] graph) {
        if(u==graph.length-1) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int v:graph[u])
        {
            temp.add(v);
            dfs(v, res, temp, graph);
            temp.remove(temp.size()-1);
        }
    }
}