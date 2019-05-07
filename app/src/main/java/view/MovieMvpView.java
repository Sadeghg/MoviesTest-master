package view;

import java.util.ArrayList;

import model.Movie;


public interface MovieMvpView {

    void setItems(ArrayList<Movie> movieList);

    void showProgress();

    void hideProgress();


    void showMessage(String message);

}
