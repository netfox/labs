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
        int nNew = mNewObjects.size();
        PersonDao dao = new PersonDao();
        for ( int i = 0; i < nNew; i ++) {
            dao.insert(mNewObjects.get(i));
        }
    }

    void update() {
        int nUpdate = mDirtyObjects.size();
        PersonDao dao = new PersonDao();
        for ( int i = 0; i < nUpdate; i ++) {
            dao.update(mDirtyObjects.get(i));
        }
    }

    void delete() {
        int nDelete = mDeletedObjects.size();
        PersonDao dao = new PersonDao();
        for ( int i = 0; i < nDelete; i ++) {
            dao.delete(mDeletedObjects.get(i));
        }
    }
}
