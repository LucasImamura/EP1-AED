package ep1;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class PilhaIngenua {
	protected final int MAX = 1000000;
	protected Integer[] pilha;
	
	PilhaIngenua(){ pilha = new Integer[MAX]; }
	
	void add(int newElement) {
		int i;
		for(i = 0; pilha[i] != null; i++);
		pilha[i] = newElement;
	}
	
	int remove() {
		int i;
		for(i = 0; pilha[i] != null; i++);
		int tmp = pilha[i - 1];
		pilha[i - 1] = null;
		return tmp;
	}

	public static void main(String[] args) throws Exception{
		long inicio = System.currentTimeMillis();
		PilhaIngenua pilha = new PilhaIngenua();
		String caminho = "C:\\Users\\Usuario\\Desktop\\epAed\\tarefas1000.txt"; // inserir aqui o caminho da entrada
		File entrada = new File(caminho);
		Scanner scan = new Scanner(entrada);
		String saida = "";
		while(scan.hasNextLine()) {
			String tarefa = scan.nextLine();
			if(tarefa.equals("")) {
				saida += pilha.remove() + "\n";
			}
			else { 
				int cast = Integer.parseInt(tarefa);
				pilha.add(cast);
			}
		}
		Files.write(Paths.get("C:\\Users\\Usuario\\Desktop\\saida\\tarefas1000.txt"), saida.getBytes()); // inserir aqui o caminho da saída
		scan.close();
		long fim = System.currentTimeMillis();
		System.out.println(fim - inicio);
		
	}

}
