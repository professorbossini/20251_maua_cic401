package greedy;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
public class Principal {
    public static void main(String[] args) {
        List <Tarefa> tarefas = Arrays.asList(
            new Tarefa(9, 16),
            new Tarefa(7, 10),
            new Tarefa(1, 8)
        ); //var args
        
        //ordenar
        //esse método sort opera in-place
        Collections.sort(tarefas);
        System.out.println(tarefas);
        //iterar sobre a coleção de tarefas, construindo a coleção resultante...
        List <Tarefa> resultante = new ArrayList<>();
        resultante.add(tarefas.get(0));
        var ultimaAdicionada = tarefas.get(0);
        for (int i = 1; i < tarefas.size(); i++){
            if(tarefas.get(i).inicio > ultimaAdicionada.termino){
                resultante.add(tarefas.get(i));
                ultimaAdicionada = tarefas.get(i);
            }
            else{
                System.out.println(tarefas.get(i) + " descartada...");
            }
        }
        System.out.println(resultante);
    }
}
