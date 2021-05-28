package com.tech.webviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

Button btn_search;
ImageButton btn_g,btn_yt,btn_inst,btn_fb,btn_link;
EditText et_url;
WebView webview;
ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        //webview is used to integrate webpages into your application
        //step 1  webview.loadurl()

        //step 2: to load url into webvioew


        webview.loadUrl("https://github.com/dnyaneshrt");

        webview.setWebViewClient(new WebViewClient()
        {
            @Override//this will excecute once page will start loading
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pbar.setVisibility(View.VISIBLE);
            }

            @Override//will come to know ,which url is loading.
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.d("URL",url);
                return super.shouldOverrideUrlLoading(view, url);

            }

            @Override//once page exceutes astop
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pbar.setVisibility(View.GONE);
            }
        });


        //enale javascript and built in zoom controls programmmatically

        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setBuiltInZoomControls(true);



    }

    private void init() {
        btn_search=findViewById(R.id.btn_search);
        et_url=findViewById(R.id.et_url);
        webview=findViewById(R.id.webview);
        btn_fb=findViewById(R.id.btn_facebook);
        btn_g=findViewById(R.id.btn_google);
        btn_inst=findViewById(R.id.btn_instagram);
        btn_link=findViewById(R.id.btn_linkedin);
        btn_yt=findViewById(R.id.btn_youtube);
        pbar=findViewById(R.id.progress_bar);
    }

    public void onLoad(View view) {
       switch (view.getId())
       {
           case R.id.btn_search:
           {
//               Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show();
               String url=et_url.getText().toString();
               webview.loadUrl("https://"+url+"/");
               break;

           }

           case R.id.btn_facebook:
           {
               webview.loadUrl("https://www.facebook.com/");//which will call the url.
               break;

           }
           case R.id.btn_google:
           {
               webview.loadUrl("https://www.google.com/");
               break;
           }
           case R.id.btn_instagram:
           {
               webview.loadUrl("https://www.instagram.com/");
               break;
           }
           case R.id.btn_linkedin:
           {
               webview.loadUrl("https://www.linkedin.com/");
               break;
           }
           case R.id.btn_youtube:
           {
               webview.loadUrl("https://www.youtube.com/");
               break;
           }
       }

    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack())
        {
          webview.goBack();
        }else
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Exit");
//            builder.setIcon(R.drawable.ic_baseline_exit_to_app_24);
            builder.setIcon(R.drawable.ic_baseline_exit_to_app_24);
            builder.setMessage("Are u sure,you want to exit from app?");

            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                   finish();
                }
            });

            builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                   dialog.dismiss();
                }
            });


         builder.show();
        }


    }
}