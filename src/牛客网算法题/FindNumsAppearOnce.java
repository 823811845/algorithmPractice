package ţ�����㷨��;

/**
 * һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 */
//num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
//��num1[0],num2[0]����Ϊ���ؽ��
public class FindNumsAppearOnce {
  public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
      if(array.length<=1){
          return ;
      }
      //result1��ʾ���result2��ʾͬ��
      int result=0,flag=1;
      for(int i=0;i<array.length;i++){
          result^=array[i];
      }
      //���������е������Ժ�result�ض�������Ŀ�����ֵ����
      while((flag & result)==0){ flag<<=1;}
      
      for(int i=0;i<array.length;i++){
          if((flag & array[i])==0) num1[0]^=array[i];
          else num2[0]^=array[i];
      }
  }
}