package com.example.mvp.Presenter;

        import com.example.mvp.View.ILayout2View;

public class Layout2Presenter implements  ILayout2Presenter{
    ILayout2View iLayout2View;

    public Layout2Presenter(ILayout2View iLayout2View) {
        this.iLayout2View = iLayout2View;
    }
}
