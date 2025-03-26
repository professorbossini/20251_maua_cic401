package greedy;
import java.util.*;
public class MochilaFracionaria {
    public static void main(String[] args) {
        var leitor = new Scanner(System.in);
        int n = leitor.nextInt();
        int W = leitor.nextInt();
        List <Item> itens = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            itens.add(new Item (
                leitor.nextInt(),
                leitor.nextInt()
            ));
        }
        Collections.sort(itens);
        for (Item item : itens){
            
        } 
        System.out.println(itens);
        leitor.close();
    }    
}
