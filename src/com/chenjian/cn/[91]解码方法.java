package com.chenjian.cn;//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为： 
//
// 
// "AAJF" ，将消息分组为 (1 1 10 6) 
// "KJF" ，将消息分组为 (11 10 6) 
// 
//
// 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。 
//
// 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。 
//
// 题目数据保证答案肯定是一个 32 位 的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "0"
//输出：0
//解释：没有字符映射到以 0 开头的数字。
//含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
//由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
// 
//
// 示例 4： 
//
// 
//输入：s = "06"
//输出：0
//解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
// Related Topics 字符串 动态规划 
// 👍 797 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution91 {

    public static int numDecodings(String s) {
        if (s == null || s.equals(""))
            return 0;

        return DFS(s);
    }

    public static int DFS(String s){

        if (s.equals("")){
            return 1;
        }
        if (s.charAt(0) == '0')
            return 0;

        boolean n1 = s.length() >= 1 && Integer.valueOf(s.substring(0,1)) >=1 && Integer.valueOf(s.substring(0,1)) <= 26;
        boolean n2 = s.length() >= 2 && Integer.valueOf(s.substring(0,2)) >=1 && Integer.valueOf(s.substring(0,2)) <= 26;
        if (n1 == true && n2 == true){
            return DFS(s.substring(1))+DFS(s.substring(2));
        }else if (n1 == true && n2 == false){
            return DFS(s.substring(1));
        }else if (n1 == false && n2 == true){
            return DFS(s.substring(2));
        }else
            return 0;

    }

    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));

    }

    public static int numDecodings2(String s){
        int n = s.length();
        s = " "+s;
        char[] res = s.toCharArray();
        int[] f = new int[n+1];
        f[0] = 1;
        for (int i=1; i<=n; i++){
            int a = res[i] - '0', b = (res[i-1]-'0')*10+res[i] - '0';
            if (a>=1 && a<=9) f[i] = f[i-1];
            if (b>=10 && b<=26) f[i] += f[i-2];
        }
        return f[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
