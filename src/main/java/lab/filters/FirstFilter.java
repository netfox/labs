package lab.filters;

/**
 * Created with IntelliJ IDEA.
 * User: Tatsiana
 * Date: 10/17/12
 * Time: 12:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class FirstFilter extends BaseFilter {
    public FirstFilter(InterfaceComponent component) {
        super(component);
    }
    @Override
    public void doFilterOperation() {
        System.out.println("Start first filter");
        super.doFilterOperation();
        System.out.println("End first filter");
    }
}
