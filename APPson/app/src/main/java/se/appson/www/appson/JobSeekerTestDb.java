package se.appson.www.appson;

import android.media.Image;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by andersolsson on 2017-05-11.
 */

public class JobSeekerTestDb {

    static public ArrayList<Profile> profiles = new ArrayList<Profile>();

    public JobSeekerTestDb () {}
    public JobSeekerTestDb(Profile profile) {
        profiles.add(profile);
    }
}
