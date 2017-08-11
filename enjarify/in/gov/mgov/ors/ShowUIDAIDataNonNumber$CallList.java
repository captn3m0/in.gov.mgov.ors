package in.gov.mgov.ors;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import in.gov.mgov.helper.GetStateData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

class ShowUIDAIDataNonNumber$CallList
  extends AsyncTask
{
  private ProgressDialog dlog;
  
  private ShowUIDAIDataNonNumber$CallList(ShowUIDAIDataNonNumber paramShowUIDAIDataNonNumber) {}
  
  private PropertyInfo addProperties(String paramString, int paramInt, Object paramObject)
  {
    PropertyInfo localPropertyInfo = new org/ksoap2/serialization/PropertyInfo;
    localPropertyInfo.<init>();
    localPropertyInfo.setName(paramString);
    Integer localInteger = Integer.valueOf(paramInt);
    localPropertyInfo.setValue(localInteger);
    localPropertyInfo.setType(paramObject);
    return localPropertyInfo;
  }
  
  private PropertyInfo addProperties(String paramString, Boolean paramBoolean, Object paramObject)
  {
    PropertyInfo localPropertyInfo = new org/ksoap2/serialization/PropertyInfo;
    localPropertyInfo.<init>();
    localPropertyInfo.setName(paramString);
    localPropertyInfo.setValue(paramBoolean);
    localPropertyInfo.setType(paramObject);
    return localPropertyInfo;
  }
  
  private PropertyInfo addProperties(String paramString1, String paramString2, Object paramObject)
  {
    PropertyInfo localPropertyInfo = new org/ksoap2/serialization/PropertyInfo;
    localPropertyInfo.<init>();
    localPropertyInfo.setName(paramString1);
    localPropertyInfo.setValue(paramString2);
    localPropertyInfo.setType(paramObject);
    return localPropertyInfo;
  }
  
  protected String doInBackground(String... paramVarArgs)
  {
    localObject1 = this;
    localObject1 = this$0;
    localObject2 = localObject1;
    int i = 0;
    localObject3 = paramVarArgs[0];
    ShowUIDAIDataNonNumber.access$102((ShowUIDAIDataNonNumber)localObject1, (String)localObject3);
    SoapObject localSoapObject = new org/ksoap2/serialization/SoapObject;
    localObject1 = this;
    localObject1 = this$0;
    localObject3 = localObject1;
    localObject3 = ShowUIDAIDataNonNumber.access$100((ShowUIDAIDataNonNumber)localObject1);
    localObject1 = localSoapObject;
    localObject4 = "http://orsws/";
    Object localObject5 = localObject3;
    localSoapObject.<init>((String)localObject4, (String)localObject3);
    localObject1 = this;
    localObject1 = this$0;
    localObject2 = localObject1;
    localObject2 = ShowUIDAIDataNonNumber.access$100((ShowUIDAIDataNonNumber)localObject1);
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
      bool = false;
      localObject2 = Integer.valueOf(0);
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
    localObject2 = ShowUIDAIDataNonNumber.access$100((ShowUIDAIDataNonNumber)localObject1);
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
      localObject3 = "Male";
      bool = ((String)localObject2).equals(localObject3);
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
      localObject3 = "Female";
      bool = ((String)localObject2).equals(localObject3);
      if (bool) {
        str1 = "2";
      }
      localObject1 = this;
      localObject1 = this$0;
      localObject2 = localObject1;
      localObject1 = uidData;
      localObject2 = localObject1;
      String str2 = localObject1[5];
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
      m = i;
      int n = Integer.parseInt(((String)localObject6).substring(j, i));
      j = str4.length() + -4;
      i = str4.length();
      k = j;
      m = i;
      int i1 = Integer.parseInt(str4.substring(j, i));
      j = ((String)localObject6).length() + -4;
      i = ((String)localObject6).length();
      k = j;
      m = i;
      String str5 = ((String)localObject6).substring(j, i);
      j = ((String)localObject6).length() + -7;
      i = ((String)localObject6).length() + -5;
      k = j;
      m = i;
      String str6 = ((String)localObject6).substring(j, i);
      j = 0;
      m = 2;
      String str7 = ((String)localObject6).substring(0, m);
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      i = i1 - n;
      String str8 = i + "";
      localObject1 = this;
      localObject4 = "flagtp";
      int i2 = 2;
      Object localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, i2, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "intoken";
      localObject5 = "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      localObject1 = uidData;
      localObject3 = localObject1;
      localObject3 = localObject1[0].replaceAll(" ", "^");
      localObject1 = this;
      localObject4 = "inpatientname";
      localObject5 = localObject3;
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject3, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "ingender";
      localObject5 = String.class;
      localObject2 = addProperties((String)localObject4, str1, localObject5);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "inpaddress";
      localObject5 = String.class;
      localObject2 = addProperties((String)localObject4, str2, localObject5);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>();
      localObject1 = localObject3;
      localObject4 = str5;
      localObject3 = ((StringBuilder)localObject3).append(str5).append("-");
      localObject1 = localObject3;
      localObject4 = str6;
      localObject3 = ((StringBuilder)localObject3).append(str6).append("-");
      localObject1 = localObject3;
      localObject3 = str7;
      localObject1 = this;
      localObject4 = "indob";
      localObject5 = localObject3;
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject3, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject3 = new in/gov/mgov/helper/GetStateData;
      ((GetStateData)localObject3).<init>();
      localObject1 = this;
      localObject1 = this$0;
      Object localObject8 = localObject1;
      localObject8 = uidData;
      localObject1 = this;
      k = this$0.uidData.length;
      int i3 = k;
      i3 = k + -1;
      localObject8 = localObject8[i3];
      i = ((GetStateData)localObject3).getStateCode((String)localObject8);
      localObject1 = this;
      localObject4 = "instatecode";
      i2 = i;
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, i, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "incountrycode";
      i2 = 91;
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, i2, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      localObject1 = uidData;
      localObject3 = localObject1;
      localObject3 = localObject1[3];
      localObject1 = this;
      localObject4 = "inmobileno";
      localObject5 = localObject3;
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject3, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "inemail";
      localObject5 = "";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "inbillingtype";
      i2 = 1;
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, i2, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "inreligion";
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, 0, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      k = hospitalcode;
      i = k;
      localObject1 = this;
      localObject4 = "inhospitalid";
      i2 = k;
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, k, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "inentfrom";
      localObject5 = "0.0.0.0";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      localObject1 = uidData;
      localObject3 = localObject1;
      localObject3 = localObject1[4];
      localObject1 = this;
      localObject4 = "infathername";
      localObject5 = localObject3;
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject3, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "inmothername";
      localObject5 = "";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "inpatrelstr";
      localObject5 = "c/o";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "inbplverifiedby";
      localObject5 = "";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "inothersdetails";
      localObject5 = "";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "injaildetails";
      localObject5 = "";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "incghscardno";
      localObject5 = "";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>();
      localObject1 = localObject3;
      localObject3 = str8 + " years";
      localObject1 = this;
      localObject4 = "inage";
      localObject5 = localObject3;
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject3, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "newfollowup";
      localObject5 = "0";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "birthorder";
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, 0, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "parity";
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, 0, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "gravida";
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, 0, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "pragnancyindicator";
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, 0, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "durationofpragnancy";
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, 0, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "prvregno";
      localObject5 = "";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      localObject3 = aadhaarno;
      localObject1 = this;
      localObject4 = "inaadhaarId";
      localObject5 = localObject3;
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject3, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "inaadhaarImg";
      localObject5 = "";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      k = hospitalcode;
      i = k;
      localObject1 = this;
      localObject4 = "hosid";
      i2 = k;
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, k, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      k = departmentcode;
      i = k;
      localObject1 = this;
      localObject4 = "deptid";
      i2 = k;
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, k, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "unitid";
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, 0, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "clinicid";
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, 0, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "roomid";
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, 0, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "docid";
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, 0, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      localObject3 = appdate;
      localObject1 = this;
      localObject4 = "appdate";
      localObject5 = localObject3;
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject3, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "regno";
      localObject5 = "";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "tmpappid";
      localObject5 = "0";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "uid";
      i2 = 99999;
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, i2, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "entsystem";
      localObject5 = "0.0.0.0";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "apptype";
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, 0, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "appcat";
      i2 = 0;
      localObject7 = Integer.class;
      localObject2 = addProperties((String)localObject4, 0, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "apptimestr";
      localObject5 = "8 AM";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "isautodoc";
      localObject5 = "Y";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "iswithuhid";
      localObject5 = "N";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "contextPath";
      localObject5 = "";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject1 = this$0;
      localObject3 = localObject1;
      localObject1 = uidData;
      localObject3 = localObject1;
      int i4 = 3;
      localObject3 = localObject1[i4];
      localObject1 = this;
      localObject4 = "mblno";
      localObject5 = localObject3;
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject3, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "email";
      localObject5 = "";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      i = 0;
      localObject3 = Boolean.valueOf(false);
      localObject1 = this;
      localObject4 = "ispayonline";
      localObject5 = localObject3;
      localObject7 = Boolean.class;
      localObject2 = addProperties((String)localObject4, (Boolean)localObject3, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject1 = this;
      localObject4 = "hid";
      localObject5 = "";
      localObject7 = String.class;
      localObject2 = addProperties((String)localObject4, (String)localObject5, localObject7);
      localObject1 = localSoapObject;
      localObject4 = localObject2;
      localSoapObject.addProperty((PropertyInfo)localObject2);
      localObject3 = "";
      localObject8 = String.class;
      localObject1 = this;
      localObject4 = "hidavailable";
      localObject5 = localObject3;
      localObject7 = localObject8;
      localObject2 = addProperties((String)localObject4, (String)localObject3, localObject8);
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
    int m = i;
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
        localObject1 = this;
        localObject2 = this$0;
        localObject3 = new in/gov/mgov/ors/ShowUIDAIDataNonNumber$CallList$1;
        localObject1 = localObject3;
        localObject4 = this;
        ((ShowUIDAIDataNonNumber.CallList.1)localObject3).<init>(this);
        ((ShowUIDAIDataNonNumber)localObject2).runOnUiThread((Runnable)localObject3);
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
    localObject1 = dlog;
    boolean bool1 = ((ProgressDialog)localObject1).isShowing();
    if (bool1)
    {
      localObject1 = dlog;
      ((ProgressDialog)localObject1).dismiss();
    }
    for (;;)
    {
      try
      {
        localJSONObject1 = new org/json/JSONObject;
        localJSONObject1.<init>(paramString);
        localObject1 = this$0;
        localObject1 = ShowUIDAIDataNonNumber.access$100((ShowUIDAIDataNonNumber)localObject1);
        localObject2 = "getAvailabledatelist";
        bool1 = ((String)localObject1).equals(localObject2);
        int j;
        Object localObject3;
        if (bool1)
        {
          localObject1 = this$0;
          localObject1 = list;
          ((List)localObject1).clear();
          localObject1 = this$0;
          localObject1 = id;
          ((List)localObject1).clear();
          localObject1 = "data";
          localObject1 = localJSONObject1.get((String)localObject1);
          String str = localObject1.toString();
          JSONObject localJSONObject2 = new org/json/JSONObject;
          localJSONObject2.<init>(str);
          localObject1 = "calenderData";
          JSONArray localJSONArray = localJSONObject2.optJSONArray((String)localObject1);
          localObject1 = this$0;
          localObject1 = list;
          localObject2 = this$0;
          localObject2 = ((ShowUIDAIDataNonNumber)localObject2).getResources();
          j = 2131034302;
          localObject2 = ((Resources)localObject2).getString(j);
          ((List)localObject1).add(localObject2);
          localObject1 = this$0;
          localObject1 = id;
          localObject2 = "0";
          ((List)localObject1).add(localObject2);
          int k = 0;
          int i = localJSONArray.length();
          if (k < i)
          {
            int m = 0;
            JSONObject localJSONObject3 = localJSONArray.getJSONObject(k);
            localObject1 = "flag";
            localObject1 = localJSONObject3.getString((String)localObject1);
            localObject2 = "4";
            bool2 = ((String)localObject1).equals(localObject2);
            if (bool2) {
              m = 1;
            }
            localObject1 = "flag";
            localObject1 = localJSONObject3.getString((String)localObject1);
            localObject2 = "2";
            bool2 = ((String)localObject1).equals(localObject2);
            if (bool2) {
              m = 1;
            }
            if (m == 0)
            {
              localObject1 = this$0;
              localObject1 = list;
              localObject2 = "app_date_";
              localObject2 = localJSONObject3.getString((String)localObject2);
              ((List)localObject1).add(localObject2);
            }
            k += 1;
            continue;
          }
          localObject2 = this$0;
          localObject1 = this$0;
          localObject1 = list;
          localObject3 = this$0;
          localObject3 = list;
          j = ((List)localObject3).size();
          localObject3 = new String[j];
          localObject1 = ((List)localObject1).toArray((Object[])localObject3);
          localObject1 = (String[])localObject1;
          date = ((String[])localObject1);
        }
        localObject1 = this$0;
        localObject1 = ShowUIDAIDataNonNumber.access$100((ShowUIDAIDataNonNumber)localObject1);
        localObject2 = "fixAppointment";
        boolean bool2 = ((String)localObject1).equals(localObject2);
        if (bool2)
        {
          localObject1 = this$0;
          localObject1 = finalresp;
          localObject2 = "{}";
          bool2 = ((String)localObject1).equals(localObject2);
          if (bool2)
          {
            localObject1 = this$0;
            localObject2 = this$0;
            localObject2 = ((ShowUIDAIDataNonNumber)localObject2).getResources();
            j = 2131034334;
            localObject2 = ((Resources)localObject2).getString(j);
            ShowUIDAIDataNonNumber.access$200((ShowUIDAIDataNonNumber)localObject1, (String)localObject2);
          }
          localObject1 = "error_code";
          localObject1 = localJSONObject1.getString((String)localObject1);
          localObject2 = "0";
          bool2 = ((String)localObject1).equals(localObject2);
          if (bool2)
          {
            Intent localIntent = new android/content/Intent;
            localObject1 = this$0;
            localObject1 = ((ShowUIDAIDataNonNumber)localObject1).getApplicationContext();
            localObject2 = ShowAppointmentNoNumber.class;
            localIntent.<init>((Context)localObject1, (Class)localObject2);
            localObject1 = "uid_data";
            localObject2 = this$0;
            localObject2 = uidData;
            localIntent.putExtra((String)localObject1, (String[])localObject2);
            localObject1 = this$0;
            localObject1 = editor;
            localObject2 = "appointment_id";
            localObject3 = "appointment_id";
            localObject3 = localJSONObject1.getString((String)localObject3);
            localObject1 = ((SharedPreferences.Editor)localObject1).putString((String)localObject2, (String)localObject3);
            ((SharedPreferences.Editor)localObject1).commit();
            localObject1 = this$0;
            localObject1 = editor;
            localObject2 = "hid_data";
            localObject3 = "hid";
            localObject3 = localJSONObject1.getString((String)localObject3);
            localObject1 = ((SharedPreferences.Editor)localObject1).putString((String)localObject2, (String)localObject3);
            ((SharedPreferences.Editor)localObject1).commit();
            localObject1 = this$0;
            ((ShowUIDAIDataNonNumber)localObject1).startActivity(localIntent);
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
        localObject1 = this$0;
        Object localObject2 = new in/gov/mgov/ors/ShowUIDAIDataNonNumber$CallList$3;
        ((ShowUIDAIDataNonNumber.CallList.3)localObject2).<init>(this);
        ((ShowUIDAIDataNonNumber)localObject1).runOnUiThread((Runnable)localObject2);
        continue;
      }
      localObject1 = this$0;
      localObject2 = new in/gov/mgov/ors/ShowUIDAIDataNonNumber$CallList$2;
      ((ShowUIDAIDataNonNumber.CallList.2)localObject2).<init>(this, localJSONObject1);
      ((ShowUIDAIDataNonNumber)localObject1).runOnUiThread((Runnable)localObject2);
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
    int j = 2131034207;
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


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/ShowUIDAIDataNonNumber$CallList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */