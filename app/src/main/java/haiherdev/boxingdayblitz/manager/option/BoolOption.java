package haiherdev.boxingdayblitz.manager.option;

/**
 * Created by David on 3/25/2015.
 */
public class BoolOption extends Option {

    private boolean value;

    protected BoolOption (Boolean value) {
        this.value = value;
    }

    public void toggle() {
        this.value = !value;
    }

    @Override
    public String getStringValue() {
        return String.valueOf(value);
    }

    @Override
    public void setValue(String value) {
        this.value = Boolean.valueOf(value);
    }

    public Boolean getBoolValue () {
        return this.value;
    }

}
