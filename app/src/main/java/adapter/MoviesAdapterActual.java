package adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.moviestest.R;

import java.util.ArrayList;


import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import model.Movie;
import presenter.RecyclerItemClickListener;


public class MoviesAdapterActual extends RecyclerView.Adapter<MoviesAdapterActual.ExampleHolder> {

    private ArrayList<Movie> movieList;
    private int itemLayout;
    private RecyclerItemClickListener recyclerItemClickListener;

    public void setRecyclerItemClickListener(RecyclerItemClickListener recyclerItemClickListener) {
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    public MoviesAdapterActual(ArrayList<Movie> movieList, int itemLayout) {
        this.movieList = movieList;
        this.itemLayout = itemLayout;
    }

    @NonNull
    @Override
    public ExampleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ExampleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ExampleHolder holder, final int position) {
        final Movie picture = movieList.get(position);
        holder.title.setText(picture.getName());
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);
        Glide.with(holder.imageView.getContext())
                .asBitmap()
                .load(picture.getImage())
                .apply(requestOptions)
                .into(holder.imageView);
        Glide.with(holder.publisher.getContext())
                .asBitmap()
                .load(picture.getImage())
                .apply(requestOptions)
                .into(holder.publisher);
    }


    @Override
    public int getItemCount() {
        return movieList.size();
    }


    public class ExampleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
         @BindView(R.id.movie_name) TextView title;
        @BindView(R.id.movie_cover) ImageView imageView;
        @BindView(R.id.movie_publisher) CircleImageView publisher;

        ExampleHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (recyclerItemClickListener != null)
                recyclerItemClickListener.onItemClickListener(getAdapterPosition());
        }
    }


}
