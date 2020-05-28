import android.widget.ArrayAdapter;
import com.example.instrument_app.R;
import java.util.ArrayList;
import java.util.Arrays;

public class InstrumentAdapter extends ArrayAdapter<Instrument> {
    public InstrumentAdapter(Context context, ArrayList<AcousticGuitar> acousticGuitars){
        super(context, 0, acousticGuitars);
    }

    //translates a particular 'Book' given a position
    // into a relevant row within an AdapterView
    // @Override
    // public View getView(int position,
    // View convertView, ViewGroup parent){
    // TODO: Complete the definition of the view for each book
    //  return null;
    //  }
}
