package igorr.fragments7;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Igorr on 29.01.2018.
 */

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView name, number;
    ImageView imageView;
    public CustomViewHolder(View itemView) {
        super(itemView);
    }
}
