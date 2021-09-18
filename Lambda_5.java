package lLambda;

import java.util.stream.IntStream;

public class Lambda_5 {

	public static void main(String[] args) {
		
		// 1) 1'den 20'ye kadar olan sayilari yazdiriniz. 
		IntStream.rangeClosed(1, 20).forEach(t -> System.out.print(t + " ")); // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 
		
		
		System.out.println();
		// 2) Functional programlamayi kullanarak 3'den 98'e kadar olan cift tam sayilarin toplamini bulunuz.
		System.out.println(IntStream.rangeClosed(3, 98).filter(t -> t%2 == 0).reduce(0, (x,y) -> x+y)); // 2448 --> reduce() yerine --> sum() kullanilabilir. sum() --> toplama islemini yapar.
		
		
		// 3) Functional Programming kullanarak 9!'i bulunuz. (9! = 1*2*3....*9)
		System.out.println(IntStream.rangeClosed(1, 9).reduce(1, Math::multiplyExact)); // 362880  --> Math::multiplyExact() --> Matematik class'indan cagirilarak carpma islemi yapar.
		
		
		// 4) Ilk 7 Cift sayma sayisinin carpimini bulunuz. (2,4,6,8,10,12,14)
		System.out.println(IntStream.rangeClosed(2, 14).filter(t -> t%2 == 0).reduce(1, Math::multiplyExact)); // 645120
		
		
		// 5)  6'dan büyük ilk 15 tek sayma sayisinin toplamini bulunuz. ==> 7, 9, 11, 13, 15, 17, 19
		System.out.println(IntStream.iterate(7, t -> t+2).limit(150).sum()); // 23400
		
		
		// 6) Ilk 23 tek sayma sayisinin toplamini bulunuz.
		System.out.println(IntStream.iterate(2, t -> t+2).limit(23).sum()); // 552
		
		
		// 7)  11'den 33'e kadar her tam sayinin rakamlarinin toplamini hesaplamak icin bir method olusturunuz.
		IntStream.range(11, 33).map(Lambda_Methods::rakamlarToplami).forEach(t -> System.out.print(t + " ")); // 2 3 4 5 6 7 8 9 10 2 3 4 5 6 7 8 9 10 11 3 4 5 

	}

}