package in.gov.mgov.ors;

import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
    char[] arrayOfChar1 = new char[16];
    char[] tmp6_5 = arrayOfChar1;
    char[] tmp7_6 = tmp6_5;
    char[] tmp7_6 = tmp6_5;
    tmp7_6[0] = 48;
    tmp7_6[1] = 49;
    char[] tmp16_7 = tmp7_6;
    char[] tmp16_7 = tmp7_6;
    tmp16_7[2] = 50;
    tmp16_7[3] = 51;
    char[] tmp25_16 = tmp16_7;
    char[] tmp25_16 = tmp16_7;
    tmp25_16[4] = 52;
    tmp25_16[5] = 53;
    char[] tmp34_25 = tmp25_16;
    char[] tmp34_25 = tmp25_16;
    tmp34_25[6] = 54;
    tmp34_25[7] = 55;
    char[] tmp45_34 = tmp34_25;
    char[] tmp45_34 = tmp34_25;
    tmp45_34[8] = 56;
    tmp45_34[9] = 57;
    char[] tmp56_45 = tmp45_34;
    char[] tmp56_45 = tmp45_34;
    tmp56_45[10] = 65;
    tmp56_45[11] = 66;
    char[] tmp67_56 = tmp56_45;
    char[] tmp67_56 = tmp56_45;
    tmp67_56[12] = 67;
    tmp67_56[13] = 68;
    tmp67_56[14] = 69;
    tmp67_56[15] = 70;
    char[] arrayOfChar2 = new char[2];
    int i = (paramByte & 0xF0) >> 4;
    i = arrayOfChar1[i];
    arrayOfChar2[0] = i;
    i = paramByte & 0xF;
    i = arrayOfChar1[i];
    arrayOfChar2[1] = i;
    String str = new java/lang/String;
    str.<init>(arrayOfChar2);
    return str;
  }
  
  public String HmacSHA256(String paramString1, String paramString2)
  {
    localObject = "HmacSHA256";
    try
    {
      Mac localMac = Mac.getInstance((String)localObject);
      SecretKeySpec localSecretKeySpec = new javax/crypto/spec/SecretKeySpec;
      localObject = paramString2.getBytes();
      String str = "HmacSHA256";
      localSecretKeySpec.<init>((byte[])localObject, str);
      localMac.init(localSecretKeySpec);
      localObject = paramString1.getBytes();
      byte[] arrayOfByte = localMac.doFinal((byte[])localObject);
      StringBuffer localStringBuffer = new java/lang/StringBuffer;
      localStringBuffer.<init>();
      int i = 0;
      for (;;)
      {
        int j = arrayOfByte.length;
        if (i >= j) {
          break;
        }
        j = arrayOfByte[i];
        localObject = char2hex(j);
        localStringBuffer.append((String)localObject);
        i += 1;
      }
      localObject = localStringBuffer.toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        int k = 0;
        localObject = null;
      }
    }
    return (String)localObject;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    int i = 2;
    super.onCreate(paramBundle);
    getWindow().requestFeature(i);
    getWindow().requestFeature(8);
    getActionBar().hide();
    setContentView(2130903062);
    Object localObject1 = getSharedPreferences("ors", 0);
    pref = ((SharedPreferences)localObject1);
    localObject1 = pref.edit();
    editor = ((SharedPreferences.Editor)localObject1);
    localObject1 = (WebView)findViewById(2131296435);
    payment = ((WebView)localObject1);
    localObject1 = new java/lang/StringBuilder;
    ((StringBuilder)localObject1).<init>();
    localObject1 = ((StringBuilder)localObject1).append("http://ors.gov.in/copp/submitpaymentrequest.jsp?pay_hos_id=");
    Object localObject2 = pref.getString("hospital_code", "0");
    localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append("&additional_info=");
    localObject2 = pref.getString("appointment_id", "0");
    localObject1 = ((StringBuilder)localObject1).append((String)localObject2).append("&additional_info_encr=");
    localObject2 = pref;
    String str1 = "0";
    localObject2 = ((SharedPreferences)localObject2).getString("appointment_id", str1);
    localObject2 = HmacSHA256((String)localObject2, "mobilepay@ors123");
    String str2 = (String)localObject2;
    payment.getSettings().setJavaScriptEnabled(true);
    localObject1 = payment;
    localObject2 = new in/gov/mgov/ors/payment$WebAppInterface;
    ((payment.WebAppInterface)localObject2).<init>(this, this);
    String str3 = "ok";
    ((WebView)localObject1).addJavascriptInterface(localObject2, str3);
    localObject1 = payment;
    localObject2 = new in/gov/mgov/ors/payment$1;
    ((payment.1)localObject2).<init>(this, this);
    ((WebView)localObject1).setWebViewClient((WebViewClient)localObject2);
    localObject1 = Integer.valueOf(Build.VERSION.SDK);
    int j = ((Integer)localObject1).intValue();
    int k = 21;
    if (j >= k)
    {
      localObject1 = payment.getSettings();
      ((WebSettings)localObject1).setMixedContentMode(i);
    }
    payment.loadUrl(str2);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/payment.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */