package lab6;
import java.util.ArrayList;

//1 количество строк входного списка, у которых первый символ совпадает с заданным
public class CollectionsDemo {
    public static int filteredBySymbol(ArrayList<String> strings, char symbol){
        if (strings==null){
            throw new IllegalArgumentException("Wrong list");
        }
        int count=0;
        for (String string : strings) {
            if (string!=null && string.charAt(0) == symbol) {
                count++;
            }
        }
        return count;
    }
}
