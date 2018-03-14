package 牛客网算法题;
/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class FindhalfFigure {
    public int MoreThanHalfNum_Solution(int [] array) {
       //这里的最优思路是：假设第一个数字时目标数，那么让它比较剩下的每一个数字，比较相同，times加一，times减一，如果times等于零，那就假设当前被比较数的下一个数是目标数
        //那么假设这个数是目标数，那么比较完以后，它的times一定是大于一的。
        //假设这个数不是目标数，那么它要么和杂数想抵消，要么和目标数中的一部分相抵消，这样可以保证，剩余数中目标数仍然是最多的那个。
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
        
        // 判断result是否符合条件，即出现次数大于数组长度的一半
        times = 0;
        for(int i=0;i<array.length;++i)
        {
            if(array[i]== target) ++times;
        }
        return (times>array.length/2)?target:0;
    }
}