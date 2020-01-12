package wasambo.erick.job.interview.activity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import wasambo.erick.job.interview.R;
import wasambo.erick.job.interview.utils.UI;

@SuppressLint("Registered")
public abstract class BaseActivity extends AppCompatActivity {
    protected int theme;
    protected boolean darkTheme;
    protected boolean blackTheme;
    public BaseActivity activityContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityContext = BaseActivity.this;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        setTheme(theme = UI.getTheme(prefs.getString("theme", "fresh")));
        darkTheme = theme == R.style.AppTheme_NoActionBar_Dark ||
                theme == R.style.AppTheme_NoActionBar_Classic_Dark;
        blackTheme = theme == R.style.AppTheme_NoActionBar_Black ||
                theme == R.style.AppTheme_NoActionBar_Classic_Black;

        UI.setNavigationBarMode(activityContext, darkTheme, blackTheme);
    }
}
