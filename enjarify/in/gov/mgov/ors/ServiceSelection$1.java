package in.gov.mgov.ors;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import java.util.Locale;

class ServiceSelection$1
  implements View.OnClickListener
{
  ServiceSelection$1(ServiceSelection paramServiceSelection) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this$0.language.getText().toString();
    Object localObject2 = "english";
    boolean bool = ((String)localObject1).equalsIgnoreCase((String)localObject2);
    String str1;
    Locale localLocale;
    Configuration localConfiguration;
    String str2;
    if (!bool)
    {
      str1 = "hi";
      localLocale = new java/util/Locale;
      localLocale.<init>(str1);
      Locale.setDefault(localLocale);
      localConfiguration = new android/content/res/Configuration;
      localConfiguration.<init>();
      locale = localLocale;
      localObject1 = this$0.getBaseContext().getResources();
      localObject2 = this$0.getBaseContext().getResources().getDisplayMetrics();
      ((Resources)localObject1).updateConfiguration(localConfiguration, (DisplayMetrics)localObject2);
      localObject1 = this$0.editor;
      localObject2 = "lang";
      str2 = "HI";
      ((SharedPreferences.Editor)localObject1).putString((String)localObject2, str2).commit();
      localObject1 = this$0;
      ServiceSelection.access$000((ServiceSelection)localObject1);
    }
    for (;;)
    {
      return;
      str1 = "en";
      localLocale = new java/util/Locale;
      localLocale.<init>(str1);
      Locale.setDefault(localLocale);
      localConfiguration = new android/content/res/Configuration;
      localConfiguration.<init>();
      locale = localLocale;
      localObject1 = this$0.getBaseContext().getResources();
      localObject2 = this$0.getBaseContext().getResources().getDisplayMetrics();
      ((Resources)localObject1).updateConfiguration(localConfiguration, (DisplayMetrics)localObject2);
      localObject1 = this$0.editor;
      localObject2 = "lang";
      str2 = "EN";
      ((SharedPreferences.Editor)localObject1).putString((String)localObject2, str2).commit();
      localObject1 = this$0;
      ServiceSelection.access$000((ServiceSelection)localObject1);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ServiceSelection$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */