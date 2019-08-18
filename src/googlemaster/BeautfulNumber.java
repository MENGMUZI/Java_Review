package googlemaster;

/**
 * @author : mengmuzi
 * create at:  2019-08-18  01:12
 * @description:
 */
public class BeautfulNumber {

    public static void main(String[] args) {
        int result = beautiful(101);
        System.out.println(result);
    }

    private static int beautiful(int n) {
        for (int radix = 2; radix < n; radix++) {//进制
            if (isBeautful(n, radix)) {
                return radix;
            }
        }
        return n - 1;
    }

    private static boolean isBeautful(int n, int radix) {
        while (n > 0) {
            if(n % radix != 1){
                return false;
            }
            n = n / radix;

        }
        return true;
    }


}
