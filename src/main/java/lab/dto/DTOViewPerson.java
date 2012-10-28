package lab.dto;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/23/12
 * Time: 9:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class DTOViewPerson {
    private String mNextCommand;

    public DTOViewPerson(String nextCommand) {
        mNextCommand = nextCommand;
    }

    public String getNextCommand() {
        return mNextCommand;
    }

    public void setNextCommand(String nextCommand) {
        mNextCommand = nextCommand;
    }
}
