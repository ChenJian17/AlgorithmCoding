package com.chenjian.cn.bfs;//给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
//
// 
// 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 
//-> ... 这样的车站路线行驶。 
// 
//
// 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。 
//
// 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
//输出：2
//解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。 
// 
//
// 示例 2： 
//
// 
//输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= routes.length <= 500. 
// 1 <= routes[i].length <= 105 
// routes[i] 中的所有值 互不相同 
// sum(routes[i].length) <= 105 
// 0 <= routes[i][j] < 106 
// 0 <= source, target < 106 
// 
// Related Topics 广度优先搜索 数组 哈希表 
// 👍 208 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;

        //有多少条路线即有多少辆公交车
        int n = routes.length;
        //有多少条边相交
        boolean[][] edge = new boolean[n][n];
        //该车站存在于哪些公交车的路线
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<n; i++){
            for (int route: routes[i]){
                List<Integer> list = map.getOrDefault(route,new ArrayList<>());
                for (int j: list){
                    edge[i][j]=edge[j][i]=true;
                }
                list.add(i);
                map.put(route,list);
            }
        }

        //定义该数组表示是否走过
        int[] dis = new int[n];
        Arrays.fill(dis,-1);

        //层序遍历
        Queue<Integer> queue = new LinkedList<>();
        //取出source车站存在于哪些路线
        for (int bus: map.getOrDefault(source,new ArrayList<>())){
            dis[bus] = 1; //表示bus存在于该路线
            queue.offer(bus);
        }

        while (!queue.isEmpty()){
            int x = queue.poll();
            //遍历所有车站
            for (int y=0; y<n; y++){
                //找出与x相交的边，并且x不存在于dis上
                if (edge[x][y] && dis[y] == -1){
                    dis[y] = dis[x]+1;
                    queue.offer(y);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for (int bus: map.getOrDefault(target, new ArrayList<>())){
            if (dis[bus] != -1){
                ret = Math.min(ret, dis[bus]);
            }
        }
        return ret == Integer.MAX_VALUE?-1:ret;





    }
}
//leetcode submit region end(Prohibit modification and deletion)
