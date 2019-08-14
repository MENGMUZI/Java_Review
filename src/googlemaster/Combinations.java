package googlemaster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : mengmuzi
 * create at:  2019-08-14  17:42
 * @description: 列出所有组合
 */
public class Combinations {

    public void combinations(List<Integer> selected, List<Integer> data, int n) {

        if (n == 0) {
            //output all selected elements
            for (Integer integer : selected) {
                System.out.print(integer+"\t");
            }
            System.out.println();
            return;
        }
        if (data.isEmpty()) {
            return;
        }
        //select element 0
        selected.add(data.get(0));
        combinations(selected, data.subList(1, data.size()), n - 1);

        //un-select element 0
        selected.remove(selected.size() - 1);
        combinations(selected, data.subList(1, data.size()), n);
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        combinations.combinations(new ArrayList<>(), Arrays.asList(1, 2, 3, 4), 2);
        System.out.println("========================================");
        combinations.combinations(new ArrayList<>(), Arrays.asList(1, 2, 3, 4), 0);
        System.out.println("========================================");
        combinations.combinations(new ArrayList<>(), Arrays.asList(), 0);
        System.out.println("========================================");
        combinations.combinations(new ArrayList<>(), Arrays.asList(), 1);
    }

}
