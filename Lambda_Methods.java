package lLambda;

public class Lambda_Methods {
	
	public static void bosluklaYazdir(Object O) {
		
		System.out.print(O + " ");
	}
	
	public static boolean ciftMi(int X) {
		
		return X%2 == 0;
	}
	
	
	public static boolean tekMi(int X) {
		
		return X%2 == 1;
	}
	
	
	public static int küpAl(int X) {
		
		return X*X*X;
	}
	
	
	public static int kareAl(int X) {
		
		return X*X;
	}
	
	
	public static int rakamlarToplami(int X) {
		
		int toplam = 0;
		
		while (X != 0) {
			toplam += X%10;
			X = X/10;
		}
			return toplam;
	}

}