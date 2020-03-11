package com.zp.mvp.presenter;

import com.zp.mvp.model.Verifer;

import static com.zp.mvp.model.Verifer.MEDIUM;
import static com.zp.mvp.model.Verifer.STRONG;
import static com.zp.mvp.model.Verifer.VERYSTRONG;
import static com.zp.mvp.model.Verifer.WEAK;
import static com.zp.mvp.model.Verifer.passwordVerifier;

public class VeriferPresenter {

    IPresenterView iPresenterView;
    Verifer verifer;

    public VeriferPresenter(IPresenterView iPresenterView) {
        this.iPresenterView = iPresenterView;
        this.verifer = new Verifer();   // conexion con modelo
    }

    public void evaluatePassword(String pass) {
        int passwordintensity = passwordVerifier(pass);

        switch(passwordintensity) {
            case WEAK:
                iPresenterView.changeWeak();
                break;
            case MEDIUM:
                iPresenterView.changeMedium();
                break;
            case STRONG:
                iPresenterView.changeStrong();
                break;
            case VERYSTRONG:
                iPresenterView.changeSuperStrong();
                break;
        }

    }

}
