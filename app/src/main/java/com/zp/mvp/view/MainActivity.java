package com.zp.mvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.zp.mvp.R;
import com.zp.mvp.model.Verifer;
import com.zp.mvp.presenter.IPresenterView;
import com.zp.mvp.presenter.VeriferPresenter;

public class MainActivity extends AppCompatActivity implements IPresenterView {

    EditText editText;
    TextView textView;

    private VeriferPresenter presenterView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
//        final VeriferPresenter presenter = new VeriferPresenter(this); INSTANCIAMIENTO PARA USO DEL presenter COMO INSTANCIA DEL PRESENTADOR EN CONTEXTO ACTIVITY
        inializeView();
        presenterView = new VeriferPresenter(this);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            presenterView.evaluatePassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void inializeView() {
        editText = findViewById(R.id.passwordView);
        textView = findViewById(R.id.passwordlevel);
    }

    @Override
    public void changeWeak () {
        textView.setBackgroundColor(Color.RED);
        textView.setText(R.string.weakLevel);
    }
    @Override
    public void changeMedium () {
        textView.setBackgroundColor(Color.YELLOW);
        textView.setText((R.string.mediumLevel));
    }
    @Override
    public void changeStrong () {
        textView.setBackgroundColor(Color.GREEN);
        textView.setText(R.string.strongLevel);
    }
    @Override
    public void changeSuperStrong () {
        textView.setBackgroundColor(Color.MAGENTA);
        textView.setText(R.string.veryStrongLevel);
    }

}


