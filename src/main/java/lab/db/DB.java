package lab.db;

import lab.domain.Person;
import lab.dto.DtoPerson;

import java.util.ArrayList;
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
        mPersons.add(new Person("Artyom", "Strok", "+375447373503", "Oktyabrskaya"));
        mPersons.add(new Person("Maxim", "Strok", "+375445435354", "Oktyabrskaya"));
    }

    public static DB connect() {
        if (database == null) {
            database = new DB();
        }
        return database;
    }

    public List<DtoPerson> getContacts() {
        return mPersons;
    }

    public void insertPerson(Person person) {
        mPersons.add(person);
    }
}
