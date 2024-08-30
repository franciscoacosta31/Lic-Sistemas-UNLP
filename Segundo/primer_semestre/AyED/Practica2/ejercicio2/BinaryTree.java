package ejercicio2;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public int contarHojas() {
	   int leftT = 0;
	   int rightT = 0;
	   if (this.isLeaf()) return 1;
	   else
		   	if(this.hasLeftChild())
		   		leftT = this.getLeftChild().contarHojas();
	   
	   		if(this.hasRightChild())
	   			rightT = this.getRightChild().contarHojas();
	   		
	   		return leftT + rightT;
	}
    	 
    public BinaryTree<T> espejo(){
    	BinaryTree<T> ab = new BinaryTree<T>(this.getData());
    	if (this.hasLeftChild()) {
    		ab.addRightChild(this.getLeftChild().espejo());
    	}
    	if (this.hasRightChild()) {
    		ab.addLeftChild(this.getRightChild().espejo());
    	}
 	   	return ab;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m) {
		BinaryTree<T> ab = null;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		int level = 0;
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			ab = cola.dequeue();
			if (ab != null) {
				if(level >= n && level <=m) {
					System.out.print("-"+ab.getData());
				}
				if (ab.hasLeftChild()) {
					cola.enqueue(ab.getLeftChild());
				}
				if (ab.hasRightChild()) {
					cola.enqueue(ab.getRightChild());
				}
			} 
			else if (!cola.isEmpty()) {
				level++;
				if(level > m) {
					break;
				}
				System.out.println();
				cola.enqueue(null);
			}
		}
   }
}