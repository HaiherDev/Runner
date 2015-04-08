package haiherdev.boxingdayblitz.manager.option;

/**
 * Created by David on 3/25/2015.
 */
public class StringOption extends Option {

    private String value;

    protected StringOption (String value) {
        this.value = value;
    }

    @Override
    public String getStringValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
