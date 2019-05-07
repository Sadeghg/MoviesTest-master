package model;


import android.os.Handler;

import java.util.ArrayList;


public class MovieInteractor implements Interactor {

    private final static String[] movieNames = {
            "UsualSuspects",
            "TheGame",
            "MaryPoppins"
    };

    private final static String  movieImages[] = {
            "https://images.pexels.com/photos/440731/pexels-photo-440731.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940",
            "https://images.wallpaperscraft.com/image/star_wars_the_force_awakens_main_characters_105940_1280x720.jpg",
            "https://lumiere-a.akamaihd.net/v1/images/marypoppinsreturns_mobile_wallpaper09_eb70678c.jpeg"
    };

    private final static String[] moviePublisher = {
            "https://img.buzzfeed.com/buzzfeed-static/static/enhanced/webdr03/2013/3/11/11/enhanced-buzz-orig-6669-1363014984-24.jpg?downsize=800:*&output-format=auto&output-quality=auto",
            "https://lumiere-a.akamaihd.net/v1/images/marypoppinsreturns_mobile_wallpaper09_eb70678c.jpeg",
            "https://images.wallpaperscraft.com/image/star_wars_darth_vader_anakin_skywalker_99807_1280x720.jpg"
    };


    @Override
    public void loadItems(final LoaderListener loaderListener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loaderListener.onFinished(createCollectionPictures());
            }
        }, 2000);
    }


    private ArrayList<Movie> createCollectionPictures() {




        ArrayList<Movie> movies = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Movie movie = new Movie(movieNames[i], movieImages[i], moviePublisher[i]);
            movies.add(movie);
        }


        return movies;

    }
}
