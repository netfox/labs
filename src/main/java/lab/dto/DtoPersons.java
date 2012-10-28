package lab.dto;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/23/12
 * Time: 10:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class DtoPersons {
    private Set<DtoPerson> mPersons;
    private String path;

    public Set<DtoPerson> getDtoPersons() {
        return mPersons;
    }

    public void setPersons(Set<DtoPerson> persons) {
        mPersons = persons;
    }
}
