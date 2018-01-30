package igorr.fragments7.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import igorr.fragments7.R;

/**
 * Created by Igorr on 29.01.2018.
 */

public class FragmentConfirm extends Fragment {
    private View view;
    private Unbinder unbinder;

    @BindView(R.id.toolbarConfirmAct)
    Toolbar toolbarConfirmAct;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle state) {
        this.view = inflater.inflate(R.layout.fragment_confirm, parent, false);
        return this.view;
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        unbinder = ButterKnife.bind(this, this.view);
        //Установить toolbarMainAct
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbarConfirmAct);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
