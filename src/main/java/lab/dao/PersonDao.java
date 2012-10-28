package lab.dao;

import lab.db.DB;
import lab.domain.Person;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/23/12
 * Time: 9:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonDao implements IDao {
    @Override
    public List loadAll() {
        return DB.connect().getContacts();
    }

    @Override
    public void insert(Object person) {
        if (person instanceof Person) {
            DB.connect().insertPerson((Person)person);
        }
    }
}
