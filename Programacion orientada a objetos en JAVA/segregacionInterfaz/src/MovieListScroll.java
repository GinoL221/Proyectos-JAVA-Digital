import java.util.ArrayList;
import java.util.List;

public class MovieListScroll implements OnScrollListener, OnClickListener{

    private List<String> movieList;

    public MovieListScroll() {
        movieList = new ArrayList<>();
    }

    @Override
    public void onScroll() {
        System.out.println("Movie list scrolled");
    }

    @Override
    public void onClick() {
        System.out.println("Movie list clicked");
    }
}
