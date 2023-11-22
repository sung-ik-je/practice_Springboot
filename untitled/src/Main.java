import java.util.Arrays;
import java.util.Comparator;

// Shift을(를) 두 번 눌러 전체 검색 대화상자를 열고 'show whitespaces'를 입력한 다음,
// Enter를 누르세요. 그러면 코드 내에서 공백 문자를 확인할 수 있습니다.
public class Main {
    public static void main(String[] args) {

        int[][] arr = {{7, 8}, {9, 7}, {1, 3}, {1, 1}, {4, 7}, {0, 4}, {-2, 4}, {0, 1}};

//        Arrays.sort(arr, new Comparator<int[]>(){
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0] == 0? o1[1] - o2[1] : o1[0] - o2[0];
//            }
//        });
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0]);
        for(int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
//        System.out.println(Integer.parseInt(str));
    }
}