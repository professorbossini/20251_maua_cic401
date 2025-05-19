package heap;

public class HeapSort {
  public static int parent (int i){
    return i / 2;  
  }
  public static int left(int i){
    return 2 * i;
  }
  public static int right(int i){
    return 2 * i + 1;
  }

  private static void swap (int [] A, int i, int j){
    var temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
  public static void maxHeapify(int [] A, int i, int n){
    //encontrar os indices dos filhos
    var l = left(i);
    var r = right(i);
    int largest;
    //encontrar, entre pai, filho esquerdpo e filho direito, quem é o maior
    if( l <= n && A[l] > A[i])
      largest = l;
    else
      largest = i;

    if (r <= n && A[r] > A[largest])
      largest = r;
    //se for o caso, trocar pai por filho maior
    //aplicar o procedimento de maneira recursiva
    if(largest != i){
      swap(A, i, largest);
      maxHeapify(A, largest, n);
    }
  }
  
  public static void buildMaxHeap(int [] A, int n){
    //aplicar o heapify de baixo para cima, a partir do primeiro elemento que tem filho
    for(int i = n / 2; i >= 1; i--){
      maxHeapify(A, i, n);
    }
  }

  public static void heapSort(int [] A){
    //ignorar o indice 0
    int n = A.length - 1;
    buildMaxHeap(A, n);
    for(int i = n; i >= 2; i--){
      swap(A, 1 , n);
      n--;
      maxHeapify(A, 1, n);
    }
  }
}
