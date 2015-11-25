package ch.ethz.inf.milestone1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by m on 24/11/15.
 */
public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder>{

    private ArrayList mDataset;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView mTextTitle;
        private Context mContext;
        public View itemView;

        public ViewHolder(final Context context, View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            mContext = context;
            mTextTitle = (TextView) itemView.findViewById(R.id.textTitle);
            this.itemView = itemView;

        }
    }


    public ToDoAdapter(ArrayList mDataset) {
        this.mDataset = mDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View toDoView = inflater.inflate(R.layout.row_item, parent, false);

        // Return a new holder instance
        return new ViewHolder(context,toDoView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        holder.mTextTitle.setText(mDataset.get(position).toString());



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
