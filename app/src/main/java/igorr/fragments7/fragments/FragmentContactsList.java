package igorr.fragments7.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import igorr.fragments7.Person;
import igorr.fragments7.PersonAdapter;
import igorr.fragments7.R;

/**
 * Created by Igorr on 29.01.2018.
 */

public class FragmentContactsList extends Fragment {
    private ActionListener actionListener;
    private Unbinder unbinder;
    private View view;
    private ArrayList<Person> contactsArray = new ArrayList<>();

    @BindView(R.id.toolbarContacts)
    Toolbar toolbar;
    @BindView(R.id.contactsView)
    RecyclerView contactView;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle bundle) {
        view = inflater.inflate(R.layout.fragment_contacts_view, parent, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        unbinder = ButterKnife.bind(this, this.view);

        //Toolbar
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
        setHasOptionsMenu(true);

        //Автозаполнение контактов
        this.listInit();

        //List
        PersonAdapter personAdapter = new PersonAdapter(this, contactsArray);
        contactView.setAdapter(personAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void listInit() {
        for (int i = 0; i != 20; i++) {
            contactsArray.add(new Person("Контакт " + i, Person.generateRandTel(), R.mipmap.ic_google_foreground));
        }
    }

    //Кнопки
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            actionListener.popBackStack();
        }
        return true;
    }
}
