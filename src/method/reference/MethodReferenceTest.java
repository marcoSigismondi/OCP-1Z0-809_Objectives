package method.reference;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Consumer;

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
	
	public void printNameFormatted(String input) {
		System.out.println("generics.Person.printName() -->" + name + " " + input);
	}
	
	public String getName() {
		return name;
	}
	
	public String getNameFormatted(String input) {
		return name + " " + input;
	}
	
	public static void staticPrintName(Person person) {
		System.out.println("generics.Person.printName() -->" + person.name);
	}
	

}

class MethodReferenceTest {

	@Test
	void testMethodReference() {
		Consumer<Person> personConsumer;
		personConsumer = Person::printName;
//		personConsumer = Person::printNameFormatted; //The type Person does not define printNameFormatted(Person) that is applicable here
		personConsumer = Person::getName;
//		personConsumer = Person::getNameFormatted; //The type Person does not define getNameFormatted(Person) that is applicable here
		personConsumer = a -> a.getName();
	}

}
