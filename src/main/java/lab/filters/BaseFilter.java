package lab.filters;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/17/12
 * Time: 12:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class BaseFilter implements InterfaceComponent {
    protected InterfaceComponent component;
    public BaseFilter(InterfaceComponent component) {
        this.component = component;
    }
    @Override
    public void doFilterOperation() {
        component.doFilterOperation();
    }
}
