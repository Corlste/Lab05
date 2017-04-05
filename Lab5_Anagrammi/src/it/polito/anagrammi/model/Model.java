package it.polito.anagrammi.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.controller.db.AnagrammaDAO;

public class Model {

	private List<String> anagrammi = null;
	private String parola;
	private List<String> anagrammiR = null;
	private List<String> anagrammiW = null;
	char x;
	
	public void findAnagrams(String parola){
		
		String anagramma = new String();
		anagramma="";
		anagrammi = new LinkedList<String>();
		int step = 0;
		recursive (anagramma, step);
		
		correggi();
		
	}
	

	public Model() {
		super();
		this.anagrammi=null;
		this.anagrammiR=null;
		this.anagrammiW=null;
		this.parola=null;
	}


	public List<String> getAnagrammiR() {
		return anagrammiR;
	}



	public void setAnagrammiR(List<String> anagrammiR) {
		this.anagrammiR = anagrammiR;
	}



	public List<String> getAnagrammiW() {
		return anagrammiW;
	}



	public void setAnagrammiW(List<String> anagrammiW) {
		this.anagrammiW = anagrammiW;
	}




	

	private void correggi() {

		anagrammiR = new ArrayList<String>();
		anagrammiW = new ArrayList<String>();

		AnagrammaDAO a = new AnagrammaDAO();
		for(String s: anagrammi){
			if (a.isCorrect(s)){
				anagrammiR.add(s);
			}else{
				anagrammiW.add(s);
			}
		}
		
	}



	private void recursive(String anagram, int step){
		
		if (this.parola.length()==step){
			if (!anagram.contains(anagram))
			anagrammi.add(anagram);
			return;
		}
		
		for(int i=0; i<parola.length(); i++){
			x=this.parola.charAt(i);
			
			
			//anagram += "x";
			recursive(anagram + x, step+1);
			// anagramma = anagramma.substring(0, step);
		}
		
		
		
	}
	
	private boolean contaLettere(String anagram, char x){
		int cParola = 0;
		int cAnagramma= 0;
		
		for (int i=0; i<anagram.length(); i++){
			if (anagram.charAt(i)== x){
				cAnagramma++;
			}
		}

		for (int i=0; i<this.parola.length(); i++){
			if(parola.charAt(i)== x){
				cParola ++;
			}
			
		}
		
		if (cAnagramma<cParola== true){
			return true;
		}
		return false;
	}
	
}
