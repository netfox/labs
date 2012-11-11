package lab.unitofwork;

import lab.dao.PersonDao;
import lab.domain.IIdHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/30/12
 * Time: 9:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class UnitOfWork implements IUnitOfWork {

    private List<IIdHandler> mNewObjects = new ArrayList<IIdHandler>();
    private List<IIdHandler> mDirtyObjects = new ArrayList<IIdHandler>();
    private List<IIdHandler> mDeletedObjects = new ArrayList<IIdHandler>();

    private static UnitOfWork instance;

    private UnitOfWork() {}

    public static UnitOfWork getInstance() {
        if (instance == null) {
            instance = new UnitOfWork();
        }
        return instance;
    }
    @Override
    public void registerNew(IIdHandler object) {
        if (object != null &&
                object.getId() != null &&
                !mNewObjects.contains(object) &&
                !mDirtyObjects.contains(object) &&
                !mDeletedObjects.contains(object)) {
            mNewObjects.add(object);
        }
    }

    @Override
    public void registerDirty(IIdHandler object) {
        if (object != null &&
                object.getId() != null &&
                !mNewObjects.contains(object) &&
                !mDirtyObjects.contains(object) &&
                !mDeletedObjects.contains(object)) {
            mDirtyObjects.add(object);
        }
    }

    @Override
    public void registerClean(IIdHandler object) {
        if (object != null &&
                object.getId() != null) {
            mNewObjects.remove(object);
            mDirtyObjects.remove(object);
            mDirtyObjects.remove(object);
        }
    }

    @Override
    public void registerDeleted(IIdHandler object) {
        if (object != null &&
                object.getId() != null &&
                !mNewObjects.contains(object) &&
                !mDeletedObjects.contains(object)) {
            mDirtyObjects.remove(object);
            mDeletedObjects.add(object);
        }
    }

    @Override
    public void commit() {
        insert();
        update();
        delete();
    }

    void insert() {
        PersonDao dao = new PersonDao();
        int nPersons = mNewObjects.size();
        for (int index = 0; index < nPersons; index ++) {
            dao.insert(mNewObjects.get(index));
        }
        mNewObjects.clear();
    }

    void update() {
        PersonDao dao = new PersonDao();
        int nPersons = mDirtyObjects.size();
        for (int index = 0; index < nPersons; index ++) {
            dao.update(mDirtyObjects.get(index));
        }
       mDirtyObjects.clear();
    }

    void delete() {
        PersonDao dao = new PersonDao();
        int nPersons = mDeletedObjects.size();
        for (int index = 0; index < nPersons; index ++) {
            dao.delete(mDeletedObjects.get(index));
        }
        mDeletedObjects.clear();
    }
}
