package igorr.fragments7;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

import butterknife.ButterKnife;
import igorr.fragments7.fragments.ActionListener;
import igorr.fragments7.fragments.FragmentConfirm;
import igorr.fragments7.fragments.FragmentContactsList;
import igorr.fragments7.fragments.FragmentRegistration;

public class MainActivity extends AppCompatActivity implements ActionListener {
    private static final String CONFIRM = "confirm";
    private static final String REGISTRATION = "registration";
    private static final String CONTACTS = "contacts";

    private FragmentManager fragManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Инициализация, добавление первого фрагмента
        this.switchToNextFragment();
    }

    //Обработчик клика по CheckBox
    public void checkBoxListener(View view) {
        if (((CheckBox) findViewById(R.id.checkAccepted)).isChecked()) {
            findViewById(R.id.btnComeIn).setEnabled(true);
        } else findViewById(R.id.btnComeIn).setEnabled(false);
    }

    //заменить фрагмент
    @Override
    public void switchToNextFragment() {
        fragManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragManager.beginTransaction();

        if (fragManager.getFragments().isEmpty()) {
            transaction.add(R.id.frameContent, new FragmentRegistration(), REGISTRATION);
        } else if (fragManager.findFragmentByTag(REGISTRATION).isAdded()) {
            transaction.replace(R.id.frameContent, new FragmentConfirm(), CONFIRM);
        } else if (fragManager.findFragmentByTag(CONFIRM).isAdded()) {
            transaction.replace(R.id.frameContent, new FragmentContactsList(), CONTACTS);
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void popBackStack() {
        fragManager.popBackStack();
    }
}
