package lLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda_2 {
	
	// Method Reference'da bizim olusturdugumuz method'lari veya JAVA method'larini kullaniriz.
	// Method Reference Syntax ---> ClassName: MethodName  System.out.println(); == System.out.println;
	
	public static void main(String[] args) {
		
		List <Integer> myList = new ArrayList<>(Arrays.asList(15, 14, 9, 13, 4, 9, 2, 4, 14));
		
		elemanYazdir(myList);
	System.out.println();
		
		ciftSayiYazdir(myList);
	System.out.println();
	
		tekSayiKare(myList);
	System.out.println();
	
		tekSayiKüpTekrarsiz(myList);
	System.out.println();
	
		farkliCiftSayiKareToplam(myList);
	System.out.println();
		
		farkliCiftSayiKüpCarpim(myList);
	System.out.println();
	
		farkliTersSirala(myList);
	System.out.println();
	
		maxDeger(myList);
	System.out.println();
	
		minDeger(myList);
		
	
	}

	// 1) List'in elemanlarini aralarinda bosluk birakarak yanyana yazdirin.(Method Reference - Kendi Method'umuz)
	public static void elemanYazdir(List <Integer> myList) {
		
		myList.stream().forEach(Lambda_Methods::bosluklaYazdir); // 15 14 9 13 4 9 2 4 14 
		
	}
	
	// 2)List'in elemanlarindan cift olanlari aralarinda bosluk birakarak yanyana yazdirin. (Method Reference)
	public static void ciftSayiYazdir(List <Integer> myList) {
		
		myList.stream().filter(Lambda_Methods::ciftMi).forEach(Lambda_Methods::bosluklaYazdir); // 14 4 2 4 14 
		
	}
	
	// 3) List'teki tek sayilarin karelerini alip aralarinda bosluk birakarak yanyana yazdirin.
	public static void tekSayiKare(List <Integer> myList) {
		
		myList.stream().filter(Lambda_Methods::tekMi).map(Lambda_Methods::kareAl).forEach(System.out::print); // 2258116981
		
	}
	
	// 4) List'teki tekrarli olanlari silip tek sayilarin küplerini alip aralarinda bosluk birakarak yanyana yazdirin.
	public static void tekSayiKüpTekrarsiz(List <Integer> myList) {
		
		myList.stream().distinct().filter(Lambda_Methods::tekMi).map(Lambda_Methods::küpAl).forEach(Lambda_Methods::bosluklaYazdir); // 3375 729 2197 
		
	}
	
	// 5) Farkli cift sayilarin karelerinin toplamini yazdirin. (Use Method Reference)
	public static void farkliCiftSayiKareToplam(List <Integer> myList) {
		
		System.out.println(myList.stream().distinct().filter(Lambda_Methods::ciftMi).map(Lambda_Methods::kareAl).reduce(0, Math::addExact)); // 216
		// addExact() --> Iki degerin toplamini döndürür.
	}
	
	// 6) Farkli cift sayilarin küplerinin carpimini yazdirin. (Use Method Reference)
	public static void farkliCiftSayiKüpCarpim(List <Integer> myList) {
		
		System.out.println(myList.stream().distinct().filter(Lambda_Methods::ciftMi).map(Lambda_Methods::küpAl).reduce(1, Math::multiplyExact)); // 1404928
		// multiplyExact() --> Iki degerin carpimini döndürür.
	}
	
	// 7) List'teki farkli ve 5'ten büyük ve cift elemanlarinin yarisini alip ters siralayarak list olarak yazdirin.
	public static void farkliTersSirala(List <Integer> myList) {
		
		System.out.println(myList.stream().distinct().filter(t -> t>5 && t%2 == 0).map(t -> t/2).sorted(Comparator.reverseOrder()).collect(Collectors.toList())); // [7]
		// sorted(Comporator.reverseOrder()) --> Büyükten kücüge siralamak istersek, Comparator class'indan reverseOrder() method'unu kullaniriz.
	}
	
	// 8) List'teki en büyük elemani bulun.(Use Method Reference)
	public static void maxDeger(List <Integer> myList) {
		
		// I. YOL
		System.out.println(myList.stream().reduce(0, Math::max)); // 15
		
		// Soruda en büyük deger istenirse, reduce sonrasinda "Math::max" olur, en kücük deger istenirse reduce sonrasinda "Math::min" olur.
		System.out.println();
		
		// II. YOL
		System.out.println(myList.stream().reduce(Integer.MIN_VALUE, Math::max)); // 15
		
		// III. YOL
		myList.stream().sorted(Comparator.reverseOrder()).limit(1).forEach(Lambda_Methods::bosluklaYazdir);
		
	}
	
	// 9) List'teki en kücük elemani bulun.(Use Method Reference)
	public static void minDeger(List <Integer> myList) {
		
		// I. YOL
		System.out.println(myList.stream().reduce(Integer.MAX_VALUE, Math::min)); // 2
		
		// II. YOL
		myList.stream().sorted().limit(1).forEach(Lambda_Methods::bosluklaYazdir); // 2 
		
	}
}
