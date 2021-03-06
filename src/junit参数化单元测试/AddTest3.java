package junit参数化单元测试;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import junit.framework.Assert;

@RunWith(Parameterized.class)  
public class AddTest3 {  
  
    private int input1;  
    private int input2;  
    private int expected;  
      
    /** 
     * 准备数据。数据的准备需要在一个方法中进行，该方法需要满足一定的要求： 
         1）该方法必须由Parameters注解修饰 
         2）该方法必须为public static的 
         3）该方法必须返回Collection类型 
         4）该方法的名字不做要求 
         5）该方法没有参数 
     * @return 
     */  
    @Parameters  
    public static Collection prepareData(){  
        Object [][] object = {{-1,-2,-3},{0,2,2},{-1,1,0},{1,2,3}};  
        return Arrays.asList(object);  
    }  
      
    public AddTest3(int input1,int input2,int expected){  
        this.input1 = input1;  
        this.input2 = input2;  
        this.expected = expected;  
    }  
    @Test  
    public void testAdd(){  
        Add add = new Add();  
        int result = add.add(input1, input2);  
        Assert.assertEquals(expected,result);  
    }  
      
}