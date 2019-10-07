package vn.mac.gnam.tuvi2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ResultActivity extends AppCompatActivity {
    private WebView webviewResult;
    String str;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();
    }

    private void init() {
        webviewResult = (WebView) findViewById(R.id.webview_result);
        Intent intent = getIntent();
        str = intent.getStringExtra("nam");
        String strNam = str.replace("Nam", "nam");
        String strNu = strNam.replace("Nữ", "nu");
        url = strNu + ".html";
        Log.e("DATA", url );
        MyAsynTask myAsynTask = new MyAsynTask();
        myAsynTask.execute();
        webviewResult.setHorizontalScrollBarEnabled(false);
    }

    private class MyAsynTask extends AsyncTask<Void, Void, Document> {
        @Override
        protected Document doInBackground(Void... voids) {

            Document document = null;
            try {
                document = Jsoup.connect(url).get();
                document.getElementsByClass("header-area").remove();
                document.getElementsByClass("top-header-area").remove();
                document.getElementsByClass("footer-area").remove();
                document.getElementsByClass("popular-news-widget mb-30").remove();
                document.getElementsByClass("newsletter-widget mb-50").remove();
                document.getElementsByClass("comment_area clearfix").remove();
                document.getElementsByClass("post-catagory").remove();
                document.getElementsByClass("post-title").remove();
                document.getElementsByClass("classy-navbar").remove();
                document.getElementsByClass("newspaper-post-like").remove();
                document.getElementsByTag("noscript").remove();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return document;
        }

        @Override
        protected void onPostExecute(Document document) {
            super.onPostExecute(document);
            webviewResult.loadDataWithBaseURL(url, document.toString(), "text/html", "utf-8", "");
            webviewResult.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

            webviewResult.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    view.loadUrl(url);
                    view.getSettings().setLoadsImagesAutomatically(false);
                    return super.shouldOverrideUrlLoading(view, request);
                }
            });
        }
    }
}
