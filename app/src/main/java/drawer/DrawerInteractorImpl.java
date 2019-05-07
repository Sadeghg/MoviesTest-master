package drawer;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.example.moviestest.R;

public class DrawerInteractorImpl implements DrawerInteractor {

    @Override
    public void navigateTo(MenuItem item, DrawerLayout drawerLayout, DrawerListener listener) {
        switch (item.getItemId()) {
            case R.id.nav_gallery:
//                Do something
                break;
            case R.id.nav_slideshow:
//                Do something
                break;
            case R.id.nav_manage:
//                Do something
                break;
            case R.id.nav_share:
//                Do something
                break;
            case R.id.nav_send:
//                Do something
                break;
            case R.id.nav_camera:
//                Do something
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);

    }
}