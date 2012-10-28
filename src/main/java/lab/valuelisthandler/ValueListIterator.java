package lab.valuelisthandler;

import lab.exceptions.IteratorException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/29/12
 * Time: 12:56 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ValueListIterator {
    public int getSize()
            throws IteratorException;

    public Object getCurrentElement()
            throws IteratorException;

    public List getPreviousElements(int count)
            throws IteratorException;

    public List getNextElements(int count)
            throws IteratorException;

    public void resetIndex()
            throws IteratorException;

}
