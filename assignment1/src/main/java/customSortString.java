import java.util.ArrayList;
import java.util.List;

public class customSortString {
}
class Solution791 {
    public String customSortString(String order, String s) {
        List<Character> list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<order.length();i++){
            for(int j=0;j<list.size();j++){
                if(list.get(j).equals(order.charAt(i))){
                    stringBuilder.append(list.get(j));
                    list.remove(j);
                    j--;
                }
            }
        }

        for(int i=0;i<list.size();i++){
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }
}