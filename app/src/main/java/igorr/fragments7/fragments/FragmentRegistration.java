package igorr.fragments7.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public ReplaceListener actionReplace;

    @BindView(R.id.toolbarMainAct)
    Toolbar toolbarMainAct;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            actionReplace = (ReplaceListener) context;
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

    //Вызывается при нажатии любой кнопки
    @OnClick(R.id.btnContinue)
    protected void onClickAnyButton() {
        actionReplace.replaceFragment();
    }
}
