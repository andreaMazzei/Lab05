package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	int level = 0;
	private List<String> anagrammi = new ArrayList<String>();
	
	public void generaAnagramma(String parola) {
		anagramma(parola, "", 0);
	}
	
	
	public void anagramma(String originale, String parolaParziale, int level) {
		
	int dim = originale.length();
	
	if(level == dim) {//LA PAROLA è COMPLETA
		//scrivi
		System.out.println(parolaParziale);
		anagrammi.add(parolaParziale);
		return;
	}
	
	for(int i=0; i<dim; i++) {
		
		if(countChar(parolaParziale, originale.charAt(i)) < countChar(originale, originale.charAt(i))) {
			
			parolaParziale = parolaParziale + originale.charAt(i);
			
			anagramma(originale, parolaParziale, level+1);
			
			parolaParziale = parolaParziale.substring(0, parolaParziale.length()-1);
			
		}
	}
	
	}
	public Integer countChar(String s, char c) {
		int count = 0;
		char[] charArray = s.toCharArray();
		for(int i=0; i<charArray.length; i++)
			if(charArray[i]==c)
				count++;
		return count;
	}
	
	
	public List<String> getAnagrammi() {
		return anagrammi;
	}


	public List<String> getAnagrammiCorretti(){
		return null;
	}
	
	public List<String> getAnagrammiErrati(){
		return null;
	}

}
