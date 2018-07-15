package projTeste;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class resolution {
	
	  public static void main(String[] args) {
		    String numero = null;
		    while (numero == null || numero.equals("")) {
		      numero = JOptionPane.showInputDialog("Insira um numero para o calculo: ");
		      if (numero == null || numero.equals("")) {
		        JOptionPane.showMessageDialog(null, "Você não respondeu a pergunta.");
		      }
		    }
		    
		    System.out.println(Integer.parseInt(numero));
		    
		    int solucao = new resolution().solucao(Integer.parseInt(numero));
		    
		    JOptionPane.showMessageDialog(null, "A solução é:  " + solucao);
      }
	
	
	public int solucao(int n) {
	    List<Integer> digitos = separarDigitos(n);
	    Map<Integer, Integer> ocorrencias;
	    Integer resultado;
	    Integer[] valores;

	    ocorrencias = this.contarOcorrencias(digitos);
	    valores = ocorrencias.values().toArray(new Integer[ocorrencias.size()]);
	    resultado = this.calcularPermutacao(digitos.size(), valores);

	    return resultado;
	  }

	  public Integer calcularPermutacao(Integer total, Integer... repeticoes) {
	    Long denominador = 1L;
	    Long numerador;
	    Long resultado;

	    for (Integer repeticao : repeticoes) {
	      if (repeticao > 1) {
	        denominador = denominador * this.fatorial(repeticao);
	      }
	    }

	    numerador = this.fatorial(total);
	    resultado = numerador / denominador;

	    return resultado.intValue();
	  }

	  private List<Integer> separarDigitos(int numero) {
	    List<Integer> resultado = new ArrayList<>();

	    while (numero != 0) {
	      int digito = numero % 10;
	      numero = numero / 10;
	      resultado.add(digito);
	    }

	    return resultado;
	  }

	  private Map<Integer, Integer> contarOcorrencias(List<Integer> numeros) {
	    Map<Integer, Integer> ocorrencias = new HashMap<>();

	    numeros.forEach((numero) -> {
	      if (ocorrencias.containsKey(numero)) {
	        ocorrencias.put(numero, ocorrencias.get(numero) + 1);
	      } else {
	        ocorrencias.put(numero, 1);
	      }
	    });

	    return ocorrencias;
	  }

	  private Long fatorial(Integer numero) {
	    Long resultado = 1L;

	    for (int fator = 2; fator <= numero; fator++) {
	      resultado = resultado * fator;
	    }

	    return resultado;
	  }
}
