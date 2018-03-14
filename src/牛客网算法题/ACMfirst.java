package 牛客网算法题;

/**
 * 由于长期缺乏运动，小黑发现自己的身材臃肿了许多，于是他想健身，更准确地说是减肥。
 * 小黑买来一块圆形的毯子，把它们分成三等分，分别标上A,B,C，称之为“跳舞毯”，他的运动方式是每次都从A开始跳，每次都可以任意跳到其他块，但最后必须跳回A
 * ，且不能原地跳.为达到减肥效果，小黑每天都会坚持跳n次，有天他突然想知道当他跳n次时共几种跳法，结果想了好几天没想出来－_－
 * 现在就请你帮帮他，算出总共有多少跳法。
 * 
 * @author 823811845
 */
public class ACMfirst {
	/**
	 * 这里的思路是 第n-1次他必须不在A区上，也就是 所有的跳法减去 第n-1次跳到A区的所有可能的跳法，
	 * 也就是递归，f(n)=2的n次方-f（n-1）;
	 */

}
