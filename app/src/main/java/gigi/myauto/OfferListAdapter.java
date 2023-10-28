package gigi.myauto;

import android.app.Service;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import gigi.myauto.models.Offer;

/**
 * Created by UGLemondoTrainings on 5/3/16.
 */
public class OfferListAdapter extends BaseAdapter {

    private List<Offer> offerList;
    private Context context;
    private LayoutInflater inflater;

    public OfferListAdapter(Context context, List<Offer> offerList) {
        this.context = context;
        this.offerList = offerList;
    }

    @Override
    public int getCount() {
        Log.e("getCount: ", String.valueOf(offerList.size()));
        return offerList.size();
    }

    @Override
    public Object getItem(int position) {
        return offerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
            convertView = inflater.inflate(R.layout.offer_list_item, null);

        TextView modelTv = (TextView) convertView.findViewById(R.id.model_tv);
        TextView colorTv = (TextView) convertView.findViewById(R.id.color_tv);
        TextView price = (TextView) convertView.findViewById(R.id.textView16);
        ImageView carImage = (ImageView) convertView.findViewById(R.id.offer_image_view);

        Offer offer = offerList.get(position);
        modelTv.setText(offer.getModel());
        colorTv.setText("Color: " + offer.getColor());
        price.setText("$" + String.valueOf(offer.getPrice()));

        String image_path = offer.getImage();


        carImage.setImageBitmap(BitmapFactory.decodeFile(image_path));






        return convertView;
    }
}
