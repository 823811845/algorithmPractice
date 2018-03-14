package 牛客网算法题;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class FirstNotRepeatingChar {
	public int FirstNotRepeatingChar(String str) {
        char[] chars=str.toCharArray();
        //建立一个字母表，包括大写字母和小写字母，共52个
        int[] charsRepertory=new int[100];
        int a ='a';
        for(int i=0;i<chars.length;i++){
        	int s=chars[i]-a;
            charsRepertory[chars[i]-a]++;
        }
        for(int i=0;i<chars.length;i++){
        	if(chars[i]=='l'){
        		System.out.println(charsRepertory[chars[i]-a]);
        	}
            if(charsRepertory[chars[i]-a]==1){
                return i;
            }
        }
        return -1;
    }
	
	@org.junit.Test
	public void test() {
		System.out.println(FirstNotRepeatingChar("google"));
//		System.out.println('g'^'o'^'o'^'g');
	
	}
}
