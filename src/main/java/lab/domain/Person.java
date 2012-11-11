package lab.domain;

import lab.unitofwork.UnitOfWork;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/28/12
 * Time: 11:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person extends IdHandler{

    private String mFirstName;
    private String mLastName;
    private String mMiddleName;
    private String mBirthDate;

    public Person(String firstName, String lastName, String middleName, String birthDate) {
        super();
        mFirstName = firstName;
        mLastName = lastName;
        mMiddleName = middleName;
        mBirthDate = birthDate;
        UnitOfWork.getInstance().registerNew(this);
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
        UnitOfWork.getInstance().registerDirty(this);
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
        UnitOfWork.getInstance().registerDirty(this);
    }

    public String getMiddleName() {
        return mMiddleName;
    }

    public void setMiddleName(String middleName) {
        mMiddleName = middleName;
        UnitOfWork.getInstance().registerDirty(this);
    }

    public String getBirthDate() {
        return mBirthDate;
    }

    public void setBirthDate(String birthDate) {
        mBirthDate = birthDate;
        UnitOfWork.getInstance().registerDirty(this);
    }
}
