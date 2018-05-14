package tTiao;

/**
 * СQ���������һ��С�̰�����ߡ��� \��Ϸ��ƽ�����и����־���ÿ����Ԫ����һ��������
 * �����и����ʼ��ʱ��СQ����һ�� ����Ϊ0�����ߴӾ����������ѡһ����Ԫ�� �����ͼ��
 * ��ÿ��ֻ�ܹ����ﵱǰλ�õ��������ڣ��Ҳ����ں��������ڵĵ�Ԫ�����ߵ���һ����Ԫ���
 * ����ĳ��Ȼ�˲����ϸõ�Ԫ�����ֵ���κ�����³���Ϊ������Ϸ������СQ�Ǹ���ţ���ӵ��һ����������
 * ��������Ϸ��ʼ��ʱ��ѵ�ͼ�е�ĳһ���ڵ��ֵ��Ϊ���෴��(ע:���ֻ�ܸı�һ���ڵ�)������СQ��Ϸ�����У�
 * ������������ȿ��Ե�����?
 * ��������:
 * ��һ����������n,m,��ʾ��ͼ��n��m��
 * �������У�ÿ��m������T(i,j)��ʾ��ͼ��ÿ����Ԫ��ֵ
 * �������:
 * һ����������ʾ�ߵ������
 * ʾ��
 * 4 3
 * 1 -4 10
 * 3 -2 -1
 * 2 -1 0
 * 0 5 -2
 * <p>
 * �����
 * 17
 * ˵��������һ�еĵڶ���-4�ĳ�4��Ȼ��ӵڶ��еĵ�һ�н����ͼ��·����3->4(ԭ-4)->10;
 */
public class Five {
    public static void main(String[] args) {
        int[][] map = {{1, -4, 10}, {3, -2, -1}, {2, -1, 0}, {0, 5, -2}};
        Five five = new Five();
        FindPath find = five.new FindPath(map);

        System.out.println(find.path());
    }

    /**
     * ���������ٳ���ȥʵ�֣�ȡĳ������ȥ�෴���������
     * ����˼·�ǣ�����ʹ�ö�̬�滮�㷨��
     * �������ڣ�ÿ�μ��ϵ�ǰ��map[i][j]ʱ�����ж����map[i][j]�ǲ�������������ǣ��򷽷�ͬ�ϣ�
     * ������ǣ���map[i][j]�ľ���ֵ�ǲ��Ǳ�֮ǰȡ�����Ǹ���ֵ��
     * ����ǣ�����з�ת��֮ǰ���Ǹ���ֵȡ���������ڵ������ֵȡ����
     */
    public int path2(){

    }


    /**
     * ����������ʵ��һ��������ֵȡ�෴�����ܵĽ��
     */
    public class FindPath {
        int[][] map = null;
        Integer[][] result = null;

        //����Ϊ�˱�����������ظ���⣬ͬʱ�ֱ�֤�ܹ��Զ����£��ܿ���Щ����Ҫ�������⣬����һ�����仯������
        public FindPath(int[][] map) {
            this.map = map;
            //result��mapȡ��ͬ��С,��ʼ����result��ÿһ��Ԫ�ض���null��
            result = new Integer[map.length][map[0].length];
        }

        public int path() {
            //ȡ�����һ�е����ֵ
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

        //����ʹ�ö�̬�滮,i��ʾ�кţ����ϵ��£��������󣩣�j��ʾ�кţ������ң���������
        // path(i,j)=map[i][j]+max(path(i-1,j-1),path(i,j-1),path(i+1,j-1))
        public int path(int i, int j) {
            if (i < 0 || i > map.length - 1) {
                //˵�����ֵ�Ѿ��ڵ�ͼ֮���ˣ����������⴦�������ֵ�ڱȽϴ�С��ʱ���Զ�����̭
                return Integer.MIN_VALUE;
            }
            if (j == 0) {
                return map[i][j];
            }

            if (result[i][j] != null) {
                //˵��֮ǰ�Ѿ����
                return result[i][j];
            }
            //���֮ǰû��������Ǿͼ��㲢�Ҽ�¼��������
            result[i][j] = map[i][j] + max(path(i - 1, j - 1), path(i, j - 1), path(i + 1, j - 1));
            return result[i][j];
        }

        /**
         * ������ֵ��ȡ���ֵ
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
