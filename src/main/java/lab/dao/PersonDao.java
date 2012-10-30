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
        return DB.connect().getPersons();
    }

    @Override
    public void insert(Object o) {
        if (o instanceof Person) {
            DB.connect().insertPerson((Person)o);
        }
    }

    @Override
    public Object retrieve(Long id) {
        return DB.connect().retrievePerson(id);
    }

    @Override
    public void update(Object o) {
        if (o instanceof Person) {
            DB.connect().updatePerson((Person)o);
        }
    }

    @Override
    public boolean delete(Object o) {
        if (o instanceof Person) {
            return DB.connect().deletePerson((Person)o);
        }
        return false;
    }
}
