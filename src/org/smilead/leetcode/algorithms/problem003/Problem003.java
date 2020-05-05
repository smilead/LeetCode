package org.smilead.leetcode.algorithms.problem003;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *      https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Problem003 {

    public int lengthOfLongestSubstring(String s) {
        byte[] source = s.getBytes();
        if(source.length == 0){
            return 0;
        }
        int result = 1;
        int templen = 1;
        int begin = 0;
        for(int var1 = 1; var1 < source.length; var1++){
            int tempr = core(begin, var1 -1, source, source[var1]);
            if(tempr < 0){
                templen ++;
                if(templen> result){
                    result = templen;
                }
            }else {
                templen = var1 - tempr + 1;
                begin = tempr;
            }
        }

        return result;
    }

    /**
     *判断区间内有没有该字符
     */
    public int core(int a, int b, byte[] source, byte ch){
        for(int var1 = a; var1 <= b; var1 ++){
            if(source[var1] == ch){
                return var1 + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String m = "pwwkew";
        System.out.println(new Problem003().lengthOfLongestSubstring(m));
    }
}
