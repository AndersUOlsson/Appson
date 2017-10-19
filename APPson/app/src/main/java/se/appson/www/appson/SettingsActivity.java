package se.appson.www.appson;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import java.io.File;
import java.io.IOException;


public class SettingsActivity extends Activity {

    private EditText profileName;
    private EditText profileEmail;
    private EditText profilePhone;
    private EditText decsripte;
    private Spinner kategori;
    private Spinner places;
    private ImageView profileImageView;
    public ImageView imageView;
    private Bitmap bitmap;
    private Drawable d;


    private static final int SELECT_PHOTO = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        this.profileName = (EditText) findViewById(R.id.profileName);
        this.profileEmail = (EditText) findViewById(R.id.Epost);
        this.profilePhone = (EditText) findViewById(R.id.Phone);
        this.decsripte = (EditText) findViewById(R.id.DescriptionEditText);
        this.kategori = (Spinner) findViewById(R.id.kategoriSpinner);
        this.places = (Spinner) findViewById(R.id.spinnerPlace);
        this.profileImageView = (ImageView) findViewById(R.id.profileImage1);


        // Kategori spinner
        ArrayAdapter<CharSequence> adapterCategori = ArrayAdapter.createFromResource(this,
                R.array.kategori, android.R.layout.simple_spinner_item);

        adapterCategori.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kategori.setAdapter(adapterCategori);

        //Place spinner
        ArrayAdapter<CharSequence> adapterPlace = ArrayAdapter.createFromResource(this,
                R.array.place_array, android.R.layout.simple_spinner_item);

        adapterPlace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        places.setAdapter(adapterPlace);
    }



    /**
     * Name of the profile.
     * @return name.
     */
    public String GetProfileName() {
        return this.profileName.toString();
    }

    /**
     * Epost of the profile.
     * @return Epost.
     */
    public String  GetProfileEmail() {
        return this.profileEmail.toString();
    }

    public String GetProfilePhone() {
        return this.profilePhone.toString();
    }

    /**
     * Display the home page.
     * @param view
     */
    public void backToHomePage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void saveProfile(View view) {

        Profile newProfile = new Profile(
                profileName.getText().toString(),
                this.kategori.toString(),
                decsripte.getText().toString(),
                this.bitmap);

        JobSeekerTestDb jobSeekerTestDb = new JobSeekerTestDb(newProfile);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Opens galleri in phone.
     * @param view
     */
    public void imageSelect(View view) {

        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);

        // where do we want to find the data?
        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pictureDirectoryPath = pictureDirectory.getPath();
        // finally, get a URI representation
        Uri data = Uri.parse(pictureDirectoryPath);

        // set the data and type.  Get all image types.
        photoPickerIntent.setDataAndType(data, "image/*");

        // we will invoke this activity, and get something back from it.
        startActivityForResult(photoPickerIntent, SELECT_PHOTO);
    }

    /**
     * Setting the selected image to imageView for profile
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SELECT_PHOTO && resultCode == RESULT_OK && data != null) {
            Uri pickedImage = data.getData();
            String[] filePath = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(pickedImage, filePath, null, null, null);
            cursor.moveToFirst();

            try{
                this.bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), pickedImage);
                this.profileImageView.setImageBitmap(bitmap);
            }
            catch(IOException e) {
                e.printStackTrace();
            }

            cursor.close();
        }
    }

    public Bitmap getBitmap() {return this.bitmap;}
}
