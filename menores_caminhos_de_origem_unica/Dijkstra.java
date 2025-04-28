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

public class Dijkstra {

  public void executar(Grafo g, int s){

  }

  private void relaxar(Grafo.Vertice u, Grafo.Vertice v, int w){
    if(u.distancia + w < v.distancia){
      v.distancia = u.distancia + w;
      v.predecessor = u;
    }
  }

  public static void main (String [] args){

  }
}
