package ��������_�����������ȫ����_�ҵ���Сֵ;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//�����������У���һ���Ǳ���ӵ�
@RunWith(Parameterized.class)
public class sortTest {
	List<Integer> param;
	String result;

	@Parameters
	public static Collection data() {
		Integer[][] params = { { 321, 32, 3 }, { 11, 45, 56, 12 } };
//		System.out.println(Arrays.asList(params[0]).get(0));
		return Arrays.asList(
				new Object[][] { { Arrays.asList(params[0]), "321323" }, { Arrays.asList(params[1]), "11124556" } });
	}

	// ���캯�����Ա������г�ʼ��
	public sortTest(List<Integer> param, String result) {
		// for (int i = 0; i < param.size(); i++) {
		// System.out.println(param.get(i));
		// }
		// System.out.println(result);
		this.param = param;
		this.result = result;
	}

	@Test
	public void testIt() throws Exception {
		myString m = new myString("s");
		// int[][] params = { { 321, 32, 3 }, { 11, 45, 156, 12 } };
		// String[] result = { "321323", "11124556" };
		assertEquals(result, m.fullPermutation(param));
	}
	
}
