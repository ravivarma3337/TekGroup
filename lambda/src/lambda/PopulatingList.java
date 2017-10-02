package lambda;

import java.util.ArrayList;
import java.util.List;

public class PopulatingList {

	public boolean addingIntoTheList() {
		List<Person> personlist = new ArrayList<Person>();
		
		Person p = new Person();
		Person p1 = new Person();
		Person p2 = new Person();
		
		p.setfName("Car");
		p.setLaname("Rover");
		p.setAge("25");
		
		p1.setfName("Bike");
		p1.setLaname("Cbr");
		p1.setAge("50");
		
		p2.setfName("Cars");
		p2.setLaname("BMW");
		p2.setAge("100");
		
		personlist.add(p);
		personlist.add(p1);
		personlist.add(p2);
		
		for(Person pt:personlist) {
			System.out.println(pt);
		}
		
		return true;
	}
}
