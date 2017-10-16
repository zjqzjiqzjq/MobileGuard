package cn.edu.gdmec.android.mobileguard.m2theftguard;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

import cn.edu.gdmec.android.mobileguard.R;

/**
 * Created by xxc on 2017/10/12.
 */


public class Setup2Activity extends BaseSetUpActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_2);
        ((RadioButton) findViewById(R.id.rb_second)).setChecked(true);
    }
    @Override
    public void showNext(){
        startActivityAndFinishSelf(Setup3Activity.class);
    }
    @Override
    public void showPre(){
        startActivityAndFinishSelf(Setup1Activity.class);    }

}
