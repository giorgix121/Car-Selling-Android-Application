package gigi.myauto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.camera2.CaptureResult;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import gigi.myauto.models.*;
import gigi.myauto.models.Offer;


public class DBHandler extends SQLiteOpenHelper {



    public DBHandler(Context context) {
        super(context, "SQLite", null, 1);
    }

    private static final String TABLE_OFFERS = "offers";
    private static final String TABLE_USERS = "users";

    private static final String KEY_ID = "id";
    private static final String KEY_MODEL = "model";
    private static final String KEY_COLOR = "color";
    private static final String KEY_ENGINE = "engine";
    private static final String KEY_MILEAGE = "Mileage";
    private static final String KEY_DRIVETRAIN = "drivetrain";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_PRICE = "price";
    private static final String KEY_REAR_SPOILER = "rear_spoiler";
    private static final String KEY_STEREO = "stereo";
    private static final String KEY_BLUETOOTH = "bluetooth";
    private static final String KEY_CHROME_BODYSIDE_INSERT = "chrome_bodyside_insert";
    private static final String KEY_AIR_FILTRATION = "air_filtration ";
    private static final String KEY_ANALOG_DISPLAY = "analog_display";
    private static final String KEY_MP3_PLAYER = "mp3_player";
    private static final String KEY_ABS = "abs";
    private static final String KEY_AIRCON = "aircon";
    private static final String KEY_4X4 = "awd";
    private static final String KEY_POWER_WINDOWS = "power_windows";
    private static final String KEY_CRUISE_CONTROL = "cruise_control";
    private static final String KEY_SYSTEM_MONITOR = "system_monitor";
    private static final String KEY_POWER_DOOR_LOCKS = "power_door_locks";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGE = "image";
    private final ArrayList<Offer> offerList = new ArrayList<Offer>();





    private static final String KEY_USER_FIRST_NAME = "first_name";
    private static final String KEY_USER_LAST_NAME = "last_name";
    private static final String KEY_USER_PASSWORD = "password";
    private static final String KEY_USER_PHONE = "phone";
    private final ArrayList<User> contactsList = new ArrayList<User>();




    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_OFFERS_TABLE = "CREATE TABLE " + TABLE_OFFERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_IMAGE + " TEXT,"
                + KEY_MODEL + " TEXT,"
                + KEY_COLOR + " TEXT,"
                + KEY_PRICE + " TEXT,"
                + KEY_DESCRIPTION + " TEXT,"
                + KEY_MILEAGE + " TEXT,"
                + KEY_DRIVETRAIN + " TEXT,"
                + KEY_REAR_SPOILER + " TEXT,"
                + KEY_STEREO + " TEXT,"
                + KEY_BLUETOOTH + " TEXT,"
                + KEY_CHROME_BODYSIDE_INSERT + " TEXT,"
                + KEY_AIR_FILTRATION + " TEXT,"
                + KEY_ANALOG_DISPLAY + " TEXT,"
                + KEY_MP3_PLAYER + " TEXT,"
                + KEY_ABS + " TEXT,"
                + KEY_AIRCON + " TEXT,"
                + KEY_4X4 + " TEXT,"
                + KEY_POWER_WINDOWS + " TEXT,"
                + KEY_CRUISE_CONTROL + " TEXT,"
                + KEY_SYSTEM_MONITOR + " TEXT,"
                + KEY_POWER_DOOR_LOCKS + " TEXT,"
                + KEY_ENGINE + " TEXT" + ")";

        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_USER_FIRST_NAME + " TEXT,"
                + KEY_USER_LAST_NAME + " TEXT,"
                + KEY_USER_PASSWORD + " TEXT,"
                + KEY_USER_PHONE + " TEXT" + ")";


