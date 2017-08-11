package in.gov.mgov.ors;

import android.app.Activity;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class payment$1
  extends WebViewClient
{
  payment$1(payment parampayment, Activity paramActivity) {}
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    Activity localActivity = val$activity;
    int i = paramInt * 100;
    localActivity.setProgress(i);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
    paramSslErrorHandler.proceed();
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return false;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/payment$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */