package greedy;

public class Tarefa implements Comparable <Tarefa> {
    long inicio, termino;
    public Tarefa(long inicio, long termino){
        this.inicio = inicio;
        this.termino = termino;
    }    

    @Override
    public int compareTo(Tarefa other) {
        //se this for menor do que other, devolver -1
        if(this.termino < other.termino)
            return -1;
        //se forem iguais, devolver zero
        if(this.termino == other.termino)
            return 0;
        //devolver 1, caso contrário
        return 1;
    }

    @Override
    public String toString() {
        return String.format(
            "Início: %d, Término: %d",
            inicio, termino
        );
    }
}
