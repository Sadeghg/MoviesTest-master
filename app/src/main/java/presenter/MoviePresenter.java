package presenter;

import java.util.ArrayList;

import model.LoaderListener;
import model.Movie;
import model.MovieInteractor;
import view.MovieMvpView;

public class MoviePresenter implements Presenter<MovieMvpView>, LoaderListener {

    private MovieMvpView movieMvpView;
    private final MovieInteractor movieInteractor;

    public MoviePresenter() {
        movieInteractor = new MovieInteractor();
    }


    @Override
    public void onFinished(ArrayList<Movie> movieList) {
        movieMvpView.setItems(movieList);
        movieMvpView.hideProgress();
    }

    @Override
    public void attachedView(MovieMvpView view) {
        if (view == null)
            throw new IllegalArgumentException("You can't set a null view");

        movieMvpView = view;
    }

    @Override
    public void detachView() {
        movieMvpView = null;
    }

    @Override
    public void onResume() {
        movieMvpView.showProgress();
        movieInteractor.loadItems(this);
    }

    @Override
    public void onItemSelected(int position) {
        movieMvpView.showMessage(Integer.toString(position));
    }
}
