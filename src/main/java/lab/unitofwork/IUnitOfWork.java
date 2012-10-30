package lab.unitofwork;

import lab.domain.IIdHandler;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/30/12
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IUnitOfWork {
    void registerNew(IIdHandler object);
    void registerDirty(IIdHandler object);
    void registerClean(IIdHandler object);
    void registerDeleted(IIdHandler object);
    void commit();

}
