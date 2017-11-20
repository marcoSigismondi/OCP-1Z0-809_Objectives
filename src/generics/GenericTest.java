package generics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


class Person {
	public String name;
	public int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void printName() {
		System.out.println("generics.Person.printName() -->" + name);
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}	
}

class GenericTest {
	
	public static List<Person> list = Arrays.asList(new Person("Fulvia", 37), new Person("Marco", 29), new Person("Benni", 2), new Person("Emma", 0));

	@Test
	void testGenerics() {
		List<Person> sampleList = new ArrayList<Person>(list);
		sampleList.forEach(System.out::println);
		sampleList.remove(new Person("Benni", 2));
		sampleList.add(new Person("Benni", 2));
		sampleList.forEach(System.out::println);
		
		List<?> genericList = new ArrayList<Person>(list);
		genericList.forEach(System.out::println);
		genericList.remove(new Person("Benni", 2));
//		genericList.add(new Person("Benni", 2)); //The method add(capture#3-of ?) in the type List<capture#3-of ?> is not applicable for the arguments (Person)
		genericList.forEach(System.out::println);
		
		List<? extends Person> lowerList = new ArrayList<Person>(list);
		lowerList.forEach(System.out::println);
		lowerList.remove(new Person("Benni", 2));
//		lowerList.add(new Person("Benni", 2)); //The method add(capture#6-of ? extends Person) in the type List<capture#6-of ? extends Person> is not applicable for the arguments (Person)
		lowerList.forEach(System.out::println);
		
		List<? super Person> superList = new ArrayList<Person>(list);
		superList.forEach(System.out::println);
		superList.remove(new Person("Benni", 2));
		superList.add(new Person("Benni", 2)); // <------ Nessun errore in compilazione
		superList.forEach(System.out::println);
		
		List<?> aontherGenericList = new ArrayList(list);
		aontherGenericList.forEach(System.out::println);
		aontherGenericList.remove(new Person("Benni", 2));
//		aontherGenericList.add(new Person("Benni", 2)); //The method add(capture#13-of ?) in the type List<capture#13-of ?> is not applicable for the arguments (Person)
		aontherGenericList.forEach(System.out::println);
		
		List<? extends Person> anotherLowerList = new ArrayList(list);
		anotherLowerList.forEach(System.out::println);
		anotherLowerList.remove(new Person("Benni", 2));
//		anotherLowerList.add(new Person("Benni", 2)); //The method add(capture#17-of ? extends Person) in the type List<capture#17-of ? extends Person> is not applicable for the arguments (Person)
		anotherLowerList.forEach(System.out::println);
		
		List<? super Person> anotherSuperList = new ArrayList(list);
		anotherSuperList.forEach(System.out::println);
		anotherSuperList.remove(new Person("Benni", 2));
		anotherSuperList.add(new Person("Benni", 2)); // <------ Nessun errore in compilazione
		anotherSuperList.forEach(System.out::println);
		
		List<Person> lastGenericList = new ArrayList(list);
		lastGenericList.forEach(System.out::println);
		lastGenericList.remove(new Person("Benni", 2));
		lastGenericList.add(new Person("Benni", 2));
		lastGenericList.forEach(System.out::println);
		
		ArrayList rawType = new ArrayList();
		rawType.add(new Object());
		rawType.add(new Person("Benni", 2));
		rawType.add("ciao");
		List<Person> realLastGenericList = new ArrayList(rawType);
		realLastGenericList.forEach(System.out::println); //java.lang.ClassCastException: java.lang.Object cannot be cast to generics.Person
		
	}

}
