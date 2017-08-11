package in.gov.mgov.ors;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import in.gov.mgov.helper.GetStateData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

class ShowUIDAIData$CallList
  extends AsyncTask
{
  private ProgressDialog dlog;
  
  private ShowUIDAIData$CallList(ShowUIDAIData paramShowUIDAIData) {}
  
  protected String doInBackground(String... paramVarArgs)
  {
    Object localObject1 = this;
    localObject1 = this$0;
    Object localObject2 = localObject1;
    int i = 0;
    Object localObject3 = paramVarArgs[0];
    ShowUIDAIData.access$202((ShowUIDAIData)localObject1, (String)localObject3);
    SoapObject localSoapObject = new org/ksoap2/serialization/SoapObject;
    localObject1 = this;
    localObject1 = this$0;
    localObject3 = localObject1;
    localObject3 = ShowUIDAIData.access$200((ShowUIDAIData)localObject1);
    localObject1 = localSoapObject;
    Object localObject4 = "http://orsws/";
    Object localObject5 = localObject3;
    localSoapObject.<init>((String)localObject4, (String)localObject3);
    localObject1 = this;
    localObject1 = this$0;
    localObject2 = localObject1;
    localObject2 = ShowUIDAIData.access$200((ShowUIDAIData)localObject1);
    localObject3 = "getAvailabledatelist";
    boolean bool = ((String)localObject2).equals(localObject3);
    if (bool)
    {
      PropertyInfo localPropertyInfo1 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo1.<init>();
      localObject1 = localPropertyInfo1;
      localObject4 = "hospitalid";
      localPropertyInfo1.setName((String)localObject4);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      k = hospitalcode;
      bool = k;
      localObject2 = Integer.valueOf(k);
      localObject1 = localPropertyInfo1;
      localObject4 = localObject2;
      localPropertyInfo1.setValue(localObject2);
      localObject4 = Integer.class;
      localPropertyInfo1.setType(localObject4);
      localObject1 = localSoapObject;
      localObject4 = localPropertyInfo1;
      localSoapObject.addProperty(localPropertyInfo1);
      PropertyInfo localPropertyInfo2 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo2.<init>();
      localObject1 = "departmentid";
      localPropertyInfo2.setName((String)localObject1);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      k = departmentcode;
      bool = k;
      localObject2 = Integer.valueOf(k);
      localObject1 = localObject2;
      localPropertyInfo2.setValue(localObject2);
      localObject1 = Integer.class;
      localPropertyInfo2.setType(localObject1);
      localObject1 = localSoapObject;
      localSoapObject.addProperty(localPropertyInfo2);
      PropertyInfo localPropertyInfo3 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo3.<init>();
      localObject1 = "appointmentcat";
      localPropertyInfo3.setName((String)localObject1);
      localObject2 = Integer.valueOf(0);
      localObject1 = localObject2;
      localPropertyInfo3.setValue(localObject2);
      localObject1 = Integer.class;
      localPropertyInfo3.setType(localObject1);
      localObject1 = localSoapObject;
      localSoapObject.addProperty(localPropertyInfo3);
      PropertyInfo localPropertyInfo4 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo4.<init>();
      localObject1 = "calmonth";
      localPropertyInfo4.setName((String)localObject1);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      k = monthx;
      bool = k;
      localObject2 = Integer.valueOf(k);
      localObject1 = localObject2;
      localPropertyInfo4.setValue(localObject2);
      localObject1 = Integer.class;
      localPropertyInfo4.setType(localObject1);
      localObject1 = localSoapObject;
      localSoapObject.addProperty(localPropertyInfo4);
      PropertyInfo localPropertyInfo5 = new org/ksoap2/serialization/PropertyInfo;
      localPropertyInfo5.<init>();
      localObject1 = localPropertyInfo5;
      localObject4 = "inToken";
      localPropertyInfo5.setName((String)localObject4);
      localObject4 = "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj";
      localPropertyInfo5.setValue(localObject4);
      localObject2 = String.class;
      localObject4 = localObject2;
      localPropertyInfo5.setType(localObject2);
      localObject1 = localSoapObject;
      localObject4 = localPropertyInfo5;
      localSoapObject.addProperty(localPropertyInfo5);
    }
    localObject1 = this;
    localObject1 = this$0;
    localObject2 = localObject1;
    localObject2 = ShowUIDAIData.access$200((ShowUIDAIData)localObject1);
    localObject3 = "fixAppointment";
    bool = ((String)localObject2).equals(localObject3);
    if (bool)
    {
      String str1 = "0";
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = uidData;
      localObject2 = localObject1;
      i = 2;
      localObject2 = localObject1[i];
      localObject3 = "M";
      bool = ((String)localObject2).equalsIgnoreCase((String)localObject3);
      if (bool) {
        str1 = "1";
      }
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = uidData;
      localObject2 = localObject1;
      i = 2;
      localObject2 = localObject1[i];
      localObject3 = "F";
      bool = ((String)localObject2).equalsIgnoreCase((String)localObject3);
      if (bool) {
        str1 = "2";
      }
      String str2 = "";
      int m = 5;
      for (;;)
      {
        j = 15;
        k = j;
        if (m >= j) {
          break;
        }
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject1 = localObject2;
        localObject2 = ((StringBuilder)localObject2).append(str2);
        localObject1 = this;
        localObject1 = this$0;
        localObject3 = localObject1;
        localObject1 = uidData;
        localObject3 = localObject1;
        localObject3 = localObject1[m];
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        localObject3 = " ";
        localObject2 = ((StringBuilder)localObject2).append((String)localObject3);
        str2 = ((StringBuilder)localObject2).toString();
        m += 1;
      }
      String str3 = "dd-MM-yyyy";
      localObject2 = new java/text/SimpleDateFormat;
      localObject1 = localObject2;
      localObject4 = str3;
      ((SimpleDateFormat)localObject2).<init>(str3);
      localObject3 = new java/util/Date;
      ((Date)localObject3).<init>();
      String str4 = ((SimpleDateFormat)localObject2).format((Date)localObject3);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = uidData;
      localObject2 = localObject1;
      Object localObject6 = localObject1[1];
      j = ((String)localObject6).length() + -4;
      i = ((String)localObject6).length();
      k = j;
      n = i;
      int i1 = Integer.parseInt(((String)localObject6).substring(j, i));
      j = str4.length() + -4;
      i = str4.length();
      k = j;
      n = i;
      int i2 = Integer.parseInt(str4.substring(j, i));
      j = ((String)localObject6).length() + -4;
      i = ((String)localObject6).length();
      k = j;
      n = i;
      String str5 = ((String)localObject6).substring(j, i);
      j = ((String)localObject6).length() + -7;
      i = ((String)localObject6).length() + -5;
      k = j;
      n = i;
      String str6 = ((String)localObject6).substring(j, i);
      j = 0;
      n = 2;
      String str7 = ((String)localObject6).substring(0, n);
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      i = i2 - i1;
      String str8 = i + "";
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject1, "flagtp", 0, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "intoken", "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject2 = this$0;
      localObject1 = this;
      localObject1 = this$0;
      Object localObject7 = localObject1;
      localObject1 = uidData;
      localObject7 = localObject1;
      localObject7 = localObject1[0];
      String str9 = "^";
      localObject7 = ((String)localObject7).replaceAll(" ", str9);
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject2, "inpatientname", (String)localObject7, String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject4 = "ingender";
      localObject5 = String.class;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, (String)localObject4, str1, localObject5);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject4 = "inpaddress";
      localObject5 = String.class;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, (String)localObject4, str2, localObject5);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject2 = this$0;
      localObject7 = new java/lang/StringBuilder;
      ((StringBuilder)localObject7).<init>();
      localObject1 = localObject7;
      localObject4 = str5;
      localObject7 = ((StringBuilder)localObject7).append(str5).append("-");
      localObject1 = localObject7;
      localObject4 = str6;
      localObject7 = ((StringBuilder)localObject7).append(str6).append("-");
      localObject1 = localObject7;
      localObject7 = str7;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject2, "indob", (String)localObject7, String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject2 = this$0;
      localObject7 = new in/gov/mgov/helper/GetStateData;
      ((GetStateData)localObject7).<init>();
      localObject1 = this;
      localObject1 = this$0;
      Object localObject8 = localObject1;
      localObject1 = uidData;
      localObject8 = localObject1;
      int i3 = 12;
      localObject8 = localObject1[i3];
      int i4 = ((GetStateData)localObject7).getStateCode((String)localObject8);
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject2, "instatecode", i4, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject1, "incountrycode", 91, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject2 = this$0;
      localObject1 = this;
      localObject1 = this$0;
      localObject7 = localObject1;
      localObject1 = uidData;
      localObject7 = localObject1;
      localObject7 = localObject1[3];
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject2, "inmobileno", (String)localObject7, String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "inemail", "", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject1, "inbillingtype", 1, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject1, "inreligion", 0, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject2 = this$0;
      localObject1 = this;
      localObject1 = this$0;
      localObject7 = localObject1;
      k = hospitalcode;
      i4 = k;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject2, "inhospitalid", k, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "inentfrom", "0.0.0.0", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject2 = this$0;
      localObject1 = this;
      localObject1 = this$0;
      localObject7 = localObject1;
      localObject1 = uidData;
      localObject7 = localObject1;
      localObject7 = localObject1[5];
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject2, "infathername", (String)localObject7, String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "inmothername", "", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "inpatrelstr", "c/o", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "inbplverifiedby", "", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "inothersdetails", "", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "injaildetails", "", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "incghscardno", "", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject2 = this$0;
      localObject7 = new java/lang/StringBuilder;
      ((StringBuilder)localObject7).<init>();
      localObject1 = localObject7;
      localObject7 = str8 + " years";
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject2, "inage", (String)localObject7, String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "newfollowup", "0", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject1, "birthorder", 0, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject1, "parity", 0, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject1, "gravida", 0, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject1, "pragnancyindicator", 0, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject1, "durationofpragnancy", 0, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "prvregno", "", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject2 = this$0;
      localObject1 = this;
      localObject1 = this$0;
      localObject7 = localObject1;
      localObject1 = aadhaarno;
      localObject7 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject2, "inaadhaarId", (String)localObject1, String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject2 = this$0;
      localObject1 = this;
      localObject1 = this$0;
      localObject7 = localObject1;
      localObject1 = uidData;
      localObject7 = localObject1;
      localObject7 = localObject1[15];
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject2, "inaadhaarImg", (String)localObject7, String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject2 = this$0;
      localObject1 = this;
      localObject1 = this$0;
      localObject7 = localObject1;
      k = hospitalcode;
      i4 = k;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject2, "hosid", k, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject2 = this$0;
      localObject1 = this;
      localObject1 = this$0;
      localObject7 = localObject1;
      k = departmentcode;
      i4 = k;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject2, "deptid", k, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject1, "unitid", 0, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject1, "clinicid", 0, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject1, "roomid", 0, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject1, "docid", 0, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject2 = this$0;
      localObject1 = this;
      localObject1 = this$0;
      localObject7 = localObject1;
      localObject1 = appdate;
      localObject7 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject2, "appdate", (String)localObject1, String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "regno", "", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "tmpappid", "0", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject1, "uid", 99999, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "entsystem", "0.0.0.0", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject1, "apptype", 0, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$300((ShowUIDAIData)localObject1, "appcat", 0, Integer.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "apptimestr", "8 AM", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "isautodoc", "Y", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "iswithuhid", "N", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "contextPath", "", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject2 = this$0;
      localObject1 = this;
      localObject1 = this$0;
      localObject7 = localObject1;
      localObject1 = uidData;
      localObject7 = localObject1;
      localObject7 = localObject1[3];
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject2, "mblno", (String)localObject7, String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject2 = this$0;
      localObject1 = this;
      localObject1 = this$0;
      localObject7 = localObject1;
      localObject1 = uidData;
      localObject7 = localObject1;
      int i5 = 4;
      localObject7 = localObject1[i5];
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject2, "email", (String)localObject7, String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      i4 = 0;
      localObject7 = Boolean.valueOf(false);
      localObject2 = ShowUIDAIData.access$500((ShowUIDAIData)localObject1, "ispayonline", (Boolean)localObject7, Boolean.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, "hid", "", String.class);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject3 = "hidavailable";
      localObject7 = "";
      localObject8 = String.class;
      localObject2 = ShowUIDAIData.access$400((ShowUIDAIData)localObject1, (String)localObject3, (String)localObject7, localObject8);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
    }
    SoapSerializationEnvelope localSoapSerializationEnvelope = new org/ksoap2/serialization/SoapSerializationEnvelope;
    int j = 110;
    int k = j;
    localSoapSerializationEnvelope.<init>(j);
    localObject1 = localSoapObject;
    localSoapSerializationEnvelope.setOutputSoapObject(localSoapObject);
    HttpTransportSE localHttpTransportSE = new org/ksoap2/transport/HttpTransportSE;
    i = 60000;
    localObject1 = "http://ors.gov.in/ORSServicecontainer/services?wsdl";
    int n = i;
    localHttpTransportSE.<init>((String)localObject1, i);
    localObject2 = "http://orsws/";
    localObject1 = localObject2;
    try
    {
      localHttpTransportSE.call((String)localObject2, localSoapSerializationEnvelope);
      Object localObject9 = localSoapSerializationEnvelope.getResponse();
      localObject9 = (SoapPrimitive)localObject9;
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject3 = ((SoapPrimitive)localObject9).toString();
      localObject1 = localObject3;
      localObject4 = localObject2;
      finalresp = ((String)localObject3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    localObject1 = this;
    localObject1 = this$0;
    localObject2 = localObject1;
    localObject1 = finalresp;
    localObject2 = localObject1;
    return (String)localObject1;
  }
  
  protected void onPostExecute(String paramString)
  {
    super.onPostExecute(paramString);
    Object localObject1 = this;
    localObject1 = dlog;
    Object localObject2 = localObject1;
    boolean bool1 = ((ProgressDialog)localObject1).isShowing();
    if (bool1)
    {
      localObject1 = this;
      localObject1 = dlog;
      localObject2 = localObject1;
      ((ProgressDialog)localObject1).dismiss();
    }
    for (;;)
    {
      try
      {
        localJSONObject1 = new org/json/JSONObject;
        localObject1 = paramString;
        localJSONObject1.<init>(paramString);
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject2 = ShowUIDAIData.access$200((ShowUIDAIData)localObject1);
        localObject3 = "getAvailabledatelist";
        bool1 = ((String)localObject2).equals(localObject3);
        Object localObject4;
        int i3;
        if (bool1)
        {
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = list;
          localObject2 = localObject1;
          ((List)localObject1).clear();
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = id;
          localObject2 = localObject1;
          ((List)localObject1).clear();
          localObject2 = "data";
          localObject1 = localObject2;
          localObject2 = localJSONObject1.get((String)localObject2);
          String str1 = localObject2.toString();
          JSONObject localJSONObject2 = new org/json/JSONObject;
          localJSONObject2.<init>(str1);
          localObject2 = "calenderData";
          localObject1 = localObject2;
          JSONArray localJSONArray1 = localJSONObject2.optJSONArray((String)localObject2);
          localObject2 = "eventCalender";
          localObject1 = localObject2;
          JSONArray localJSONArray2 = localJSONObject2.optJSONArray((String)localObject2);
          int m = 0;
          int i = localJSONArray1.length();
          int n = i;
          if (m < i)
          {
            int i1 = 0;
            JSONObject localJSONObject3 = localJSONArray1.getJSONObject(m);
            localObject2 = "flag";
            localObject1 = localObject2;
            localObject2 = localJSONObject3.getString((String)localObject2);
            localObject3 = "4";
            boolean bool2 = ((String)localObject2).equals(localObject3);
            if (bool2) {
              i1 = 1;
            }
            localObject2 = "flag";
            localObject1 = localObject2;
            localObject2 = localJSONObject3.getString((String)localObject2);
            localObject3 = "2";
            bool2 = ((String)localObject2).equals(localObject3);
            if (bool2) {
              i1 = 1;
            }
            localObject2 = "flag";
            localObject1 = localObject2;
            localObject2 = localJSONObject3.getString((String)localObject2);
            localObject3 = "1";
            bool2 = ((String)localObject2).equals(localObject3);
            int i2;
            String str2;
            JSONObject localJSONObject4;
            if (bool2)
            {
              i2 = 0;
              int j = localJSONArray2.length();
              n = j;
              if (i2 < j)
              {
                localObject2 = "day_";
                localObject1 = localObject2;
                str2 = localJSONObject3.getString((String)localObject2);
                localJSONObject4 = localJSONArray2.getJSONObject(i2);
                localObject2 = "calender_day";
                localObject1 = localObject2;
                localObject2 = localJSONObject4.getString((String)localObject2);
                localObject1 = localObject2;
                bool3 = ((String)localObject2).equals(str2);
                if (bool3) {
                  i1 = 1;
                }
                i2 += 1;
                continue;
              }
              if (i1 == 0)
              {
                localObject1 = this;
                localObject1 = this$0;
                localObject2 = localObject1;
                localObject2 = list;
                localObject3 = "app_date_";
                localObject1 = localObject3;
                localObject3 = localJSONObject3.getString((String)localObject3);
                ((List)localObject2).add(localObject3);
              }
            }
            localObject2 = "flag";
            localObject1 = localObject2;
            localObject2 = localJSONObject3.getString((String)localObject2);
            localObject3 = "3";
            boolean bool3 = ((String)localObject2).equals(localObject3);
            if (bool3)
            {
              i2 = 0;
              int k = localJSONArray2.length();
              n = k;
              if (i2 < k)
              {
                localObject2 = "day_";
                localObject1 = localObject2;
                str2 = localJSONObject3.getString((String)localObject2);
                localJSONObject4 = localJSONArray2.getJSONObject(i2);
                localObject2 = "calender_day";
                localObject1 = localObject2;
                localObject2 = localJSONObject4.getString((String)localObject2);
                localObject1 = localObject2;
                bool4 = ((String)localObject2).equals(str2);
                if (bool4) {
                  i1 = 1;
                }
                i2 += 1;
                continue;
              }
              if (i1 == 0)
              {
                localObject1 = this;
                localObject1 = this$0;
                localObject2 = localObject1;
                localObject2 = list;
                localObject3 = "app_date_";
                localObject1 = localObject3;
                localObject3 = localJSONObject3.getString((String)localObject3);
                ((List)localObject2).add(localObject3);
              }
            }
            m += 1;
            continue;
          }
          localObject1 = this;
          localObject3 = this$0;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = list;
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          localObject1 = list;
          localObject4 = localObject1;
          i3 = ((List)localObject1).size();
          n = i3;
          localObject4 = new String[i3];
          localObject1 = localObject2;
          localObject2 = ((List)localObject2).toArray((Object[])localObject4);
          localObject2 = (String[])localObject2;
          localObject1 = localObject2;
          date = ((String[])localObject2);
          m = 0;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = list;
          localObject2 = localObject1;
          Iterator localIterator = ((List)localObject1).iterator();
          bool4 = localIterator.hasNext();
          if (bool4)
          {
            Object localObject5 = localIterator.next();
            localObject5 = (String)localObject5;
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject1 = datelist;
            localObject2 = localObject1;
            ((List)localObject1).add(localObject5);
            m += 1;
            continue;
          }
          localObject1 = this;
          localObject3 = this$0;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject2 = datelist;
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          localObject1 = datelist;
          localObject4 = localObject1;
          i3 = ((List)localObject1).size();
          n = i3;
          localObject4 = new String[i3];
          localObject1 = localObject2;
          localObject2 = ((List)localObject2).toArray((Object[])localObject4);
          localObject2 = (String[])localObject2;
          localObject1 = localObject2;
          date = ((String[])localObject2);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = mdate;
          localObject2 = localObject1;
          localObject3 = new android/widget/ArrayAdapter;
          localObject1 = this;
          localObject1 = this$0;
          localObject4 = localObject1;
          localObject4 = ((ShowUIDAIData)localObject1).getApplicationContext();
          int i4 = 2130903050;
          localObject1 = this;
          localObject1 = this$0;
          localObject1 = date;
          ((ArrayAdapter)localObject3).<init>((Context)localObject4, i4, (Object[])localObject1);
          ((Spinner)localObject2).setAdapter((SpinnerAdapter)localObject3);
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          n = monthx;
          int i5 = n;
          i5 = n + 1;
          n = i5;
          monthx = i5;
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          bool4 = ((ShowUIDAIData)localObject1).isConnected();
          if (bool4)
          {
            localObject2 = new in/gov/mgov/ors/ShowUIDAIData$CallListagain;
            localObject1 = this;
            localObject1 = this$0;
            localObject3 = localObject1;
            i3 = 0;
            localObject4 = null;
            ((ShowUIDAIData.CallListagain)localObject2).<init>((ShowUIDAIData)localObject1, null);
            i5 = 1;
            n = i5;
            localObject1 = new String[i5];
            localObject3 = localObject1;
            i3 = 0;
            localObject4 = null;
            String str3 = "getAvailabledatelist";
            localObject1[0] = str3;
            ((ShowUIDAIData.CallListagain)localObject2).execute((Object[])localObject1);
          }
        }
        localObject1 = this;
        localObject1 = this$0;
        localObject2 = localObject1;
        localObject2 = ShowUIDAIData.access$200((ShowUIDAIData)localObject1);
        localObject3 = "fixAppointment";
        boolean bool4 = ((String)localObject2).equals(localObject3);
        if (bool4)
        {
          localObject1 = this;
          localObject1 = this$0;
          localObject2 = localObject1;
          localObject1 = finalresp;
          localObject2 = localObject1;
          localObject3 = "{}";
          bool4 = ((String)localObject1).equals(localObject3);
          if (bool4)
          {
            localObject1 = this;
            localObject2 = this$0;
            localObject1 = this;
            localObject1 = this$0;
            localObject3 = localObject1;
            localObject3 = ((ShowUIDAIData)localObject1).getResources();
            i3 = 2131034334;
            localObject3 = ((Resources)localObject3).getString(i3);
            ShowUIDAIData.access$700((ShowUIDAIData)localObject2, (String)localObject3);
          }
          localObject2 = "error_code";
          localObject1 = localObject2;
          localObject2 = localJSONObject1.getString((String)localObject2);
          localObject3 = "0";
          bool4 = ((String)localObject2).equals(localObject3);
          if (bool4)
          {
            Intent localIntent = new android/content/Intent;
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject2 = ((ShowUIDAIData)localObject1).getApplicationContext();
            localObject3 = ShowAppointment.class;
            localObject1 = localObject2;
            localIntent.<init>((Context)localObject2, (Class)localObject3);
            localObject2 = "uid_data";
            localObject1 = this;
            localObject1 = this$0;
            localObject3 = localObject1;
            localObject3 = uidData;
            localObject1 = localObject2;
            localIntent.putExtra((String)localObject2, (String[])localObject3);
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject2 = editor;
            localObject3 = "appointment_id";
            localObject4 = "appointment_id";
            localObject1 = localObject4;
            localObject4 = localJSONObject1.getString((String)localObject4);
            localObject2 = ((SharedPreferences.Editor)localObject2).putString((String)localObject3, (String)localObject4);
            ((SharedPreferences.Editor)localObject2).commit();
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            localObject2 = editor;
            localObject3 = "hid_data";
            localObject4 = "hid";
            localObject1 = localObject4;
            localObject4 = localJSONObject1.getString((String)localObject4);
            localObject2 = ((SharedPreferences.Editor)localObject2).putString((String)localObject3, (String)localObject4);
            ((SharedPreferences.Editor)localObject2).commit();
            localObject2 = "from";
            localObject3 = "fromaadhaar";
            localObject1 = localObject2;
            localIntent.putExtra((String)localObject2, (String)localObject3);
            localObject1 = this;
            localObject1 = this$0;
            localObject2 = localObject1;
            ((ShowUIDAIData)localObject1).startActivity(localIntent);
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        JSONObject localJSONObject1;
        Object localObject3;
        continue;
      }
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject3 = new in/gov/mgov/ors/ShowUIDAIData$CallList$1;
      localObject1 = localObject3;
      ((ShowUIDAIData.CallList.1)localObject3).<init>(this, localJSONObject1);
      ((ShowUIDAIData)localObject2).runOnUiThread((Runnable)localObject3);
    }
  }
  
  protected void onPreExecute()
  {
    int i = 1;
    super.onPreExecute();
    ProgressDialog localProgressDialog = new android/app/ProgressDialog;
    Object localObject = this$0;
    localProgressDialog.<init>((Context)localObject);
    dlog = localProgressDialog;
    localProgressDialog = dlog;
    localObject = this$0.getResources().getString(2131034289);
    localProgressDialog.setTitle((CharSequence)localObject);
    localProgressDialog = dlog;
    localObject = this$0.getResources();
    int j = 2131034151;
    localObject = ((Resources)localObject).getString(j);
    localProgressDialog.setMessage((CharSequence)localObject);
    int k = Build.VERSION.SDK_INT;
    int m = 11;
    if (k >= m)
    {
      dlog.setProgressStyle(i);
      dlog.setIndeterminate(i);
      dlog.setProgressNumberFormat(null);
      localProgressDialog = dlog;
      localProgressDialog.setProgressPercentFormat(null);
    }
    dlog.setCancelable(false);
    dlog.show();
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ShowUIDAIData$CallList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */