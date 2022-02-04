package hi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest
{
	Person A;
	Person B;
	Person C;
	Person D;
	
	@BeforeEach
	void setUp() throws Exception
	{
		A = new Person("Ann", "Doe", 15);
		B = new Person("Bob", "Doe", 13);
		C = new Person("Con", "Doe", 64);
		D = new Person("Dan", "Doe", 974);
	}

	@Test
	void testToString()
	{
		assertEquals("Person: Ann Doe, 15", A.toString());
		//fail("Not yet implemented");
	}

	@Test
	void testPerson()
	{
		assertThrows(UnderAgeException.class, 
				()->{ 
					A.makePerson(B); 
				});
		
		Person child;
		try
		{
			child = C.makePerson(D);
			assertEquals(C.getFname(), child.getFname());
			assertEquals(D.getLname(), child.getLname());
			assertEquals(0, child.getAge());
		} catch (UnderAgeException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("threw exception");
		}
	}
	
}
