package lLambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Lambda_7_LambdaFile {

	public static void main(String[] args) {
		
		// Functional Programming kullanarak bir dosya nasil okunur?
		
		try {
			Files.lines(Paths.get("C:\\Users\\ferha\\eclipse-workspace\\LambdaJAVA\\src\\lLambda\\LambdaFile")).forEach(t -> System.out.print(t));
			
		} catch (IOException e) {
			System.out.println(e);
			
		}
		
		// Tüm karakterleri büyük harfe dönüstürün ve okuyun.
		
		try {
            Files.lines(Paths.get("C:\\Users\\ferha\\eclipse-workspace\\LambdaJAVA\\src\\lLambda\\LambdaFile")).map(String::toUpperCase).forEach(t->System.out.println(t));
            
        } catch (IOException e) {
            System.out.println(e);
        }
		
		// Metindeki farkli kelimeleri yazdirin.
		
		try {
            Files.lines(Paths.get("C:\\Users\\ferha\\eclipse-workspace\\LambdaJAVA\\src\\lLambda\\LambdaFile")).map(t->t.split(" ")).flatMap(Arrays::stream).map(t->t.replaceAll("\\W","")).distinct().forEach(System.out::println);
                    
        } catch (IOException e) {
            System.out.println(e);
        }
		
        // Metinde "e" iceren tüm kelimeleri yazdirin. (Sayisinida yazdirabilirsiniz.)


        try {
            Files.lines(Paths.get("C:\\Users\\ferha\\eclipse-workspace\\LambdaJAVA\\src\\lLambda\\LambdaFile")).map(t->t.split(" ")).flatMap(Arrays::stream).filter(t->t.contains("e")).forEach(System.out::println);
                    
        } catch (IOException e) {
            System.out.println(e);
        }

	}

}