package igorr.fragments7;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Igorr on 29.01.2018.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {
    TextView name, number;
    ImageView imageView;

    public ItemViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        number = itemView.findViewById(R.id.number);
        imageView = itemView.findViewById(R.id.imageView);
    }
}
