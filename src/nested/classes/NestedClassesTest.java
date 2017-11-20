package nested.classes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.Serializable;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

import nested.classes.OuterClass.StaticClass;


/**
 * Create inner classes including static inner class, local class, 
 * nested class, and anonymous inner class
*/

class OuterClass{
	
	private static String staticFiled = "nested.classes.OuterClass.staticFiled";
	private String instanceField = "nested.classes.OuterClass.instanceField";
	
	/*static class*/
	public static class StaticClass{
		public void print() {
			System.out.println("nested.classes.OuterClass.StaticClass");
			System.out.println(staticFiled);
//			System.out.println(instanceField); //Cannot make a static reference to the non-static field instanceField
		}
	}
	
	/*inner class*/
	public class InnerClass{
		public void print() {
			System.out.println("nested.classes.OuterClass.InnerClass");
			System.out.println(staticFiled);
			System.out.println(instanceField);
		}
	}
	
	public static void staticMethod(String param) {
		final String finalParam = "finalParam";
		String effectivelyFinalParam = "effectivelyFinalParam";
		String nonFinalParam ="nonFinalParam";
		nonFinalParam = "changed";
		
//		static class LocalClass{ //Illegal modifier for the local class LocalClass; only abstract or final is permitted
		class LocalClass{
			public void print() {
				System.out.println(param);
				System.out.println(finalParam);
				System.out.println(effectivelyFinalParam);
//				System.out.println(nonFinalParam); //Local variable nonFinalParam defined in an enclosing scope must be final or effectively final
//				this.new InnerClass(); //LocalClass.InnerClass cannot be resolved to a type
//				OuterClass.this.new InnerClass(); //No enclosing instance of the type OuterClass is accessible in scope
				new StaticClass();
				System.out.println(staticFiled);
//				System.out.println(instanceField); //Cannot make a static reference to the non-static field instanceField
			}
		}
		
		Comparator<String> comparatore = new Comparator<String>() {
			
			final String finalParam = "finalParam";
			String effectivelyFinalParam = "effectivelyFinalParam";
			String nonFinalParam ="nonFinalParam";

			@Override
			public int compare(String o1, String o2) {
				nonFinalParam = "changed";
				System.out.println(param);
				System.out.println(finalParam);
				System.out.println(effectivelyFinalParam);
				System.out.println(staticFiled);
//				System.out.println(instanceField); //Cannot make a static reference to the non-static field instanceField
				return o1.compareTo(o2);
			}
			
		};
		
		
	}
}

class NestedClassesTest {

	@Test
	void test() {		
		OuterClass.StaticClass staticClass = null;
		staticClass = new StaticClass();  // Non c'è bisogno del nome della classe Outer grazie a import nested.classes.OuterClass.StaticClass;
		staticClass = new OuterClass.StaticClass(); // costruttore standard
		
		OuterClass.InnerClass innerClass;
		OuterClass outerClass = new OuterClass();
		innerClass = new OuterClass().new InnerClass();
		innerClass = outerClass.new InnerClass(); 
	}

}
