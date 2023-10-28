package gigi.myauto;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;
import java.net.URL;

import gigi.myauto.models.Offer;
import gigi.myauto.models.User;

public class SeeMore extends AppCompatActivity {

    private ImageView car_image_view, abs_tick, abs_cross, aircon_tick, aircon_cross, fourxfour_tick, fourxfour_cross, power_windows_tick, power_windows_cross, cruise_control_tick, cruise_control_cross, system_monitor_tick, system_monitor_cross, power_door_locks_tick, power_door_locks_cross, mp3_player_tick, mp3_player_cross, analog_display_tick, analog_display_cross, air_filtration_tick, air_filtration_cross, chrome_bodysisde_insert_tick, chrome_bodyside_insert_cross, rear_spoiler_tick, rear_spoiler_cross, bluetooth_tick, bluetooth_cross, stereo_tick, stereo_cross;

    private TextView price_tv, model_tv, color_tv, engine_tv, mileage_tv, drivetrain_tv, description;

    private Button phone_button, mailbutton;

    private TextView phonetv, mailtv;

    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.see_more);



        Intent i = getIntent();

        final Offer offer = (Offer) i.getSerializableExtra("offer");
        Log.e("Offer", offer.getModel());

        phone_button = (Button) findViewById(R.id.phonebutton);
        phonetv = (TextView) findViewById(R.id.phonebuttontv);
        mailbutton = (Button) findViewById(R.id.mailbutton);
        mailtv = (TextView) findViewById(R.id.mailtv);

        price_tv = (TextView) findViewById(R.id.price);
        model_tv = (TextView) findViewById(R.id.model_tv);
        color_tv = (TextView) findViewById(R.id.color_tv);
        engine_tv = (TextView) findViewById(R.id.engine_tv);
        mileage_tv = (TextView) findViewById(R.id.mileage_tv);
        drivetrain_tv = (TextView) findViewById(R.id.drivetrain_tv);
        description = (TextView) findViewById(R.id.short_description_tv);

        abs_tick = (ImageView) findViewById(R.id.abs_iv_tick);
        abs_cross = (ImageView) findViewById(R.id.abs_iv_cross);
        aircon_tick = (ImageView) findViewById(R.id.airocn_iv_tick);
        aircon_cross = (ImageView) findViewById(R.id.aircon_iv_cross);
        fourxfour_tick = (ImageView) findViewById(R.id.fourxfour_iv_tick);
        fourxfour_cross = (ImageView) findViewById(R.id.fourxfour_iv_cross);
        power_windows_tick = (ImageView) findViewById(R.id.power_windows_tick);
        power_windows_cross = (ImageView) findViewById(R.id.power_windows_iv_cross);
        cruise_control_tick = (ImageView) findViewById(R.id.cruise_control_tick);
        cruise_control_cross = (ImageView) findViewById(R.id.cruise_control_iv_cross);
        system_monitor_tick = (ImageView) findViewById(R.id.system_monitor_tick);
        system_monitor_cross = (ImageView) findViewById(R.id.system_monitor_cross);
        power_door_locks_tick = (ImageView) findViewById(R.id.power_door_locks_tick);
        power_door_locks_cross = (ImageView) findViewById(R.id.power_door_locks_cross);
        mp3_player_tick = (ImageView) findViewById(R.id.mp3_player_tick);
        mp3_player_cross = (ImageView) findViewById(R.id.mp3_player_cross);
        analog_display_tick = (ImageView) findViewById(R.id.analog_display_tick);
        analog_display_cross = (ImageView) findViewById(R.id.analog_display_cross);
        air_filtration_tick = (ImageView) findViewById(R.id.air_filtration_tick);
        air_filtration_cross = (ImageView) findViewById(R.id.air_filtration_cross);
        chrome_bodysisde_insert_tick = (ImageView) findViewById(R.id.chrome_bodyside_insert_tick);
        chrome_bodyside_insert_cross = (ImageView) findViewById(R.id.chrome_bodyside_insert_cross);
        rear_spoiler_tick = (ImageView) findViewById(R.id.rear_spoiler_tick);
        rear_spoiler_cross = (ImageView) findViewById(R.id.rear_spoiler_cross);
        bluetooth_tick = (ImageView) findViewById(R.id.bluetooth_tick);
        bluetooth_cross = (ImageView) findViewById(R.id.bluetooth_cross);
        stereo_tick = (ImageView) findViewById(R.id.stereo_tick);
        stereo_cross = (ImageView) findViewById(R.id.stereo_cross);
        car_image_view = (ImageView) findViewById(R.id.car_image_view);





        if (offer.getAbs() == 1) {
            abs_tick.setVisibility(View.VISIBLE);
        }else {
            abs_cross.setVisibility(View.VISIBLE);
        }


        if (offer.getAircon() == 1) {
            aircon_tick.setVisibility(View.VISIBLE);
        }else {
            aircon_cross.setVisibility(View.VISIBLE);
        }


        if (offer.getFourxfour() == 1) {
            fourxfour_tick.setVisibility(View.VISIBLE);
        }else {
            fourxfour_cross.setVisibility(View.VISIBLE);
        }

        if (offer.getPower_door_locks() == 1) {
            power_door_locks_tick.setVisibility(View.VISIBLE);
        }else {
            power_door_locks_cross.setVisibility(View.VISIBLE);
        }

        if (offer.getCruise_control() == 1) {
            cruise_control_tick.setVisibility(View.VISIBLE);
        }else {
            cruise_control_cross.setVisibility(View.VISIBLE);
        }

        if (offer.getSystem_monitor() == 1) {
            system_monitor_tick.setVisibility(View.VISIBLE);
        }else {
            system_monitor_cross.setVisibility(View.VISIBLE);
        }


        if (offer.getPower_door_locks() == 1) {
            power_door_locks_tick.setVisibility(View.VISIBLE);
        }else {
            power_door_locks_cross.setVisibility(View.VISIBLE);
        }


        if (offer.getMp3_player() == 1) {
            mp3_player_tick.setVisibility(View.VISIBLE);
        }else {
            mp3_player_cross.setVisibility(View.VISIBLE);
        }


        if (offer.getAnalog_display() == 1) {
            analog_display_tick.setVisibility(View.VISIBLE);
        }else {
            analog_display_cross.setVisibility(View.VISIBLE);
        }


        if (offer.getAir_filtration() == 1) {
            air_filtration_tick.setVisibility(View.VISIBLE);
        }else {
            air_filtration_cross.setVisibility(View.VISIBLE);
        }


        if (offer.getChrome_bodysided_insert() == 1) {
            chrome_bodysisde_insert_tick.setVisibility(View.VISIBLE);
        }else {
            chrome_bodyside_insert_cross.setVisibility(View.VISIBLE);
        }


        if (offer.getRear_spoiler() == 1) {
            rear_spoiler_tick.setVisibility(View.VISIBLE);
        }else {
            rear_spoiler_cross.setVisibility(View.VISIBLE);
        }



        if (offer.getBluetooth() == 1) {
            bluetooth_tick.setVisibility(View.VISIBLE);
        }else {
            bluetooth_cross.setVisibility(View.VISIBLE);
        }

        if (offer.getStereo() == 1) {
            stereo_tick.setVisibility(View.VISIBLE);
        }else {
            stereo_cross.setVisibility(View.VISIBLE);
        }

        if (offer.getPower_windows() == 1) {
            power_windows_tick.setVisibility(View.VISIBLE);
        }else {
            power_windows_cross.setVisibility(View.VISIBLE);
        }

        phonetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone = user.getPhone();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });


        phone_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone = user.getPhone();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);


            }
        });

        mailbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String to = user.getLastName();
                String subject = "Car";

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);

                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });

        mailtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String to = user.getLastName();
                String subject = "Car";

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);

                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });





        price_tv.setText("Price: " + "$" + String.valueOf(offer.getPrice()));
        model_tv.setText("Model: " + offer.getModel());
        color_tv.setText("Color: " + offer.getColor());
        engine_tv.setText("Engine: " +offer.getEngine());
        mileage_tv.setText("Mileage: " + offer.getMileage());
        drivetrain_tv.setText("Drivetrain: " + offer.getDrivetrain());
        description.setText(offer.getDescription());

        String image_path = offer.getImage();

        car_image_view.setImageBitmap(BitmapFactory
                .decodeFile(image_path));

    }
}



