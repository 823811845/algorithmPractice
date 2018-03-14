package 牛客网算法题;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、
 * 13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数
 *
 */
public class NumberOf1Between1AndN_Solution {
	public int NumberOf1Between1AndN_Solution(int n) {
		// 这里我最开始想到用多维坐标系来处理这个问题，但是是行不通的
		// 这种方法是行不通的，因为多维坐标下，要求的是每个维度相互独立，
		// 但是本题中，例如551，当百位是5的时候，十位只能去0到5·····他们并不相互独立。
		//0到155，和0到551这两个情况是不一样的
		// 先看n的位数
		
		String str = new String(n + "");
		char[] chars = str.toCharArray();

		// 我们考虑另一个方法：例如0到561，我们先计算0到5的，然后整体乘以10的（即0到50），再算加上6以后的（即0到56），然后在整体乘以10的（即0到560），再算加上1以后的（即0到561）.
        //其中0到50之间一共有15个1（本算法中用count变量表示），
        //
		//我们先举例计算：0到500中1的数量=50*1+15*10-9*（50中1的个数）
        //解释一下上面的算式，
        //50*1表示0到500中的个位是1，而十位百位任意取数的情况下 个位一共会产生多少个1，例如261、301这样的数字
        //15*10表示0到500中个位任意取数字，而十位百位中有1的情况下。十位百位一共会产生多少个1，例如314、115这样的书
		//但是在算15*10的时候，需要注意，当十位和百位分别取最大值的时候（也就是5和0的时候），我们的个位只能取0（原本个位有十种选项“0~9”，现在只能取0，所以要减去另外的九种情况，即- 9 * index）
        //算完
        int count = 0;
		// 设计一个技术器用来记录前面的数字中有多少个是1，
		int index = 0;
		char a = '0';

		if (n == 0) {
			count = 0;
			return count;
		}
		for (int i = 0; i < chars.length; i++) {
			a = chars[i];
			// 把count乘以a之前的数值（这里的数值不包括a）再加上count乘以10-9*index。
			// 这里先假设最后一位是0，然后如果最后一位大于等于1，那就加上相应的数
			count = (int) (n / Math.pow(10, chars.length - i) + count * 10 - 9 * index);
			if (a >= '1') {
				// 直接在加上a对应的int数*index，再加上一个位的1
				count += Integer.parseInt(a + "") * index + 1;
			}
			if (i == 0) {
				// 按道理说这第一个数字一定是大于等于1的，所以这里可以不用判断
				count = 1;
			}

			if (a == '1' && i < chars.length - 1) {
                //计算当前面几位都取最大值的时候，一共有多少个1（因为这个时候，最末位只能取0，所以这个数字要保留下来，做计算备用）
				index++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		NumberOf1Between1AndN_Solution obj = new NumberOf1Between1AndN_Solution();
		System.out.println(obj.NumberOf1Between1AndN_Solution(50));
		
		char  a='1';
		char b='2';
		char c=(char) (a^b);
		
	}
}
