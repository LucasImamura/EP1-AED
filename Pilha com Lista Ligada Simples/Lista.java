import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Lista {
	protected No cabeca, cauda;
	protected long tamanho;
	
	public Lista() {
		cabeca = cauda = null;
		tamanho = 0;
	}
	
	public boolean estaVazia() {
		return (tamanho == 0);
	}
	
	public void add(No n) {
		n.setProximo(cabeca);
		cabeca = n;
		if(estaVazia()) {
			cauda = n;
		}
		tamanho++;		
	}
	
	public No remove() throws IllegalStateException {
		if(estaVazia()) { 
			throw new IllegalStateException("Lista Vazia");	
		}
		No tmp = cabeca;
		cabeca = cabeca.getProximo();
		tmp.setProximo(null);
		tamanho--;
		if(estaVazia()) {
			cauda = null;
		}
		
		return tmp;
	}
	
	public No getCabeca() {
		return cabeca;
	}
	
	public static void main(String[] args) throws Exception{
		long inicio = System.currentTimeMillis();
		Lista lista = new Lista();
		String caminho = "C:\\Users\\Usuario\\Desktop\\epAed\\tarefas1000.txt"; // inserir aqui o caminho da entrada
		File entrada = new File(caminho);
		Scanner scan = new Scanner(entrada);
		String saida = "";
		while(scan.hasNextLine()) {
			String tarefa = scan.nextLine();
			if(tarefa.equals("")) {
				saida += lista.remove().getElemento() + "\n";
			}
			else {
				int cast = Integer.parseInt(tarefa);
				No n = new No(cast, null);
				lista.add(n);
			}
		}
		Files.write(Paths.get("C:\\Users\\Usuario\\Desktop\\saida2\\tarefas1000.txt"), saida.getBytes()); // inserir aqui o caminho da saída
		scan.close();
		long fim = System.currentTimeMillis();
		System.out.println(fim - inicio);
	}
}