        db.execSQL(CREATE_OFFERS_TABLE);
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OFFERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        onCreate(db);
    }


    public ArrayList<Offer> getOffers() {
        ArrayList<Offer> offerList = new ArrayList<>();
        try {
            String selectQuery = "SELECT * FROM " + TABLE_OFFERS;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);


            if (cursor.moveToFirst()) {
                do {
                    Offer offer = new Offer();
                    offer.setId(cursor.getInt(0));
                    offer.setImage(cursor.getString(1));
                    offer.setModel(cursor.getString(2));
                    offer.setColor(cursor.getString(3));
                    offer.setPrice((cursor.getInt(4)));
                    offer.setDescription(cursor.getString(5));
                    offer.setMileage(cursor.getString(6));
                    offer.setDrivetrain(cursor.getString(7));
                    offer.setRear_spoiler(cursor.getInt(8));
                    offer.setStereo(cursor.getInt(9));
                    offer.setBluetooth(cursor.getInt(10));
                    offer.setChrome_bodysided_insert(cursor.getInt(11));
                    offer.setAir_filtration(cursor.getInt(12));
                    offer.setAnalog_display(cursor.getInt(13));
                    offer.setMp3_player(cursor.getInt(14));
                    offer.setAbs(cursor.getInt(15));
                    offer.setAircon(cursor.getInt(16));
                    offer.setFourxfour(cursor.getInt(17));
                    offer.setPower_windows(cursor.getInt(18));
                    offer.setCruise_control(cursor.getInt(19));
                    offer.setSystem_monitor(cursor.getInt(20));
                    offer.setPower_door_locks(cursor.getInt(21));
                    offer.setEngine(cursor.getString(22));

                    offerList.add(offer);
                } while (cursor.moveToNext());
            }


            cursor.close();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return offerList;
    }


    public boolean login(String name, String password) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_USERS,
                new String[]{KEY_ID, KEY_USER_FIRST_NAME, KEY_USER_LAST_NAME, KEY_USER_PHONE, KEY_USER_PASSWORD},
                "first_name=? AND password=?",
                new String[]{name, password},
                null,
                null,
                null,
                null
        );
        if (cursor != null)
            cursor.moveToFirst();


        return cursor.moveToFirst();
    }



    public void register(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USER_FIRST_NAME, user.getFirstName());
        values.put(KEY_USER_LAST_NAME, user.getLastName());
        values.put(KEY_USER_PASSWORD, user.getPassword());
        values.put(KEY_USER_PHONE, user.getPhone());

        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    public void addNewOffer(Offer offer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_COLOR, offer.getColor());
        values.put(KEY_PRICE , offer.getPrice());
        values.put(KEY_MODEL, offer.getModel());
        values.put(KEY_DRIVETRAIN, offer.getDrivetrain());
        values.put(KEY_ENGINE, offer.getEngine());
        values.put(KEY_MILEAGE, offer.getMileage());
        values.put(KEY_DESCRIPTION, offer.getDescription());
        values.put(KEY_IMAGE, offer.getImage());


        values.put(KEY_ABS, offer.getAbs());
        values.put(KEY_AIRCON, offer.getAircon());
        values.put(KEY_4X4, offer.getFourxfour());
        values.put(KEY_POWER_WINDOWS, offer.getPower_windows());
        values.put(KEY_CRUISE_CONTROL, offer.getCruise_control());
        values.put(KEY_SYSTEM_MONITOR, offer.getSystem_monitor());
        values.put(KEY_POWER_DOOR_LOCKS, offer.getPower_door_locks());
        values.put(KEY_MP3_PLAYER, offer.getMp3_player());
        values.put(KEY_ANALOG_DISPLAY, offer.getAnalog_display());
        values.put(KEY_AIR_FILTRATION, offer.getAir_filtration());
        values.put(KEY_CHROME_BODYSIDE_INSERT, offer.getChrome_bodysided_insert());
        values.put(KEY_REAR_SPOILER, offer.getRear_spoiler());
        values.put(KEY_BLUETOOTH, offer.getBluetooth());
        values.put(KEY_STEREO, offer.getStereo());



        db.insert(TABLE_OFFERS, null, values);
        db.close();
    }
    public void delete(int id) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_OFFERS, KEY_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();


    }
}


