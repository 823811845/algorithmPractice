package 牛客网算法题;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class FindNumsAppearOnce {
  public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
      if(array.length<=1){
          return ;
      }
      //result1表示亦或，result2表示同或；
      int result=0,flag=1;
      for(int i=0;i<array.length;i++){
          result^=array[i];
      }
      //遍历完所有的数字以后，result必定是两个目标数字的亦或，
      while((flag & result)==0){ flag<<=1;}
      
      for(int i=0;i<array.length;i++){
          if((flag & array[i])==0) num1[0]^=array[i];
          else num2[0]^=array[i];
      }
  }
}