package haiherdev.boxingdayblitz.manager;

import android.app.Activity;
import android.content.SharedPreferences;

import java.util.HashMap;

import haiherdev.boxingdayblitz.manager.option.BoolOption;
import haiherdev.boxingdayblitz.manager.option.Option;

/**
 * Created by David on 3/25/2015.
 */
public class OptionsManager {

    HashMap<String, Option> options = new HashMap<String, Option>();

    public static OptionsManager newInstance (Activity activity, String pref_name) {
        return new OptionsManager().loadOptions(activity, pref_name);
    }

    private OptionsManager loadOptions (Activity activity, String PREFS_NAME) {
        SharedPreferences settings = activity.getSharedPreferences(PREFS_NAME, 0);
        options.put("sound_toggle", Option.newBool(settings.getBoolean("sound_toggle", true)));
        options.put("difficulty", Option.newString(settings.getString("difficulty", "easy")));

        return this;
    }

    public OptionsManager saveOptions (Activity activity, String PREFS_NAME) {
        SharedPreferences settings = activity.getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("sound_toggle", ((BoolOption) getOption("sound_toggle")).getBoolValue());
        editor.putString("difficulty", getOption("difficulty").getStringValue());

        editor.apply();

        return this;
    }

    public Option getOption (String key) {
        return options.get(key);
    }

    public Option setOption (String key, String value) {
        options.get(key).setValue(value);
        return options.get(key);
    }
}
