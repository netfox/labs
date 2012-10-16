package lab.filters;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/17/12
 * Time: 12:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class LastFilter implements InterfaceComponent {
    @Override
    public void doFilterOperation() {
        System.out.println("\tStart last filter");
        System.out.println("\tEnd last filter");
    }
}
