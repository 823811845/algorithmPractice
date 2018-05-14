package tTiao;

/**
 * 小Q最近迷上了一款叫“贪吃蛇蛇”的 \游戏。平面上有个数字矩阵，每个单元都是一个整数，
 * 有正有负，最开始的时候小Q操纵一条 长度为0的蛇蛇从矩阵最左侧任选一个单元格 进入地图，
 * 蛇每次只能够到达当前位置的右上相邻，右侧相邻和右下相邻的单元格。蛇蛇到达一个单元格后，
 * 自身的长度会瞬间加上该单元格的数值，任何情况下长度为负则游戏结束。小Q是个天才，他拥有一个超能力，
 * 可以在游戏开始的时候把地图中的某一个节点的值变为其相反数(注:最多只能改变一个节点)。问在小Q游戏过程中，
 * 他的蛇蛇最长长度可以到多少?
 * 输入描述:
 * 第一行两个整数n,m,表示地图有n行m列
 * 接下来行，每行m个整数T(i,j)表示地图中每个单元的值
 * 输出描述:
 * 一个整数，表示蛇的最长长度
 * 示例
 * 4 3
 * 1 -4 10
 * 3 -2 -1
 * 2 -1 0
 * 0 5 -2
 * <p>
 * 输出：
 * 17
 * 说明，将第一行的第二列-4改成4，然后从第二行的第一列进入地图，路线是3->4(原-4)->10;
 */
public class Five {
    public static void main(String[] args) {
        int[][] map = {{1, -4, 10}, {3, -2, -1}, {2, -1, 0}, {0, 5, -2}};
        Five five = new Five();
        FindPath find = five.new FindPath(map);

        System.out.println(find.path());
    }

    /**
     * 这里我们再尝试去实现，取某个数，去相反数的情况，
     * 基本思路是，继续使用动态规划算法，
     * 区别在于，每次加上当前的map[i][j]时，先判断这个map[i][j]是不是正数，如果是，则方法同上，
     * 如果不是，则看map[i][j]的绝对值是不是比之前取反的那个数值大，
     * 如果是，则进行翻转，之前的那个数值取负数，现在的这个数值取正数
     */
    public int path2(){

    }


    /**
     * 这里我们先实现一个不带数值取相反数功能的解答
     */
    public class FindPath {
        int[][] map = null;
        Integer[][] result = null;

        //这里为了避免对子问题重复求解，同时又保证能够自顶向下，避开那些不必要的子问题，存在一个记忆化的问题
        public FindPath(int[][] map) {
            this.map = map;
            //result和map取相同大小,初始化后，result的每一个元素都是null，
            result = new Integer[map.length][map[0].length];
        }

        public int path() {
            //取出最后一列的最大值
            int temp = Integer.MIN_VALUE;
            for (int i = 0; i < map.length; i++) {
                if (result[i][result[0].length - 1] == null) {
                    path(i, result[0].length - 1);
                }
                if (temp <= result[i][result[0].length - 1]) {
                    temp = result[i][result[0].length - 1];
                }
            }
            return temp;
        }

        //这里使用动态规划,i表示行号（从上到下，依次增大），j表示列号（从左到右，依次增大）
        // path(i,j)=map[i][j]+max(path(i-1,j-1),path(i,j-1),path(i+1,j-1))
        public int path(int i, int j) {
            if (i < 0 || i > map.length - 1) {
                //说明这个值已经在地图之外了，这里做特殊处理，是这个值在比较大小的时候，自动被淘汰
                return Integer.MIN_VALUE;
            }
            if (j == 0) {
                return map[i][j];
            }

            if (result[i][j] != null) {
                //说明之前已经算过
                return result[i][j];
            }
            //如果之前没有算过，那就计算并且记录这个结果，
            result[i][j] = map[i][j] + max(path(i - 1, j - 1), path(i, j - 1), path(i + 1, j - 1));
            return result[i][j];
        }

        /**
         * 三个数值中取最大值
         *
         * @param i
         * @param j
         * @param k
         * @return
         */
        int max(int i, int j, int k) {
            int temp = Math.max(i, j);
            return Math.max(temp, k);
        }
    }
}
