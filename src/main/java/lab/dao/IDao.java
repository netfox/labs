package lab.dao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/23/12
 * Time: 9:23 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IDao {
    List loadAll();
    void insert(Object o);
    Object retrieve(Long id);
    void update(Object o);
    boolean delete(Object o);
}
