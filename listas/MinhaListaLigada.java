package listas;
public class MinhaListaLigada {
    No primeiro = null, ultimo = null;

    public void adicionar(Integer i){
        var no = new No(i);
        if (primeiro == null){
            primeiro = no;
            ultimo = no;
        }
        else{
            ultimo.proximo = no;
            no.anterior = ultimo;
            ultimo = no;
        }
    }
}

class No{
    Integer item;
    No anterior = null;
    No proximo = null;
    No (Integer item){
        this.item = item;
    }
}
