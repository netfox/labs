package lab.valuelisthandler;

import lab.dao.PersonDao;
import lab.exceptions.IteratorException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/29/12
 * Time: 1:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class PersonsListHandler extends ValueListHandler {

    private PersonDao mDao = null;

    public void setPersonDao(PersonDao dao) {
        mDao = dao;
    }

    public void executeSearch()
            throws IteratorException {
            List resultsList = mDao.loadAll();
            setList(resultsList);
    }

}
