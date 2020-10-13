
public class No {
	private int elemento;
	private No proximo;
	
	public No(int i, No n) {
		elemento = i;
		proximo = n;
	}
	
	public int getElemento() {
		return elemento;
	}
	
	public No getProximo() {
		return proximo;
	}
	
	public void setElemento(int novoElemento) {
		elemento = novoElemento;
	}
	
	public void setProximo(No novoProximo) {
		proximo = novoProximo;
	}
	
}
