package lLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda_1 {

	public static void main(String[] args) {
		
		List <Integer> myList = new ArrayList<>(Arrays.asList(14, 9, 13, 4, 9, 2, 4, 14, 15));
		
		
		yazdirJava(myList);
		System.out.println();
		yazdirLambda(myList);
		System.out.println();
		
		ciftSayiJava(myList);
		System.out.println();
		ciftSayiLambda(myList);
		System.out.println();
		
		tekSayiKare(myList);
		System.out.println();
		
		farkliTekKüp(myList);
		System.out.println();
		
		ciftSayiKareToplam(myList);
		System.out.println();
		
		tekrarsizCiftKüpCarpim(myList);
		System.out.println();
		
		tersDüzSira(myList);
		System.out.println();


	}

	// ArrayList elemanlarini yanyana yazdiriniz. (JAVA Structured)
	public static void yazdirJava(List <Integer> myList) {
		
		for (Integer each : myList) {
			System.out.print(each + " ");
		}
	
	}
	
	
	// Lambda (Functional) 
	public static void yazdirLambda(List <Integer> myList) {
		
		myList.stream().forEach(t->System.out.print(t + " "));
	
	}
	
	// 2) ArrayList'in elemanlarindan CIFT olanlari aralarinda bosluk birakarak yazdiran method olusturunuz. (Structured)
	public static void ciftSayiJava(List <Integer> myList) {
		
		for (Integer each : myList) {
			if (each%2 == 0) {
				System.out.print(each + " ");
			}
		}
			
	}
	
	//Lambda (Functional)
	public static void ciftSayiLambda(List <Integer> myList) {
							  
		myList.stream().filter(t -> t%2 == 0).forEach(t -> System.out.print(t + " "));
		
		// t :  Lambda expression
		// -> : Arrow function
		
		// for each: Yazdirma islemidir. Tek eleman cikti aliyorsak for each kullanilmaz.
	}
	
	
	// 3) ArrayList'teki tek sayilarin karelerini yazdiran method olusturun.
	public static void tekSayiKare(List <Integer> myList) {
		
		myList.stream().filter(t -> t%2 == 1).map(t -> t*t).forEach(t -> System.out.print(t + " "));
		
		// MAP ---> Stream icerisinde ki elemanlari baska elamanlara dönüstürmek veya üzerlerinde islem yapmak icin Map kullanilmaktadir.
		
	}
	
	// 4) Listede tekrarli elemanlari silip tek sayi olanlarin küplerini yazdiran method olusturunuz.
	public static void farkliTekKüp(List <Integer> myList) {
		
		myList.stream().distinct().filter(t -> t%2 == 1).map(t -> t*t*t).forEach(t -> System.out.print(t + " "));
		
		// distinct() ---> Tekrar eden karakterleri temizler.
		
	}
	
	// 5) Listedeki tekrarli elemanlari silip, cift sayi olanlarin karalerinin toplamini yazdiran bir method yaziniz.
	public static void ciftSayiKareToplam(List <Integer> myList) {
		
		System.out.println(myList.stream().distinct().filter(t -> t%2 == 0).map(t -> t*t).reduce(0, (x,y) -> x+y));
		
		// Reduce: Reduce islemi genelde kümülatif operasyonlarda sikca kullanilir. 
		// Bir veri setinde sirayla islem yapmak istiyorsaniz ve bir önceki yaptiginiz islemi de dahil etmek istiyorsaniz reduce metodunu kullanabilirsiniz.
		
	}
	
	// 6) Listedeki tekrarli elemanlari silip cift sayi olanlarin küplerinin carpimini yazdiran method olusturunuz.
	public static void tekrarsizCiftKüpCarpim(List <Integer> myList) {
		
		System.out.println(myList.stream().distinct().filter(t -> t%2 == 0).map(t -> t*t*t).reduce(1, (x,y) -> x*y));
		
	}
	
	// 7) Listedeki elemanlari siralayarak ve ters siralayarak yazdir.
	public static void tersDüzSira(List <Integer> myList) {
		
		// sorted(): List'i natural order'a göre siralar.
		myList.stream().sorted().forEach(t -> System.out.print(t + " ")); // 2 4 4 9 9 13 14 14 15 
		
		System.out.println();
		
		// sorted(Comparator.reverseOrder()): Büyükten kücüge siralamak istersek, Comparator class'indan reverseOrder() method'uyla yazdiriyoruz.
		myList.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t + " ")); // 15 14 14 13 9 9 4 4 2 
		
	}

}