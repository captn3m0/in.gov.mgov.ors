package in.gov.mgov.ors;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class GetUserInformationNonAadhaar$1
  implements View.OnClickListener
{
  GetUserInformationNonAadhaar$1(GetUserInformationNonAadhaar paramGetUserInformationNonAadhaar) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    Object localObject1 = this;
    localObject1 = this$0;
    Object localObject2 = localObject1;
    localObject1 = gender;
    localObject2 = localObject1;
    int i5 = ((RadioGroup)localObject1).getCheckedRadioButtonId();
    localObject1 = this;
    Object localObject3 = this$0;
    localObject1 = this;
    localObject1 = this$0;
    localObject2 = localObject1;
    localObject2 = (RadioButton)((GetUserInformationNonAadhaar)localObject1).findViewById(i5);
    localObject1 = localObject2;
    gendervalue = ((RadioButton)localObject2);
    localObject1 = this;
    localObject1 = this$0;
    localObject2 = localObject1;
    localObject1 = fname;
    localObject2 = localObject1;
    localObject2 = ((EditText)localObject1).getText();
    int i6 = ((Editable)localObject2).length();
    label199:
    label485:
    label771:
    int i9;
    label938:
    label1114:
    label1167:
    label1216:
    label1269:
    label1309:
    Intent localIntent;
    if (i6 != 0)
    {
      i = 0 + 1;
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = lname;
      localObject2 = localObject1;
      localObject2 = ((EditText)localObject1).getText();
      i6 = ((Editable)localObject2).length();
      if (i6 == 0) {
        break label2075;
      }
      i += 1;
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = dd;
      localObject2 = localObject1;
      localObject2 = ((EditText)localObject1).getText();
      i6 = ((Editable)localObject2).length();
      int i8;
      if (i6 != 0)
      {
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject1 = dd;
        localObject2 = localObject1;
        localObject2 = ((EditText)localObject1).getText().toString();
        i6 = Integer.parseInt((String)localObject2);
        if (i6 <= 0) {
          break label2081;
        }
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject1 = dd;
        localObject2 = localObject1;
        localObject2 = ((EditText)localObject1).getText().toString();
        i6 = Integer.parseInt((String)localObject2);
        i8 = 31;
        if (i6 > i8) {
          break label2081;
        }
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject1 = dd;
        localObject2 = localObject1;
        localObject2 = ((EditText)localObject1).getText();
        i6 = ((Editable)localObject2).length();
        i8 = 1;
        if (i6 == i8)
        {
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = dd;
          localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>();
          localObject3 = ((StringBuilder)localObject3).append("0");
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          localObject1 = dd;
          localObject4 = localObject1;
          localObject4 = ((EditText)localObject1).getText();
          localObject3 = localObject4;
          ((EditText)localObject2).setText((CharSequence)localObject3);
        }
        i += 1;
      }
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = mm;
      localObject2 = localObject1;
      localObject2 = ((EditText)localObject1).getText();
      i6 = ((Editable)localObject2).length();
      if (i6 != 0)
      {
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject1 = mm;
        localObject2 = localObject1;
        localObject2 = ((EditText)localObject1).getText().toString();
        i6 = Integer.parseInt((String)localObject2);
        if (i6 <= 0) {
          break label2087;
        }
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject1 = mm;
        localObject2 = localObject1;
        localObject2 = ((EditText)localObject1).getText().toString();
        i6 = Integer.parseInt((String)localObject2);
        i8 = 12;
        if (i6 > i8) {
          break label2087;
        }
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject1 = mm;
        localObject2 = localObject1;
        localObject2 = ((EditText)localObject1).getText();
        i6 = ((Editable)localObject2).length();
        i8 = 1;
        if (i6 == i8)
        {
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = mm;
          localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>();
          localObject3 = ((StringBuilder)localObject3).append("0");
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          localObject1 = mm;
          localObject4 = localObject1;
          localObject4 = ((EditText)localObject1).getText();
          localObject3 = localObject4;
          ((EditText)localObject2).setText((CharSequence)localObject3);
        }
        i += 1;
      }
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = yyyy;
      localObject2 = localObject1;
      localObject2 = ((EditText)localObject1).getText();
      i6 = ((Editable)localObject2).length();
      if (i6 != 0)
      {
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject1 = yyyy;
        localObject2 = localObject1;
        localObject2 = ((EditText)localObject1).getText().toString();
        i6 = Integer.parseInt((String)localObject2);
        i8 = 1900;
        if (i6 <= i8) {
          break label2093;
        }
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject1 = yyyy;
        localObject2 = localObject1;
        localObject2 = ((EditText)localObject1).getText().toString();
        i6 = Integer.parseInt((String)localObject2);
        localObject3 = Calendar.getInstance();
        i9 = 1;
        i8 = ((Calendar)localObject3).get(i9);
        if (i6 > i8) {
          break label2093;
        }
        i += 1;
      }
      localObject1 = this;
      localObject2 = this$0;
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>();
      localObject1 = this;
      localObject1 = this$0;
      Object localObject4 = localObject1;
      localObject1 = dd;
      localObject4 = localObject1;
      localObject4 = ((EditText)localObject1).getText();
      localObject3 = ((StringBuilder)localObject3).append(localObject4).append("/");
      localObject1 = this;
      localObject1 = this$0;
      localObject4 = localObject1;
      localObject1 = mm;
      localObject4 = localObject1;
      localObject4 = ((EditText)localObject1).getText();
      localObject3 = ((StringBuilder)localObject3).append(localObject4).append("/");
      localObject1 = this;
      localObject1 = this$0;
      localObject4 = localObject1;
      localObject1 = yyyy;
      localObject4 = localObject1;
      localObject4 = ((EditText)localObject1).getText();
      localObject3 = localObject4;
      localObject4 = "dd/MM/yyyy";
      boolean bool1 = ((GetUserInformationNonAadhaar)localObject2).isThisDateValid((String)localObject3, (String)localObject4);
      if (!bool1) {
        break label2099;
      }
      i += 1;
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = cof;
      localObject2 = localObject1;
      localObject2 = ((EditText)localObject1).getText().toString().trim();
      int i7 = ((String)localObject2).length();
      if (i7 == 0) {
        break label2105;
      }
      i += 1;
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = mobile;
      localObject2 = localObject1;
      localObject2 = ((EditText)localObject1).getText();
      i7 = ((Editable)localObject2).length();
      if (i7 == 0) {
        break label2111;
      }
      i += 1;
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = address;
      localObject2 = localObject1;
      localObject2 = ((EditText)localObject1).getText().toString().trim();
      i7 = ((String)localObject2).length();
      if (i7 == 0) {
        break label2117;
      }
      i += 1;
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = state;
      localObject2 = localObject1;
      i7 = ((Spinner)localObject1).getSelectedItemPosition();
      if (i7 == 0) {
        break label2123;
      }
      i += 1;
      i7 = 10;
      if (i != i7) {
        break label2174;
      }
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      localObject1 = fname;
      localObject3 = localObject1;
      localObject3 = ((EditText)localObject1).getText().toString().trim();
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(" ");
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      localObject1 = lname;
      localObject3 = localObject1;
      localObject3 = ((EditText)localObject1).getText().toString().trim();
      localObject2 = (String)localObject3;
      localArrayList.add(localObject2);
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      localObject1 = dd;
      localObject3 = localObject1;
      localObject3 = ((EditText)localObject1).getText().toString();
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append("-");
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      localObject1 = mm;
      localObject3 = localObject1;
      localObject3 = ((EditText)localObject1).getText().toString();
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append("-");
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      localObject1 = yyyy;
      localObject3 = localObject1;
      localObject3 = ((EditText)localObject1).getText().toString();
      localObject2 = (String)localObject3;
      localArrayList.add(localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = gendervalue;
      localObject2 = localObject1;
      localObject2 = ((RadioButton)localObject1).getText().toString();
      localArrayList.add(localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = mobile;
      localObject2 = localObject1;
      localObject2 = ((EditText)localObject1).getText().toString();
      localArrayList.add(localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = cof;
      localObject2 = localObject1;
      localObject2 = ((EditText)localObject1).getText().toString();
      localArrayList.add(localObject2);
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      localObject1 = address;
      localObject3 = localObject1;
      localObject3 = ((EditText)localObject1).getText().toString();
      localObject2 = ((StringBuilder)localObject2).append((String)localObject3).append(" ");
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      localObject1 = pin;
      localObject3 = localObject1;
      localObject3 = ((EditText)localObject1).getText().toString();
      localObject2 = (String)localObject3;
      localArrayList.add(localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = state;
      localObject2 = localObject1;
      localObject2 = ((Spinner)localObject1).getSelectedItem().toString();
      localArrayList.add(localObject2);
      localObject1 = new String[localArrayList.size()];
      localObject2 = localObject1;
      String[] arrayOfString = (String[])localArrayList.toArray((Object[])localObject1);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = location;
      localObject2 = localObject1;
      localObject3 = "noaadhaar";
      boolean bool2 = ((String)localObject1).equals(localObject3);
      if (!bool2) {
        break label2129;
      }
      localIntent = new android/content/Intent;
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ((GetUserInformationNonAadhaar)localObject1).getApplicationContext();
      localObject3 = ShowUIDAIDataNonAadhaar.class;
      localObject1 = localObject2;
      localIntent.<init>((Context)localObject2, (Class)localObject3);
      label2017:
      localObject1 = "uid_data";
      localIntent.putExtra((String)localObject1, arrayOfString);
      localObject3 = "fromaadhaarnonumber";
      localObject1 = "from";
      localIntent.putExtra((String)localObject1, (String)localObject3);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      ((GetUserInformationNonAadhaar)localObject1).startActivity(localIntent);
    }
    for (;;)
    {
      return;
      j = 1;
      break;
      label2075:
      k = 1;
      break label199;
      label2081:
      i2 = 1;
      break label485;
      label2087:
      i4 = 1;
      break label771;
      label2093:
      i4 = 1;
      break label938;
      label2099:
      i2 = 1;
      break label1114;
      label2105:
      m = 1;
      break label1167;
      label2111:
      n = 1;
      break label1216;
      label2117:
      i1 = 1;
      break label1269;
      label2123:
      i3 = 1;
      break label1309;
      label2129:
      localIntent = new android/content/Intent;
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ((GetUserInformationNonAadhaar)localObject1).getApplicationContext();
      localObject3 = ShowUIDAIDataNonNumber.class;
      localObject1 = localObject2;
      localIntent.<init>((Context)localObject2, (Class)localObject3);
      break label2017;
      label2174:
      String str = "";
      if (j != 0)
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject1 = localObject2;
        localObject2 = ((StringBuilder)localObject2).append(str);
        localObject1 = this;
        localObject1 = this$0;
        localObject3 = localObject1;
        localObject3 = ((GetUserInformationNonAadhaar)localObject1).getResources();
        i9 = 2131034279;
        localObject3 = ((Resources)localObject3).getString(i9);
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        localObject3 = "\n";
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        str = ((StringBuilder)localObject2).toString();
      }
      if (k != 0)
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject1 = localObject2;
        localObject2 = ((StringBuilder)localObject2).append(str);
        localObject1 = this;
        localObject1 = this$0;
        localObject3 = localObject1;
        localObject3 = ((GetUserInformationNonAadhaar)localObject1).getResources();
        i9 = 2131034280;
        localObject3 = ((Resources)localObject3).getString(i9);
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        localObject3 = "\n";
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        str = ((StringBuilder)localObject2).toString();
      }
      if ((i2 != 0) || (i4 != 0))
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject1 = localObject2;
        localObject2 = ((StringBuilder)localObject2).append(str);
        localObject1 = this;
        localObject1 = this$0;
        localObject3 = localObject1;
        localObject3 = ((GetUserInformationNonAadhaar)localObject1).getResources();
        i9 = 2131034278;
        localObject3 = ((Resources)localObject3).getString(i9);
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        localObject3 = "\n";
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        str = ((StringBuilder)localObject2).toString();
      }
      if (m != 0)
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject1 = localObject2;
        localObject2 = ((StringBuilder)localObject2).append(str);
        localObject1 = this;
        localObject1 = this$0;
        localObject3 = localObject1;
        localObject3 = ((GetUserInformationNonAadhaar)localObject1).getResources();
        i9 = 2131034283;
        localObject3 = ((Resources)localObject3).getString(i9);
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        localObject3 = "\n";
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        str = ((StringBuilder)localObject2).toString();
      }
      if (n != 0)
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject1 = localObject2;
        localObject2 = ((StringBuilder)localObject2).append(str);
        localObject1 = this;
        localObject1 = this$0;
        localObject3 = localObject1;
        localObject3 = ((GetUserInformationNonAadhaar)localObject1).getResources();
        i9 = 2131034281;
        localObject3 = ((Resources)localObject3).getString(i9);
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        localObject3 = "\n";
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        str = ((StringBuilder)localObject2).toString();
      }
      if (i1 != 0)
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject1 = localObject2;
        localObject2 = ((StringBuilder)localObject2).append(str);
        localObject1 = this;
        localObject1 = this$0;
        localObject3 = localObject1;
        localObject3 = ((GetUserInformationNonAadhaar)localObject1).getResources();
        i9 = 2131034276;
        localObject3 = ((Resources)localObject3).getString(i9);
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        localObject3 = "\n";
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        str = ((StringBuilder)localObject2).toString();
      }
      if (i3 != 0)
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject1 = localObject2;
        localObject2 = ((StringBuilder)localObject2).append(str);
        localObject1 = this;
        localObject1 = this$0;
        localObject3 = localObject1;
        localObject3 = ((GetUserInformationNonAadhaar)localObject1).getResources();
        i9 = 2131034286;
        localObject3 = ((Resources)localObject3).getString(i9);
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        str = ((StringBuilder)localObject2).toString();
      }
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      GetUserInformationNonAadhaar.access$000((GetUserInformationNonAadhaar)localObject1, str);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/GetUserInformationNonAadhaar$1.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */