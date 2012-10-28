package lab.dto;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/23/12
 * Time: 10:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class DtoPerson {
    private String mFisrtName;
    private String mLastName;
    private String mMiddleName;
    private String mBirthDate;

    public DtoPerson(String fisrtName, String lastName, String middleName, String birthDate) {
        mFisrtName = fisrtName;
        mLastName = lastName;
        mMiddleName = middleName;
        mBirthDate = birthDate;
    }

    public String getFisrtName() {
        return mFisrtName;
    }

    public void setFisrtName(String fisrtName) {
        mFisrtName = fisrtName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public String getMiddleName() {
        return mMiddleName;
    }

    public void setMiddleName(String middleName) {
        mMiddleName = middleName;
    }

    public String getBirthDate() {
        return mBirthDate;
    }

    public void setBirthDate(String birthDate) {
        mBirthDate = birthDate;
    }
}
