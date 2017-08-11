package in.gov.mgov.ors;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class payment
  extends Activity
{
  static final String URL = "http://ors.gov.in/copp/submitpaymentrequest.jsp?";
  SharedPreferences.Editor editor;
  WebView payment;
  SharedPreferences pref;
  
  public static String char2hex(byte paramByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 65;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 66;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 67;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 68;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 69;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 70;
    tmp90_84;
    return new String(new char[] { arrayOfChar[((paramByte & 0xF0) >> 4)], arrayOfChar[(paramByte & 0xF)] });
  }
  
  public String HmacSHA256(String paramString1, String paramString2)
  {
    try
    {
      Mac localMac = Mac.getInstance("HmacSHA256");
      localMac.init(new SecretKeySpec(paramString2.getBytes(), "HmacSHA256"));
      paramString1 = localMac.doFinal(paramString1.getBytes());
      paramString2 = new StringBuffer();
      int i = 0;
      while (i < paramString1.length)
      {
        paramString2.append(char2hex(paramString1[i]));
        i += 1;
      }
      paramString1 = paramString2.toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  @TargetApi(21)
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(2);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903062);
    pref = getSharedPreferences("ors", 0);
    editor = pref.edit();
    payment = ((WebView)findViewById(2131296435));
    paramBundle = "http://ors.gov.in/copp/submitpaymentrequest.jsp?pay_hos_id=" + pref.getString("hospital_code", "0") + "&additional_info=" + pref.getString("appointment_id", "0") + "&additional_info_encr=" + HmacSHA256(pref.getString("appointment_id", "0"), "mobilepay@ors123");
    payment.getSettings().setJavaScriptEnabled(true);
    payment.addJavascriptInterface(new WebAppInterface(this), "ok");
    payment.setWebViewClient(new WebViewClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        jdField_this.setProgress(paramAnonymousInt * 100);
      }
      
      public void onReceivedSslError(WebView paramAnonymousWebView, SslErrorHandler paramAnonymousSslErrorHandler, SslError paramAnonymousSslError)
      {
        super.onReceivedSslError(paramAnonymousWebView, paramAnonymousSslErrorHandler, paramAnonymousSslError);
        paramAnonymousSslErrorHandler.proceed();
      }
      
      public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        return false;
      }
    });
    if (Integer.valueOf(Build.VERSION.SDK).intValue() >= 21) {
      payment.getSettings().setMixedContentMode(2);
    }
    payment.loadUrl(paramBundle);
  }
  
  public class WebAppInterface
  {
    Context mContext;
    
    WebAppInterface(Context paramContext)
    {
      mContext = paramContext;
    }
    
    @JavascriptInterface
    public void performClick()
    {
      editor.putString("paymentstatus", "ok").commit();
      Intent localIntent = new Intent(getApplicationContext(), ServiceSelection.class);
      localIntent.addFlags(268468224);
      startActivity(localIntent);
    }
    
    @JavascriptInterface
    public void showToast(String paramString)
    {
      Toast.makeText(mContext, paramString, 0).show();
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/payment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */