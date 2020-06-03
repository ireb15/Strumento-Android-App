import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.instrument_app.R;

import java.util.ArrayList;

public class  acousticGuitarsAdapter extends ArrayAdapter<AcousticGuitar> {
     private static class ViewHolder{
           public ImageView ivAcousticGuitar;
           public TextView  tvTitle;
           public TextView tvDescription;
     }

    public acousticGuitarsAdapter(Context context, ArrayList<AcousticGuitar> acousticGuitars){
         super(context, 0, acousticGuitars);
     }

    //translates a particular 'Book' given a position
    // into a relevant row within an AdapterView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO: Complete the definition of the view for each book
        //  return null;
        //  }

        //get the data item for this position
        final Instrument instrument = getItem(position);
        //check if an existing view is being reused,
        // otherwise inflate the view

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_instrument, parent, false);
            viewHolder.ivAcousticGuitar = (ImageView) convertView.findViewById(R.id.ivAcousticGuitarCover);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //Populate the data into the template view using the data object
        viewHolder.tvTitle.setText(instrument.getTitle());
        viewHolder.tvDescription.setText(instrument.getDescription());
        int resID = instrument.getId();
        viewHolder.ivAcousticGuitar.setImageResource(resID);
        return convertView;
    }
}