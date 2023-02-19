package utilities;

public class ReUsableMethods {

    public String getXpath (int a) {
        return "(((//tbody)[1]/tr)["+ a +"]/td)[4]";
    }
}
