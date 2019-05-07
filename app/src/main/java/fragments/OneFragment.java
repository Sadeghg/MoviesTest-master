package fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.moviestest.R;

import java.util.ArrayList;

import adapter.MoviesAdapterActual;
import butterknife.BindView;
import butterknife.ButterKnife;
import model.Movie;
import presenter.MoviePresenter;
import presenter.RecyclerItemClickListener;
import view.MovieMvpView;


public class OneFragment extends BaseFragment
        implements MovieMvpView, RecyclerItemClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private MoviePresenter moviePresenter;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    RecyclerView.Adapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_base;

    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return getLinearLayoutManager();
    }

    @Override
    protected RecyclerView.Adapter getAdapter(ArrayList<Movie> moviesList) {
        return new MoviesAdapterActual(moviesList, R.layout.layout_main_feeed);
    }


    private LinearLayoutManager getLinearLayoutManager() {
        return new LinearLayoutManager(
                getActivity(),
                LinearLayoutManager.VERTICAL,
                false);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, rootView);

        moviePresenter = new MoviePresenter();
        moviePresenter.attachedView(this);
        setupRecyclerView();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        moviePresenter.onResume();
    }

    @Override
    public void setItems(ArrayList<Movie> pictureList) {
        adapter = getAdapter(pictureList);
        recyclerView.setAdapter(adapter);

        if(adapter instanceof MoviesAdapterActual) {


            ((MoviesAdapterActual) adapter).setRecyclerItemClickListener(this);
            Toast.makeText(getContext(), "Noice", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(getContext(), "Boom!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        moviePresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void onItemClickListener(int position) {
        moviePresenter.onItemSelected(position);}


    private void setupRecyclerView() {

        if(getLayoutManager() != null)
            recyclerView.setLayoutManager(getLayoutManager());

        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
