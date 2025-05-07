package menores_caminhos_de_origem_unica;
import java.util.*;
class Grafo{

  private final Vertice[] vertices;
  private List<List<Aresta>> adjacencias;

  Grafo(String [] nomesVertices){
    //construir a lista de adjacências (use um ArrayList)
    this.adjacencias = new ArrayList<>();
    //construir o vetor de vertices (temos um vertice para cada nome que chega no parametro do construtor)
    this.vertices = new Vertice[nomesVertices.length];
    //para cada vertice, construir a sua lista de adjacências(use ArrayList para cada um)
    for(int i = 0; i < nomesVertices.length; i++){
      this.adjacencias.add(new ArrayList<>());
      //construir cada vértice, ou seja, preencher o vetor chamado vértices
      this.vertices[i] = new Vertice(nomesVertices[i], i);
    }

  }

  public void adicionarAresta (int origem, int destino, int peso){
    adjacencias.get(origem).add(new Aresta(destino, peso));
  }

  public List<Aresta> vizinhos(int u){
    return adjacencias.get(u);
  }

  public Vertice [] getVertices(){
    return vertices;
  }

  public int quantidadeVertices(){
    return vertices.length;
  }

  static class Vertice{
    //nome, indice, distancia estimada, predecessor
    String nome;
    int indice;
    int distancia;
    Vertice predecessor;
    
    Vertice(String nome, int indice){
      this.nome = nome;
      this.indice = indice;
      distancia = Integer.MAX_VALUE;
      predecessor = null;
    }
  }

  static class Aresta{
    int destino;
    int peso;

    Aresta(int destino, int peso){
      this.destino = destino;
      this.peso = peso;
    }
  }

}

public class BellmanFord {

  public boolean executar(Grafo g, int s){
    inicializarFonteUnica(g, s);
    for(int i = 0; i < g.quantidadeVertices() - 1; i++){
      for(var u : g.getVertices()){
        for (var a : g.vizinhos(u.indice)){
          var v = g.getVertices()[a.destino];
          relaxar(u, v, a.peso);  
        }
      }
    }
    for(var u : g.getVertices()){
      for (var a : g.vizinhos(u.indice)){
        var v = g.getVertices()[a.destino];
        if(v.distancia > u.distancia + a.peso)
          return false;
      }
    }
    return true; 
  }

  private void relaxar(Grafo.Vertice u, Grafo.Vertice v, int w){
    if(u.distancia + w < v.distancia){
      v.distancia = u.distancia + w;
      v.predecessor = u;
    }
  }

  private void inicializarFonteUnica (Grafo g, int s){
    for(Grafo.Vertice v : g.getVertices()){
      v.distancia = Integer.MAX_VALUE;
      v.predecessor = null;  
    }
    g.getVertices()[s].distancia = 0;
  }
  
  public static void main (String [] args){
    System.out.println("oi");
    String [] nomes = {"s", "t", "x", "y", "z"};
    Grafo g = new Grafo(nomes);
    g.adicionarAresta(0, 1, 10);
    g.adicionarAresta(0, 3, 5);
    g.adicionarAresta(1, 2, 1);
    g.adicionarAresta(1, 3, 2);
    g.adicionarAresta(2, 4, 4);
    g.adicionarAresta(3, 1, 3);
    g.adicionarAresta(3, 2, 9);
    g.adicionarAresta(3, 4, 2);
    g.adicionarAresta(4, 2, 6);
    var dijkstra = new Dijkstra();
    dijkstra.executar(g, 0);
    for (Grafo.Vertice v : g.getVertices()){
      System.out.printf("Distância de s a %s: %d\n", v.nome, v.distancia);
      System.out.printf(
        "%s\n", v.predecessor != null ? "Predecessor de " + v.nome + ": " + v.predecessor.nome : "Não tem predecessor"
      );
    }
  }
}

