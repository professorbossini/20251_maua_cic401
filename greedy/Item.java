package greedy;

public class Item implements Comparable <Item>{
    int valorUnitario;
    int valorTotal;
    int pesoTotal;

    Item(int valorTotal, int pesoTotal){
        this.valorTotal = valorTotal;
        this.pesoTotal = pesoTotal;
        this.valorUnitario = valorTotal / pesoTotal;
    }

    @Override
    public int compareTo(Item o) {
        return 
            this.valorUnitario > o.valorUnitario ?
            -1 :
            this.valorUnitario == o.valorUnitario ?
            0 :
            1; 
    }
    @Override
    public String toString() {
        return String.format(
            "unit: %d, vT: %d, pT: %d",
            valorUnitario, valorTotal, pesoTotal
        );
    }

}
