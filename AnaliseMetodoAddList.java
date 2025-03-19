import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class AnaliseMetodoAddList {
    public static void main(String[] args) {
        List <Integer> linkedList = new LinkedList<>();
        List <Integer> arrayList = new ArrayList<>();
        int n = Integer.parseInt(args[0]);
        //linkedList: O(n)
        //arrayList: O(n^2)


        //arrayList.add(5); O(1)
        //arrayList.add(5); O(1)
        //arrayList.add(5); O(1)
        //arrayList.add(5); O(1)
        //arrayList.add(5); O(n)
        //arrayList.add(5); O(1)
        //arrayList.add(5); O(1)
        //arrayList.add(5); O(1)
        //arrayList.add(5); O(n)





        for (int i = 0; i < n ; i++){
            //linkedList.add(5); O(1)
            arrayList.add(5);//O(n)
        }        
    }
}
