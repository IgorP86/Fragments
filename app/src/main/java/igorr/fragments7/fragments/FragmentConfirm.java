package igorr.fragments7.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
    @BindView(R.id.checkAccepted)
    CheckBox checkBox;
    @BindView(R.id.btnComeIn)
    Button btnEnter;
    @BindView(R.id.inputCodeHere)
    TextView tvSecretCode;

    //Интерфейс для связи с активити
    private ActionListener actionListener;

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
        this.view = inflater.inflate(R.layout.fragment_confirm, parent, false);
        return this.view;
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        unbinder = ButterKnife.bind(this, this.view);

        //Установить ActionBar и кнопку back
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbarConfirmAct);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
        setHasOptionsMenu(true);    //нужно для активации тулбара во фрагменте

        //Установить начальное состояние кнопки
        if (!checkBox.isChecked()) btnEnter.setEnabled(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //Обработчики кнопок
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            actionListener.popBackStack();
        }
        return true;
    }

    @OnClick(R.id.btnComeIn)
    protected void onClickComeIn() {
        if ((tvSecretCode.getText().toString().isEmpty())) {
            Snackbar.make(this.view, "Я молодец!", Snackbar.LENGTH_SHORT).addCallback(
                    new Snackbar.Callback() {
                        @Override
                        public void onDismissed(Snackbar snackbar, int event) {
                            super.onDismissed(snackbar, event);
                            if (event == Snackbar.Callback.DISMISS_EVENT_TIMEOUT) {
                                Log.d("event", "DISMISS_EVENT_TIMEOUT");
                                actionListener.switchToNextFragment();
                            }
                        }
                    }).show();
        } else {
/*            Toast toast = Toast.makeText(getApplicationContext(), "Ошибка: пустое поле", (Toast.LENGTH_SHORT));
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();*/
        }
    }
}