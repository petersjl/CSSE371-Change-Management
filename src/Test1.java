import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import supportClasses.Person;
import supportClasses.PersonList;

public class Test1 {

	@Test
	public void testUniqueness() {
		ArrayList<Person> people = PersonList.getPersonList("./src/test1.txt");

		long startTime = System.currentTimeMillis();
		ArrayList<Person> nonUniquePeople = PeopleManager.getNonUniquePeople(people);
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		
		assertTrue(elapsedTime < 5000);
		assertEquals(3, nonUniquePeople.size());
		
		for (Person p : nonUniquePeople) {
			switch (p.getLastName())
			{
			case "Cooper":
				assertEquals("Cooper", p.getLastName());
				assertEquals("Sarah", p.getFirstName());
				assertEquals("Craig", p.getMiddleName());
				break;
			case "Mason":
				assertEquals("Mason", p.getLastName());
				assertEquals("Ashley", p.getFirstName());
				assertEquals("Donna", p.getMiddleName());
				break;
			case "Arnold":
				assertEquals("Arnold", p.getLastName());
				assertEquals("Keith", p.getFirstName());
				assertEquals("David", p.getMiddleName());
				break;
			default:
				fail("Person with last name " + p.getLastName() + " should not be unique");
			}		
		}
	}
	
}
