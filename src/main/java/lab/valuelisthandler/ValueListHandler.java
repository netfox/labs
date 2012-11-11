package lab.valuelisthandler;

import lab.exceptions.IteratorException;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/29/12
 * Time: 1:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class ValueListHandler implements ValueListIterator {

    private List list;
    private ListIterator listIterator;

    protected ValueListHandler() { }

    protected void setList(List list)  throws IteratorException {
        this.list = list;
        if(list != null)
            listIterator =  list.listIterator();
        else
            throw new IteratorException("List empty");
    }

    public Collection getList() {  return list;}

    public int getSize() throws IteratorException {
        int size;

        if (list != null)
            size = list.size();
        else
            throw new IteratorException("List empty");
        return size;
    }

    public Object getCurrentElement()  throws IteratorException {
        Object obj;
        if (list != null)  {
            int currIndex = listIterator.nextIndex();
            obj = list.get(currIndex);
        } else {  throw new IteratorException("List empty"); }
        return obj;
    }

    public List getPreviousElements(int count)  throws IteratorException{
        int i = 0;
        Object object;
        LinkedList list = new LinkedList();

        if (listIterator != null) {
            while (listIterator.hasPrevious() && (i < count)) {
                object = listIterator.previous();
                list.add(object);  i++;
            }
        }
        else
            throw new IteratorException("No data");
        return list;
    }

    public List getNextElements(int count)
            throws IteratorException {
        int i = 0;
        Object object;
        LinkedList list = new LinkedList();
        if(listIterator != null){
            while(  listIterator.hasNext() && (i < count) ){
                object = listIterator.next();
                list.add(object);
                i++;
            }
        }
        else
            throw new IteratorException("No data");
        return list;
    }

    public void resetIndex() throws IteratorException{
        if(listIterator != null){
            listIterator = list.listIterator();
        }
        else
            throw new IteratorException("No data");
    }

}
