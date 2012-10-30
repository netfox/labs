package lab.db;

import lab.domain.Person;
import lab.dto.DtoPerson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/23/12
 * Time: 9:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class DB {
    private static DB database;
    private List mPersons = new ArrayList();

    private DB() {
        mPersons.add(new Person("Peter", "Ivanov", "Paul", "23.12.1965"));
        mPersons.add(new Person("Mary", "Cerch", "Kate", "17.09.1986"));
    }

    public static DB connect() {
        if (database == null) {
            database = new DB();
        }
        return database;
    }

    public List<DtoPerson> getPersons() {
        return mPersons;
    }

    public void insertPerson(Person person) {
        mPersons.add(person);
    }

    public Person retrievePerson(Long id) {
        Iterator iterator = mPersons.iterator();
        Person person = null;
        while (iterator.hasNext()) {
            if ((person = (Person)iterator.next()).getId() == id) {
                return person;
            }
        }
        return null;
    }

    public void updatePerson(Person person) {
        Iterator iterator = mPersons.iterator();
        Person old = null;
        while (iterator.hasNext()) {
            if ((old = (Person)iterator.next()).getId() == person.getId()) {
                old.setFirstName(person.getFirstName());
                old.setLastName(person.getLastName());
                old.setMiddleName(person.getMiddleName());
                old.setBirthDate(person.getBirthDate());
                return;
            }
        }
    }

    public boolean deletePerson(Person person) {
        return mPersons.remove(person);
    }
}
