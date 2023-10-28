package gigi.myauto;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import gigi.myauto.models.Offer;

public class NewOfferActivity extends AppCompatActivity {

    private Button placeOfferBtn;
    private DBHandler dbHandler;
    private CheckBox cruiseControl, abs, aircon, fourxfour, power_windows, system_monitor, power_door_locks, mp3_player, analog_display, air_filtration, chrome_bodyside_insert, rear_spoiler, bluetooth, stereo;

    private ImageView offerImageView;
    private TextInputLayout priceLay, colorLay, modelLay, engineLay, mileageLay, short_descriptionLay;
    private EditText price;
    private EditText color;
    private EditText model;
    private EditText engine;
    private EditText mileage;
    private EditText drivetrain;
    private EditText short_description;
    private String imagePath;

    private static final int IMAGE_REQUEST_CODE = 100;
    private static final int STORAGE_PERMISSION_RC = 200;

    private Offer offer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_offer);

        init();
        offer = new Offer();


        if (ActivityCompat.checkSelfPermission(NewOfferActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(NewOfferActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_RC);
        }


        drivetrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    Dialog dialog = new Dialog(NewOfferActivity.this);
                    dialog.setTitle("Select");
                    dialog.show();



                    final Dialog drivetrainDialog = new Dialog(NewOfferActivity.this);
                    View layout = LayoutInflater.from(NewOfferActivity.this).inflate(R.layout.dialog_layout, null);
                    drivetrainDialog.setContentView(layout);
                    Button rwdbtn = (Button)(layout.findViewById(R.id.rwd));
                    Button fwdbtn = (Button)(layout.findViewById(R.id.fwd));
                    final Button awdbtn = (Button)(layout.findViewById(R.id.awd));

                    rwdbtn.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v) {
                            drivetrain.setText("RWD");
                            drivetrainDialog.dismiss();
                        }
                    });
                drivetrainDialog.show();

                    fwdbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            drivetrain.setText("FWD");
                            drivetrainDialog.dismiss();
                        }
                    });
                drivetrainDialog.show();

                    awdbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            drivetrain.setText("AWD");
                            drivetrainDialog.dismiss();
                        }
                    });
                drivetrainDialog.show();


            }
        });



        cruiseControl = (CheckBox) findViewById(R.id.cruise_control);
        abs = (CheckBox) findViewById(R.id.abs);
        aircon = (CheckBox) findViewById(R.id.aircon);
        fourxfour = (CheckBox) findViewById(R.id.fourxfour);
        power_windows = (CheckBox) findViewById(R.id.power_windows);
        system_monitor = (CheckBox) findViewById(R.id.system_monitor);
        power_door_locks = (CheckBox) findViewById(R.id.power_door_locks);
        mp3_player = (CheckBox) findViewById(R.id.mp3_player);
        analog_display = (CheckBox) findViewById(R.id.analog_display);
        air_filtration = (CheckBox) findViewById(R.id.air_filtration);
        chrome_bodyside_insert = (CheckBox) findViewById(R.id.chrome_bodyside_insert);
        rear_spoiler = (CheckBox) findViewById(R.id.rearSpoiler);
        bluetooth = (CheckBox) findViewById(R.id.bluetooth_connection);
        stereo = (CheckBox) findViewById(R.id.stereo);

        offerImageView = (ImageView) findViewById(R.id.offer_image);
        offerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, IMAGE_REQUEST_CODE);
            }
        });


        dbHandler = new DBHandler(this);

        placeOfferBtn = (Button) findViewById(R.id.place_offer_btn);
        placeOfferBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String color1 = color.getText().toString();
                double price1 = Double.parseDouble(price.getText().toString());
                String model1 = model.getText().toString();
                String engine1 = engine.getText().toString();
                String mileage1 = mileage.getText().toString();
                String drivetrain1 = drivetrain.getText().toString();
                String description = short_description.getText().toString();



                offer.setAbs(abs.isChecked() ? 1 : 0);
                offer.setAircon(aircon.isChecked() ? 1 : 0);
                offer.setFourxfour(fourxfour.isChecked() ? 1 : 0);
                offer.setPower_windows(power_windows.isChecked() ? 1 : 0);
                offer.setCruise_control(cruiseControl.isChecked() ? 1 : 0);
                offer.setSystem_monitor(system_monitor.isChecked() ? 1 : 0);
                offer.setPower_door_locks(power_door_locks.isChecked() ? 1 : 0);
                offer.setMp3_player(mp3_player.isChecked() ? 1 : 0);
                offer.setAnalog_display(analog_display.isChecked() ? 1 : 0);
                offer.setAir_filtration(air_filtration.isChecked() ? 1 : 0);
                offer.setChrome_bodysided_insert(chrome_bodyside_insert.isChecked() ? 1 : 0);
                offer.setRear_spoiler(rear_spoiler.isChecked() ? 1 : 0);
                offer.setBluetooth(bluetooth.isChecked() ? 1 : 0);
                offer.setStereo(stereo.isChecked() ? 1 : 0);


                offer.setColor(color1);
                offer.setDescription(description);
                offer.setDrivetrain(drivetrain1);
                offer.setMileage(mileage1);
                offer.setModel(model1);
                offer.setEngine(engine1);
                offer.setPrice((int) price1);


                dbHandler.addNewOffer(offer);

                startActivity(new Intent(NewOfferActivity.this, MainActivity.class));

            }
        });
    }

    private void init() {

        price = (EditText) findViewById(R.id.price_et);
        color = (EditText) findViewById(R.id.color_et);
        model = (EditText) findViewById(R.id.model_et);
        engine = (EditText) findViewById(R.id.engine_et);
        mileage = (EditText) findViewById(R.id.mileage_et);
        drivetrain = (EditText) findViewById(R.id.drivetrain_et);
        short_description = (EditText) findViewById(R.id.short_description_et);






        priceLay = (TextInputLayout) findViewById(R.id.price_layout);
        colorLay = (TextInputLayout) findViewById(R.id.Color_layout);
        modelLay = (TextInputLayout) findViewById(R.id.model_layout);
        engineLay = (TextInputLayout) findViewById(R.id.engine_layout);
        mileageLay = (TextInputLayout) findViewById(R.id.mileage_layout);
        short_descriptionLay = (TextInputLayout) findViewById(R.id.description_layout);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imagePath = cursor.getString(columnIndex);
                cursor.close();
                // Set the Image in ImageView after decoding the String
                offerImageView.setImageBitmap(BitmapFactory
                        .decodeFile(imagePath));

                offer.setImage(imagePath);

            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }
    }
}
