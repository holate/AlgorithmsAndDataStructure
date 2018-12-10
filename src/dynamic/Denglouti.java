package dynamic;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 1218: 小明登楼梯
 * 时间限制: 1 Sec  内存限制: 128 MB
 * 提交: 109  解决: 14
 * [提交][状态][讨论版][命题人:liangxingjian]
 * 题目描述
 * 小明上楼有一个习惯，就是一定会先迈出左脚上楼梯，今天小明突发奇想，我能不能最后一步也是迈左脚呢？他数了一下楼梯，一层楼恰好9梯，于是，他左脚1梯、右脚1梯、左1、右1、左1、右1、左1、右1、左1，最后一次恰好迈出的是左脚，但他马上又觉得9梯为奇数是个巧合，于是找了一个仅有4梯的平台，发现只要允许一步跨2梯，仍然可以最后一次迈左脚登上平台，而且方案还不是一种，可以是“左1，右2，左1”，“左2，右1，左1”，“左1，右1，左2”等不同方法，于是小明就很想知道，按自己的习惯和要求（允许一步可以跨1~2梯），登上9梯平台应该有多少种登梯方案？那么若有10梯、20梯的平台又应该有多少种登梯方案呢？
 * <p>
 * 输入
 * 每次输一个数字N：0 ≤ N < 93，代表一个平台有多少梯。最后一次，输入0结束。
 * 输出
 * 若输入数据大于1，请输出对应的登梯方案数量，并以一个换行符结束。
 * 样例输入
 * 3
 * 4
 * 0
 * 样例输出
 * 1
 * 3
 * 提示
 * 递归、递推
 * <p>
 * 来源http://119.23.214.227/problem.php?id=1218
 */
public class Denglouti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b[] = new int[93];
        int max = 0, f;
        for (int i = 0; i < 93; i++) {
            f = sc.nextInt();
            if (f == 0) {
                break;
            }
            max = max > f ? max : f;
            b[i] = f;
        }
        sc.close();
        long a[][] = new long[2][max + 1];
        a[0][1] = 1;
        a[1][1] = 0;
        a[0][2] = 1;
        a[1][2] = 1;
        for (int j = 3; j <= max; j++) {
            a[0][j] = a[1][j - 1] + a[1][j - 2];
            a[1][j] = a[0][j - 1] + a[0][j - 2];
        }
        for (int i : b) {
            if (i == 0) {
                break;
            }
            System.out.println(a[0][i]);
        }
    }
}
