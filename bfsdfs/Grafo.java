package bfsdfs;
import java.util.*;


//java Grafo 5 0 1 1 2 2 3 3 4
public class Grafo {
  private int vertices;
  private List <Integer> [] adjacencias;

  public Grafo(int vertices){
    this.vertices = vertices;
    this.adjacencias = new LinkedList[vertices];
    for (int i = 0; i < vertices; i++){
      adjacencias[i] = new LinkedList<>();
    }
  }

  public void adicionarAresta(int origem, int destino){
    adjacencias[origem].add(destino);
    //adjacencias[destino].add(origem);
  }

  public void bfs(int inicio){
    boolean [] visitados = new boolean[vertices];
    visitados[inicio] = true;
    Queue <Integer> fila = new LinkedList<>();
    fila.add(inicio);
    System.out.println("BFS:");
    while (!fila.isEmpty()){
      int atual = fila.poll();;
      System.out.println(atual + " ");
      for (int vizinho : adjacencias[atual]){
        if(!visitados[vizinho]){
          visitados[vizinho] = true;
          fila.add(vizinho);
        }  
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int vertices = Integer.parseInt(args[0]);
    var grafo = new Grafo(vertices);

    for(int i = 1; i < args.length; i += 2){
      int origem = Integer.parseInt(args[i]);
      int destino = Integer.parseInt(args[i + 1]);
      grafo.adicionarAresta(origem, destino);
    }
    grafo.bfs(4);

  }
}
