package lab;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 * Created with IntelliJ IDEA.
 * User: meloman
 * Date: 06.09.12
 * Time: 19:23
 */
@Named
@SessionScoped
public class FormLab {
    private String val1;
    private String val2;
    private String val3;
    private String val4;
    private String[] values;

    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        this.val1 = val1;
    }

    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        this.val2 = val2;
    }

    public String getVal3() {
        return val3;
    }

    public void setVal3(String val3) {
        this.val3 = val3;
    }

    public String getVal4() {
        return val4;
    }

    public void setVal4(String val4) {
        this.val4 = val4;
    }

    public String submit() {
        values = new String[]{val1, val2, val3, val4};
        return "result.xhtml";
    }

    public String[] getValues() {
        return values;
    }
}
