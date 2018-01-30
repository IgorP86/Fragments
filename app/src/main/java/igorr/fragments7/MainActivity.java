package igorr.fragments7;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import igorr.fragments7.fragments.FragmentConfirm;
import igorr.fragments7.fragments.FragmentRegistration;
import igorr.fragments7.fragments.ReplaceListener;

public class MainActivity extends AppCompatActivity implements ReplaceListener {
    private FragmentManager fragManager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Инициализация
        fragManager = getSupportFragmentManager();
    }

    @Override
    public void replaceFragment() {
        transaction = fragManager.beginTransaction();
        //Добавляет новый фрагмент но не удаляет старый
        transaction.replace(R.id.frameContent, new FragmentConfirm());
        transaction.addToBackStack(null);
        transaction.commit();
        //Не работает
        transaction = fragManager.beginTransaction();
        transaction.remove(fragManager.findFragmentById(R.id.fragRegistration));
        transaction.commit();
    }
}
