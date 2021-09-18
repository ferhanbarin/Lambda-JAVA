package lLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda_4 {

	public static void main(String[] args) {
		
		List <String> myList = new ArrayList<>(Arrays.asList("Ali", "Ali", "Aysima", "Abdurrahman", "Mehmet", "Mustafa", "Bedirhan", "Y�ksel", "S�leyman"));
		
		yazdirB�y�k1(myList);
	System.out.println();
		
		uzunlukSirala(myList);
	System.out.println();
	
		farkliSonHarfSirala(myList);
	System.out.println();
		
		uzunlukSiralaIlkEleman(myList);
	System.out.println();
		
		yazdirAIleBasyan(myList);
	System.out.println();
		
		AbaslaVeyaiBit(myList);
	System.out.println();
	
		siralaB�y�t(myList);
	System.out.println();
	
		isimUzunlukSirala(myList);
	System.out.println();
	
		karesiniAlSiralaSil(myList);
	System.out.println();
	
		ebikGabik(myList);
	System.out.println();
	
		sondanIkinciSiralaIlk(myList);
	System.out.println();
		
		terstenSiralaIlkYazdir(myList);
	System.out.println();
		
	}

	// 1) List'in elemanlarini b�y�k harfle yazdiriniz.
	public static void yazdirB�y�k1(List <String> myList) {
		
		// I. YOL
		myList.stream().map(t -> t.toUpperCase()).forEach(Lambda_Methods::bosluklaYazdir); // AL? AL? AYS?MA ABDURRAHMAN MEHMET MUSTAFA BED?RHAN Y�KSEL S�LEYMAN
		
		System.out.println();
		
		// II. YOL
		myList.stream().map(String::toUpperCase).forEach(Lambda_Methods::bosluklaYazdir); // AL? AL? AYS?MA ABDURRAHMAN MEHMET MUSTAFA BED?RHAN Y�KSEL S�LEYMAN
		
	}
	
	// 2) Elemanlari uzunluklarina g�re siralayin ve yazdirin.  -  NOTE: JAVA elemanlari varsayilan olarak artan siraya koyar.
	public static void uzunlukSirala(List <String> myList) {
		
		myList.stream().sorted(Comparator.comparing(String::length)).forEach(Lambda_Methods::bosluklaYazdir); // Ali Ali Aysima Mehmet Y�ksel Mustafa Bedirhan S�leyman Abdurrahman 
		
		System.out.println();
		
		myList.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(Lambda_Methods::bosluklaYazdir); // Abdurrahman Bedirhan S�leyman Mustafa Aysima Mehmet Y�ksel Ali Ali 
	}
	
	// 3) Farkli elemanlarini son harflerine g�re siralayin.
	public static void farkliSonHarfSirala(List <String> myList) {
		
		myList.stream().distinct().sorted(Comparator.comparing(t -> t.substring(t.length()-1))).forEach(Lambda_Methods::bosluklaYazdir); // Aysima Mustafa Ali Y�ksel Abdurrahman Bedirhan S�leyman Mehmet 
		
	}
	
	// 4) Elemanlari uzunluklarina ve ardindan (ayni uzunlukta olanlari) ilk karakterlerine g�re siralamak icin bir y�ntem olusturunuz.
	public static void uzunlukSiralaIlkEleman(List <String> myList) {
		
		myList.add("Ata");
		myList.stream().sorted(Comparator.comparing(String::length).thenComparing(t -> t.charAt(0))).forEach(Lambda_Methods::bosluklaYazdir); // Ali Ali Ata Aysima Mehmet Y�ksel Mustafa Bedirhan S�leyman Abdurrahman 
		
		System.out.println();
		
		myList.stream().sorted(Comparator.comparing(String::length).thenComparing(t -> t.substring(0, 1))).forEach(Lambda_Methods::bosluklaYazdir); // Ali Ali Ata Aysima Mehmet Y�ksel Mustafa Bedirhan S�leyman Abdurrahman
	}
	
	// 5) B�y�k harflerle, "A" ile baslayan liste �gelerini yazdirmak icin bir y�ntem olusturunuz.
	public static void yazdirAIleBasyan(List <String> myList) {
		
		myList.stream().filter(t -> t.startsWith("A")).map(t -> t.toUpperCase()).forEach(Lambda_Methods::bosluklaYazdir); // ALI ALI AYSIMA ABDURRAHMAN ATA 
		
	}
	
	// 6) K���k harflerle, "A" ile baslayan veya "i" ile biten liste �gelerini yazdirmak i�in bir y�ntem olusturunuz.
	public static void AbaslaVeyaiBit(List <String> myList) {
		
		myList.stream().filter(t -> t.startsWith("A") || t.endsWith("i")).map(t -> t.toLowerCase()).forEach(Lambda_Methods::bosluklaYazdir); // ali ali aysima abdurrahman ata 
		
		// Method Reference ile yaparsak komutlarin icine sadece bir islem alabiliriz. Arrow (->) function'da "& ve ||" ile istedigimiz kadar islem alabiliriz.
		
	}
	
	// 7) Ogeleri uzunluklarina g�re siraladiktan sonra b�y�k harflerle yazdirmak icin bir y�ntem olusturunuz.
	public static void siralaB�y�t(List <String> myList) {
		
		myList.stream().map(String::toUpperCase).sorted(Comparator.comparing(String::length)).forEach(Lambda_Methods::bosluklaYazdir); // ALI ALI ATA AYSIMA MEHMET Y�KSEL MUSTAFA BEDIRHAN S�LEYMAN ABDURRAHMAN 
		
	}
	
	// 8) Elemanlari uzunluklarina g�re siralayin �nce elemani sonra uzunlugunu yazdiriniz.  -  Ali:3  Aysima:6
	public static void isimUzunlukSirala(List <String> myList) {
		
		myList.stream().sorted(Comparator.comparing(String::length)).map(t -> t + ":" + t.length()).forEach(Lambda_Methods::bosluklaYazdir); // Ali:3 Ali:3 Ata:3 Aysima:6 Mehmet:6 Y�ksel:6 Mustafa:7 Bedirhan:8 S�leyman:8 Abdurrahman:11 
		
		// Degisiklik yapmak istiyorsak "map()" kullanilir.
	}
	
	// 9) Her elemanin uzunlugunun karesini alip tekrarlilari silip, bunlarin 20'den b�y�k olanlarini ters sirada yazdiriniz. 
	public static void karesiniAlSiralaSil(List <String> myList) {
		
		myList.stream().map(t -> t.length()*t.length()).distinct().filter(t -> t>20).sorted(Comparator.reverseOrder()).forEach(Lambda_Methods::bosluklaYazdir); // 121 64 49 36 
		
	}
	
	// 10) T�m elemanlarin uzunluklarinin 12'den az olup olmadigini kontrol etmek i�in bir method olusturunuz.
	//     B�t�n elemanlarin "x" ile baslamadigini kontrol etmek i�in bir y�ntem olusturunuz.
	//     En az 1 tane "R" ile biten eleman olup olmadigini kontrol etmek i�in bir metod olusturunuz. 
	public static void ebikGabik(List <String> myList) {
		
		boolean result1 = myList.stream().allMatch(t -> t.length()<12); // true
		System.out.println("Elemanlarin uzunluklari 12'den k�c�k m�? : " + result1);
		
	// allMatch(): B�t�n elemanlarda olmasini istedigimiz seyleri yazariz sonu� boolean verir.
	// Ornegin String bir List icin ==> allMatch(t -> t.length() < 7) == elemanlarin hepsinin uzunlugu 7'den k�c�kse true, biri bile degilse false verir.
				
		
		boolean result2 = myList.stream().noneMatch(t -> t.startsWith("X")); // true
		System.out.println("'X' ile baslayan �ge yok mu? : " + result2);
		
	// noneMatch(): Hicbir elemanda olmasin istersek kullaniriz. Elemanlarin t�m�nde yoksa true, bir tane elemanda bile varsa false verir. 
	// Ornegin ==> noneMatch(t-> t.startsWith("X")) == Hicbiri X ile baslamiyorsa true.
		
				
		boolean result3 = myList.stream().anyMatch(t -> t.endsWith("R")); // false
		System.out.println("En az 1 tane 'R' ile biten eleman varmi? : " + result3);
		
	// anyMatch(): En az bir elemanda olmasini istedigimiz bir �zellik varsa kullaniriz, sonuc boolean verir.
	// Ornegin ==> anyMatch(t-> t.endsWith("R")) == En az bir eleman R ile bitiyorsa true, yoksa false verir.
		
	}
	
	// 11) Elemanlari sondan 2. elemanlarina g�re siralayip ilk elemani yazdiriniz.
	public static void sondanIkinciSiralaIlk(List <String> myList) {
		
		System.out.println(myList.stream().sorted(Comparator.comparing(t -> t.charAt(t.length()-2))).findFirst()); // Optional[Abdurrahman]
		
		
	// findFirst(): Listedeki ilk elemani verir.(Tek eleman verecegi icin, forEach ile yazdirilmaz. B�t�n soru syso'nun icine alinarak yazdirilabilir.
		
	}
	
	// 12) Elemanlari uzunluklarina g�re tersten siralayip ilk elemani yazdiriniz.
	public static void terstenSiralaIlkYazdir(List <String> myList) {
		
		System.out.println(myList.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst()); // Optional[Abdurrahman]

	}
}	