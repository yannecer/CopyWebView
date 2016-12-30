package cc.zhoudao.testwebview;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by necer on 2016/12/27.
 */

public class NWebView extends WebView  {

    public NWebView(Context context) {
        super(context);
        init();
    }

    public NWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {

        WebSettings setting = getSettings();
        setting.setJavaScriptEnabled(true);
        setting.setJavaScriptCanOpenWindowsAutomatically(true);
        addJavascriptInterface(new JS(), "aa");


    }

    public void getSelectText() {
        loadUrl("javascript:window.aa.getSelect(window.getSelection().toString());");
    }


    public class JS {
        @JavascriptInterface
        public void getSelect(String selectText) {
            if (onGetSelectTextListener != null) {
                onGetSelectTextListener.getSelectText(selectText);
            }
        }

    }

    private OnGetSelectTextListener onGetSelectTextListener;
    public interface OnGetSelectTextListener {
        void getSelectText(String text);
    }
    public void setOnGetSelectTextListener(OnGetSelectTextListener onGetSelectTextListener) {
        this.onGetSelectTextListener = onGetSelectTextListener;
    }



}
