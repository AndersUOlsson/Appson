package se.appson.www.appson;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by andersolsson on 2017-05-11.
 */

public class Profile {

    private String name;
    private String occupation;
    private String description;
    private Bitmap profileImage;
    private int views;
    private boolean like;


    /**
     * Constructor of job-seeker
     * @param name of job-seeker
     * @param occupation of job-seeker
     * @param description of job-seeker
     * @param profileImage of job-seeker
     */
    public Profile(String name, String occupation, String description,Bitmap profileImage) {
        this.name = name;
        this.occupation = occupation;
        this.description = description;
        this.profileImage = profileImage;
        this.views = 0;
        this.like = false;
    }

    /**
     * Gets name of job-seeker.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of job-seeker.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get occupation of job-seeker.
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * Set occupation of job-seeker.
     * @param occupation the occupation to set
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * Get description of job-seeker.
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description of job-seeker.
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get image of job-seeker.
     * @return the profileImage
     */
    public Bitmap getProfileImage() {
        return profileImage;
    }

    /**
     * Set image of job-seeker.
     * @param profileImage the profileImage to set
     */
    public void setProfileImage(Bitmap profileImage) {
        this.profileImage = profileImage;
    }

    /**
     * Increase views by 1, when profiled has been viewed.
     */
    public void setView() {
        this.views++;
    }

    /**
     * Get info about how many people has view profile
     * @return views
     */
    public int getView() {
        return this.views;
    }

    /**
     * job-seeker profile to string.
     */
    @Override
    public String toString() {
        return "Profile [name=" + name + ", occupation=" + occupation + ", description=" + description + ", profileImage="
                + profileImage + "]";
    }
}
