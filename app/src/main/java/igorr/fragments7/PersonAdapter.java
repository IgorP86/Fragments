package igorr.fragments7;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Igorr on 29.01.2018.
 */

public class PersonAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private LayoutInflater inflater;                //с помощью чего выводит
    private ArrayList<Person> personArrayList;      //чем управляет

    public PersonAdapter(Fragment fragment, ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
        this.inflater = LayoutInflater.from(fragment.getContext());     //не совсем ясно
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(
                inflater.inflate(R.layout.fragment_item_contact, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.name.setText(personArrayList.get(position).getName());
        holder.number.setText(personArrayList.get(position).getTelNumber());
        holder.imageView.setImageResource(personArrayList.get(position).getPhotoId());
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }
}
