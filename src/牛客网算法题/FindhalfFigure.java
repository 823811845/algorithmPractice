package ţ�����㷨��;
/**
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡���������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 */
public class FindhalfFigure {
    public int MoreThanHalfNum_Solution(int [] array) {
       //���������˼·�ǣ������һ������ʱĿ��������ô�����Ƚ�ʣ�µ�ÿһ�����֣��Ƚ���ͬ��times��һ��times��һ�����times�����㣬�Ǿͼ��赱ǰ���Ƚ�������һ������Ŀ����
        //��ô�����������Ŀ��������ô�Ƚ����Ժ�����timesһ���Ǵ���һ�ġ�
        //�������������Ŀ��������ô��Ҫô�������������Ҫô��Ŀ�����е�һ������������������Ա�֤��ʣ������Ŀ������Ȼ�������Ǹ���
    	int target=array[0];
        int times=1;
        for(int i=0;i<array.length-1;i++){
            if(times==0){
              	target=array[i];
            	times=1;
            }
            if(target==array[i+1]){
                times++;
            }else{
                times--;
            }
        }
        
        // �ж�result�Ƿ���������������ִ����������鳤�ȵ�һ��
        times = 0;
        for(int i=0;i<array.length;++i)
        {
            if(array[i]== target) ++times;
        }
        return (times>array.length/2)?target:0;
    }
}