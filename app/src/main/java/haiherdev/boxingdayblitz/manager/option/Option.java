package haiherdev.boxingdayblitz.manager.option;

/**
 * Created by David on 3/25/2015.
 */
public abstract class Option {

    public abstract String getStringValue ();
    public abstract void setValue (String value);

    public static Option newBool (boolean value) {
        return new BoolOption(value);
    }

    public static Option newString (String value) {
        return new StringOption(value);
    }

}
