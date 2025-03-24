package listas;
public class MeuArrayList {
    int [] elementos;
    int qtde = 0, cap;

    MeuArrayList(int cap){
        this.cap = cap;
    }

    public void adicionar(int elemento){
        if(estaCheio()){
            var aux = new int[cap * 2];
            for(int i = 0; i < cap; i++){
                aux[i] = elementos[i];
            }
            cap *= 2;
            elementos = aux;
        }
        elementos[qtde++] = elemento;
    }

    public boolean estaCheio(){
        return qtde == cap;
    }
}
