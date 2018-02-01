package igorr.fragments7.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import igorr.fragments7.R;

/**
 * Created by Igorr on 29.01.2018.
 */

public class FragmentRegistration extends Fragment {
    private View view;
    private Unbinder unbinder;

    public ActionListener actionListener;

    @BindView(R.id.toolbarMainAct)
    Toolbar toolbarMainAct;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            actionListener = (ActionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " должен реализовывать интерфейс ActionReplace");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle state) {
        this.view = inflater.inflate(R.layout.fragment_registration, parent, false);
        return this.view;
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        unbinder = ButterKnife.bind(this, this.view);
        //Установить toolbarMainAct
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbarMainAct);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //Кнопки...
    @OnClick(R.id.btnContinue)
    protected void onClickContinue() {
        actionListener.switchToNextFragment();
    }

    @OnClick(R.id.btnRegistration)
    protected void onClickRegistration() {
        Snackbar.make(this.view, "Нажата кнопка Регистрация", Snackbar.LENGTH_INDEFINITE).show();
    }

    @OnClick(R.id.btnVk)
    protected void onClickVK(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com")));
    }

    @OnClick(R.id.btnFacebook)
    protected void onClickFacebook(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com")));
    }

    @OnClick(R.id.btnGoogle)
    protected void onClickGoogle(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com")));
    }
}
