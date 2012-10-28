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
    private String mPath;
    private int mCurrentPage;
    private int mNumOfPages;

    public Set<DtoPerson> getDtoPersons() {
        return mPersons;
    }

    public void setPersons(Set<DtoPerson> persons) {
        mPersons = persons;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        mPath = path;
    }

    public int getCurrentPage() {
        return mCurrentPage;
    }

    public void setCurrentPage(int currentPage) {
        mCurrentPage = currentPage;
    }

    public int getNumOfPages() {
        return mNumOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        mNumOfPages = numOfPages;
    }
}
