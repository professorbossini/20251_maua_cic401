package arvores_geradoras_minimas;
import java.util.*;

class Aresta implements Comparable<Aresta>{
  int u, v, peso;

  Aresta (int u, int v, int peso){
    this.u = u;
    this.v = v;
    this.peso = peso;
  }
  @Override
  public int compareTo(Aresta o) {
    if(this.peso < o.peso)
      return -1;
    if (this.peso == o.peso)
      return 0;
    return 1;
    //return Integer.compare(this.peso, o.peso);
  }
}
//(1, 2, 10), (2, 3, 11)

class UnionFind{
  int [] representantes;
  public UnionFind(int n){
    representantes = new int[n];
    for (int i = 0; i < n; i++){
      representantes[i] = i;
    }
  }

  public int find(int x){
    while(representantes[x] != x){
      x = representantes[x];
    }
    return x;  
  }

  public void union (int x, int y){
    int rX = find(x);
    int rY = find(y);
    representantes[rY] = rX;
  }
}

public class KruskalSimples {
  public List <Aresta> kruskal(
    int n, List <Aresta> arestas
  ){
    Collections.sort(arestas);
    var uf = new UnionFind(n);
    var arvoreResultante = new ArrayList <Aresta>();
    for (var a : arestas){
      if(uf.find(a.u) != uf.find(a.v)){
        uf.union(a.u, a.v);
        arvoreResultante.add(a);
      }
    }
    return arvoreResultante;
  }
  
  public static void main(String[] args) {
    int n = 4;
    List <Aresta> arestas = Arrays.asList(
      new Aresta(0, 1, 10),
      new Aresta(0, 2, 6),
      new Aresta(0, 3, 5),
      new Aresta(1, 3, 15),
      new Aresta(2, 3, 4)
    );
    var arvoreResultante = new KruskalSimples().kruskal(n, arestas);
    int total = 0;
    for (var a : arvoreResultante){
      System.out.printf(
        "(%d, %d, %d) ",
        a.u, a.v, a.peso
      );
      total += a.peso;
    }
    System.out.println("Peso total : " + total); 
  }
}
