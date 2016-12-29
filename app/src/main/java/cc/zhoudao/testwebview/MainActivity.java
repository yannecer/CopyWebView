package cc.zhoudao.testwebview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener, NWebView.OnGetSelectTextListener {
    private NWebView nwebview;
    private String url = "http://gank.io/post/560e15be2dca930e00da1083";
    private ActionMode mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        nwebview = (NWebView) findViewById(R.id.nwebview);
        nwebview.loadUrl(url);
        nwebview.setOnGetSelectTextListener(this);


    }

    @Override
    public void onActionModeStarted(final ActionMode mode) {
        this.mode = mode;
        Menu menu = mode.getMenu();
        menu.clear();
        getMenuInflater().inflate(R.menu.menu, menu);
        for (int i = 0; i < menu.size(); i++) {
            menu.getItem(i).setOnMenuItemClickListener(this);
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu0:
                nwebview.getSelectText();

                break;
            case R.id.menu1:
                break;
            //...

        }
        mode.finish();
        return true;
    }

    @Override
    public void getSelectText(String text) {
         Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }
}
