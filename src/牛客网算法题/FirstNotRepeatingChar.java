package ţ�����㷨��;

/**
 * ��һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��
 */
public class FirstNotRepeatingChar {
	public int FirstNotRepeatingChar(String str) {
        char[] chars=str.toCharArray();
        //����һ����ĸ��������д��ĸ��Сд��ĸ����52��
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
