package br.com.denner.services;






public class Operacoes {
	
	public static boolean validaCpf(String numCPF) {
		
			 if (numCPF.equals("00000000000") ||
					 numCPF.equals("11111111111") ||
					 numCPF.equals("22222222222") || numCPF.equals("33333333333") ||
					 numCPF.equals("44444444444") || numCPF.equals("55555555555") ||
					 numCPF.equals("66666666666") || numCPF.equals("77777777777") ||
					 numCPF.equals("88888888888") || numCPF.equals("99999999999") ||
			            (numCPF.length() != 11)) {
					return false;
				 }
			 
			 char dig10, dig11;
		        int sm, i, r, num, peso;

		       
		            sm = 0;
		            peso = 10;
		            for (i=0; i<9; i++) {
		       
		            num = (int)(numCPF.charAt(i) - 48);
		            sm = sm + (num * peso);
		            peso = peso - 1;
		            }

		            r = 11 - (sm % 11);
		            if ((r == 10) || (r == 11))
		                dig10 = '0';
		            else dig10 = (char)(r + 48); 
		            
		            sm = 0;
		            peso = 11;
		            for(i=0; i<10; i++) {
		            num = (int)(numCPF.charAt(i) - 48);
		            sm = sm + (num * peso);
		            peso = peso - 1;
		            }

		            r = 11 - (sm % 11);
		            if ((r == 10) || (r == 11))
		                 dig11 = '0';
		            else dig11 = (char)(r + 48);

		     
		            if ((dig10 == numCPF.charAt(9)) && (dig11 == numCPF.charAt(10)))
		                 return true;
		            else return false;
	}
}
