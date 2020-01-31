package cn.niuqun.title;

/**
 *
 * 这道题先设n和m的二元关系为f(n,m)，可以推出式子 f(n,m) = !(f(n-1,m)&&f(n-2,m)........&&f(n-m,m)); 又根据题意我们可以推出n为1时绝对是LOSE,所以其实可以推出一个规律if(n % m+1 == 0)   f(n,m) = 1;   else f(n,m) = 0;
 * @author NiuQun
 * @2019/10/14
 */

public class Stone1 {
}
