package com.hack.gymtonic;

/**
 * Created by thepr on 17/10/2015.
 */
public class Dashboard {

    public String name;
    public String stats;
    public String bestName;
    public int cronoImage;
    public int activityImage;

    public Dashboard(String name, String stats, String bestName, int imageActivity, int imageCrono) {

        this.name = name;
        this.stats = stats;
        this.bestName = bestName;
        this.activityImage = imageActivity;
        this.cronoImage = imageCrono;

    }


    public String getName() {

        return name;

    }

    public String getStats() {

        return stats;

    }

    public String getBestName() {

        return bestName;

    }


    public int getActivityImage() {

        return activityImage;

    }

    public int getCronoImage() {

        return cronoImage;

    }






}
