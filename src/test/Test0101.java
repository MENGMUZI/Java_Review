package test;

import java.util.*;

/**
 * @author : mengmuzi
 * create at:  2019-08-16  18:30
 * @description:
 */
public class Test0101 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length() ; i++) {
            if(str.codePointAt(i)>= '0' && str.codePointAt(i) <='9'){
                list.add(str.charAt(i)-'0');
            }
        }
        Collections.sort(list);
        if(list.size() == 0){
            System.out.println("-1");
            return;
        }
        for (Integer element : list) {
            System.out.print(element);
        }
    }

}
