package gigi.myauto;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import gigi.myauto.models.Offer;


/**
 * A simple {@link Fragment} subclass.
 */
public class OfferListFragment extends Fragment {

    private ListView listView;
    private static List<Offer> carList = new ArrayList<>();
    private static OfferListAdapter offerListAdapter;
    private DBHandler dbHandler;



    public OfferListFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        
        View view = inflater.inflate(R.layout.fragment_offer_list, container, false);

        dbHandler = new DBHandler(getActivity());
        listView = (ListView) view.findViewById(R.id.list_VIew);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                deletedialog(position);
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("Position: ", String.valueOf(position));


                Offer offer = carList.get(position);

                Intent i = new Intent(getActivity(), SeeMore.class);
                i.putExtra("offer", offer);
                startActivity(i);


            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Log.e("scrollState", "" +scrollState);
                if (scrollState > 0) {
                    ((MainActivity)getActivity()).hideFab();
                } else {
                    ((MainActivity)getActivity()).showFab();
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        new getOfferDataSync().execute();
    }

    class getOfferDataSync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            carList = dbHandler.getOffers();

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            offerListAdapter = new OfferListAdapter(getActivity(), carList);
            listView.setAdapter(offerListAdapter);

            offerListAdapter.notifyDataSetChanged();
        }
    }

    private void deletedialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Delete");
        builder.setMessage("Are You Sure You Want To Delete This Item?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Offer offer = carList.get(position);
                dbHandler.delete(offer.getId());
                carList.remove(position);
                offerListAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alert  = builder.create();
        alert.show();
    }

    public static void sortByPrice() {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getPrice() > carList.get(i+1).getPrice()) {
                carList.add(carList.get(i));
            }
        }

        offerListAdapter.notifyDataSetChanged();
    }

    public static List<Offer> getOffers() {
        return carList;
    }

    public static void notifyDataSetChangedOffers() {
        offerListAdapter.notifyDataSetChanged();
    }
}
