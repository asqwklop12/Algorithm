import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<List<Character>> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String str = sc.next();
            list.add(new ArrayList<>());
            for (int j = 0; j < str.length(); j++) {
                list.get(i).add(str.charAt(j));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 15; j++) { // 최대 길이 15만큼 세로로 순회
            for (int i = 0; i < 5; i++) { // 5줄 확인
                if (j < list.get(i).size()) { // 해당 줄에 글자가 존재하면
                    sb.append(list.get(i).get(j));
                }
            }
        }
        System.out.println(sb.toString());

    }
}
