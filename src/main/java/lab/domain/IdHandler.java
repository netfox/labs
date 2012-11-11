package lab.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/28/12
 * Time: 11:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class IdHandler implements IIdHandler {
    private static Long mCurrCommonId = Long.valueOf(0);
    protected final Long mId;
    protected IdHandler() {
        mId = mCurrCommonId ++;
    }
    @Override
    public Long getId() {
        return mId;
    }
}
