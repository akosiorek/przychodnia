package controler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPacjent {
	static public boolean checkString(String string){
		System.out.println("string: " + string);
		if(string.length() == 0) return false;
		 Pattern p = Pattern.compile("[a-zA-Z]{"+Integer.toString(string.length())+"}");
		 Matcher m = p.matcher(string);
		 return  m.matches();
	}
	
	static public boolean checkNumer(String numer){
		Pattern p = Pattern.compile("[0-9]{"+Integer.toString(numer.length())+"}");
		Matcher m = p.matcher(numer);
		return  m.matches();
	}
	static public boolean checkPesel(String pesel){
		//System.out.println(pesel.length());
		if(pesel.length() != 11)
			return false;
		return checkNumer(pesel);
	}
	
	static public boolean checkNrTelefonu(String numer){
		//System.out.println(numer.length());
		if(numer.length() != 9)
			return false;
		return checkNumer(numer);
	}
}
