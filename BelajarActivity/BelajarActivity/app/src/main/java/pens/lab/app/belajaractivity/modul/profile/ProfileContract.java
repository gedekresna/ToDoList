package pens.lab.app.belajaractivity.modul.profile;

import android.os.Bundle;

import pens.lab.app.belajaractivity.base.BasePresenter;
import pens.lab.app.belajaractivity.base.BaseView;

/**
 * Created by fahrul on 13/03/19.
 */

public interface ProfileContract {
    interface View extends BaseView<Presenter> {
        void setprofile(String email,String Password);
    }

    interface Presenter extends BasePresenter {
        void initializeProfile(Bundle bundle);
    }
}
