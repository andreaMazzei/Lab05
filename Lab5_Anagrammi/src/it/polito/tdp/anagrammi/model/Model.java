package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	public Set<String> generaAnagramma(String parola) { // METODO CHE CHIAMA LA PRIMA CHIAMATA RICORSIVA
		Set<String> anagrammi = new HashSet<String>();
		anagramma(parola, "", 0, anagrammi);
		return anagrammi;
	}
	
	public void anagramma(String originale, String parolaParziale, int level, Set<String> anagrammi) {
		int dim = originale.length();
		
		if(level == dim) { //FINE RICORSIONE
			System.out.println(parolaParziale);
			anagrammi.add(parolaParziale);
			return;
		}
		
		for(int i=0; i<dim; i++) {
			
			if(countChar(parolaParziale, originale.charAt(i)) < countChar(originale, originale.charAt(i))) {	
				parolaParziale += originale.charAt(i);
				anagramma(originale, parolaParziale, level+1, anagrammi);
				parolaParziale = parolaParziale.substring(0, parolaParziale.length()-1);
			}
		}
	}

	
	public Integer countChar(String s, char c) { // CONTO QUANTE VOLTE È PRESENTE UN CARATTERE
		int count = 0;							 // IN UNA STRINGA
		char[] charArray = s.toCharArray();
		for(int i=0; i<charArray.length; i++)
			if(charArray[i]==c)
				count++;
		return count;
	}

	public boolean isCorrect(String anagramma) {
		AnagrammaDAO dao = new AnagrammaDAO();
		return dao.isCorrect(anagramma);
	}

}
