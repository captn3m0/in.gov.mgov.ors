package in.gov.mgov.ors;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.widget.EditText;
import java.io.Reader;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

class MainActivity$AsyncTaskRunner
  extends AsyncTask
{
  private ProgressDialog dlog;
  private String resp;
  
  private MainActivity$AsyncTaskRunner(MainActivity paramMainActivity) {}
  
  protected String doInBackground(String... paramVarArgs)
  {
    localObject1 = new String[1];
    localObject2 = this;
    localObject2 = this$0;
    Object localObject3 = localObject2;
    localObject3 = ((MainActivity)localObject2).getResources();
    int i = 2131034226;
    localObject3 = ((Resources)localObject3).getString(i);
    localObject1[0] = localObject3;
    localObject2 = this;
    localObject4 = localObject1;
    publishProgress((Object[])localObject1);
    localObject1 = this$0;
    int j = 0;
    int k = 0;
    localObject2 = null;
    localObject4 = localObject1;
    vaild = false;
    localObject1 = paramVarArgs[0];
    localObject5 = "getRawOTP";
    boolean bool = ((String)localObject1).equals(localObject5);
    SoapObject localSoapObject;
    Class localClass;
    SoapSerializationEnvelope localSoapSerializationEnvelope;
    HttpTransportSE localHttpTransportSE;
    if (bool)
    {
      localSoapObject = new org/ksoap2/serialization/SoapObject;
      localObject2 = this;
      localObject2 = this$0;
      localObject1 = localObject2;
      localObject1 = MainActivity.access$400((MainActivity)localObject2);
      localObject2 = this;
      localObject2 = this$0;
      localObject5 = localObject2;
      localObject5 = MainActivity.access$100((MainActivity)localObject2);
      localObject2 = localSoapObject;
      localObject4 = localObject1;
      localSoapObject.<init>((String)localObject1, (String)localObject5);
      localObject2 = this;
      localObject1 = this$0;
      j = 0;
      localObject5 = paramVarArgs[0];
      localObject2 = localObject5;
      localObject4 = localObject1;
      check = ((String)localObject5);
      localObject1 = paramVarArgs[0];
      localObject5 = "aadhaar";
      bool = ((String)localObject1).equals(localObject5);
      PropertyInfo localPropertyInfo1;
      if (bool)
      {
        localPropertyInfo1 = new org/ksoap2/serialization/PropertyInfo;
        localPropertyInfo1.<init>();
        localObject2 = "aadhaar";
        localPropertyInfo1.setName((String)localObject2);
        localObject2 = this;
        localObject2 = this$0;
        localObject1 = localObject2;
        localObject2 = aadhaar;
        localObject1 = localObject2;
        localObject1 = ((EditText)localObject2).getText().toString();
        localObject2 = localObject1;
        localPropertyInfo1.setValue(localObject1);
        localObject1 = String.class;
        localObject2 = localObject1;
        localPropertyInfo1.setType(localObject1);
        localObject2 = localSoapObject;
        localSoapObject.addProperty(localPropertyInfo1);
      }
      localObject1 = paramVarArgs[0];
      localObject5 = "otp";
      bool = ((String)localObject1).equals(localObject5);
      if (bool)
      {
        PropertyInfo localPropertyInfo2 = new org/ksoap2/serialization/PropertyInfo;
        localPropertyInfo2.<init>();
        localObject2 = localPropertyInfo2;
        localObject4 = "otp";
        localPropertyInfo2.setName((String)localObject4);
        localObject2 = this;
        localObject2 = this$0;
        localObject1 = localObject2;
        localObject2 = otp;
        localObject1 = localObject2;
        localObject1 = ((EditText)localObject2).getText().toString();
        localObject2 = localPropertyInfo2;
        localObject4 = localObject1;
        localPropertyInfo2.setValue(localObject1);
        localObject4 = String.class;
        localPropertyInfo2.setType(localObject4);
        localObject2 = localSoapObject;
        localObject4 = localPropertyInfo2;
        localSoapObject.addProperty(localPropertyInfo2);
        localPropertyInfo1 = new org/ksoap2/serialization/PropertyInfo;
        localPropertyInfo1.<init>();
        localObject2 = "aadhaar";
        localPropertyInfo1.setName((String)localObject2);
        localObject2 = this;
        localObject2 = this$0;
        localObject1 = localObject2;
        localObject2 = aadhaar;
        localObject1 = localObject2;
        localObject1 = ((EditText)localObject2).getText().toString();
        localObject2 = localObject1;
        localPropertyInfo1.setValue(localObject1);
        localObject1 = String.class;
        localObject2 = localObject1;
        localPropertyInfo1.setType(localObject1);
        localObject2 = localSoapObject;
        localSoapObject.addProperty(localPropertyInfo1);
      }
      localObject1 = paramVarArgs[0];
      localObject5 = "AuthUsingName";
      bool = ((String)localObject1).equals(localObject5);
      if (bool)
      {
        localObject2 = this;
        localObject1 = this$0;
        localObject2 = this;
        localObject2 = this$0;
        localObject3 = localObject2;
        localObject2 = aadhaar_name;
        localObject3 = localObject2;
        localObject3 = ((EditText)localObject2).getText().toString();
        localObject1 = MainActivity.access$500((MainActivity)localObject1, "name", (String)localObject3, String.class);
        localObject2 = localSoapObject;
        localObject4 = localObject1;
        localSoapObject.addProperty((PropertyInfo)localObject1);
        localObject2 = this;
        localObject1 = this$0;
        localObject5 = "aadhaar";
        localObject2 = this;
        localObject2 = this$0;
        localObject3 = localObject2;
        localObject2 = aadhaar;
        localObject3 = localObject2;
        localObject3 = ((EditText)localObject2).getText().toString();
        localClass = String.class;
        localObject1 = MainActivity.access$500((MainActivity)localObject1, (String)localObject5, (String)localObject3, localClass);
        localObject2 = localSoapObject;
        localObject4 = localObject1;
        localSoapObject.addProperty((PropertyInfo)localObject1);
      }
      localObject1 = paramVarArgs[0];
      localObject5 = "getRawOTP";
      bool = ((String)localObject1).equals(localObject5);
      if (bool)
      {
        localObject2 = this;
        localObject1 = this$0;
        localObject2 = this;
        localObject2 = this$0;
        localObject3 = localObject2;
        localObject2 = aadhaar_name_number;
        localObject3 = localObject2;
        localObject3 = ((EditText)localObject2).getText().toString();
        localObject1 = MainActivity.access$500((MainActivity)localObject1, "mobileno", (String)localObject3, String.class);
        localObject2 = localSoapObject;
        localObject4 = localObject1;
        localSoapObject.addProperty((PropertyInfo)localObject1);
        localObject2 = this;
        localObject2 = this$0;
        localObject1 = localObject2;
        localObject1 = MainActivity.access$500((MainActivity)localObject2, "userid", "mobileappors", String.class);
        localObject2 = localSoapObject;
        localObject4 = localObject1;
        localSoapObject.addProperty((PropertyInfo)localObject1);
        localObject2 = this;
        localObject2 = this$0;
        localObject1 = localObject2;
        localObject5 = "intoken";
        localObject3 = "dG9rZW5Ad2ViQGFwcG9pbnQjbmlj";
        localClass = String.class;
        localObject1 = MainActivity.access$500((MainActivity)localObject2, (String)localObject5, (String)localObject3, localClass);
        localObject2 = localSoapObject;
        localObject4 = localObject1;
        localSoapObject.addProperty((PropertyInfo)localObject1);
      }
      localObject1 = paramVarArgs[0];
      localObject5 = "getRawOTP";
      bool = ((String)localObject1).equals(localObject5);
      if (!bool)
      {
        PropertyInfo localPropertyInfo3 = new org/ksoap2/serialization/PropertyInfo;
        localPropertyInfo3.<init>();
        localObject2 = localPropertyInfo3;
        localObject4 = "tokenType";
        localPropertyInfo3.setName((String)localObject4);
        localObject4 = "TP";
        localPropertyInfo3.setValue(localObject4);
        localObject4 = String.class;
        localPropertyInfo3.setType(localObject4);
        localObject2 = localSoapObject;
        localObject4 = localPropertyInfo3;
        localSoapObject.addProperty(localPropertyInfo3);
        PropertyInfo localPropertyInfo4 = new org/ksoap2/serialization/PropertyInfo;
        localPropertyInfo4.<init>();
        localObject2 = localPropertyInfo4;
        localObject4 = "token";
        localPropertyInfo4.setName((String)localObject4);
        localObject4 = "dd951891b72c317e8b94a7a6d54b57b0";
        localPropertyInfo4.setValue(localObject4);
        localObject1 = String.class;
        localObject4 = localObject1;
        localPropertyInfo4.setType(localObject1);
        localObject2 = localSoapObject;
        localObject4 = localPropertyInfo4;
        localSoapObject.addProperty(localPropertyInfo4);
      }
      localSoapSerializationEnvelope = new org/ksoap2/serialization/SoapSerializationEnvelope;
      k = 110;
      localSoapSerializationEnvelope.<init>(k);
      localObject2 = localSoapObject;
      localSoapSerializationEnvelope.setOutputSoapObject(localSoapObject);
      localObject2 = this;
      localObject2 = this$0;
      localObject1 = localObject2;
      localObject1 = MainActivity.access$100((MainActivity)localObject2);
      localObject5 = "getRawOTP";
      bool = ((String)localObject1).equals(localObject5);
      if (!bool) {
        break label2679;
      }
      localHttpTransportSE = new org/ksoap2/transport/HttpTransportSE;
      localObject1 = "http://ors.gov.in/ORSServicecontainer/services?wsdl";
      j = 60000;
      localObject2 = localObject1;
      localHttpTransportSE.<init>((String)localObject1, j);
      label966:
      bool = false;
      localObject1 = null;
    }
    for (;;)
    {
      try
      {
        localObject1 = paramVarArgs[0];
        localObject5 = "getRawOTP";
        bool = ((String)localObject1).equals(localObject5);
        if (!bool) {
          continue;
        }
        localObject2 = this;
        localObject2 = this$0;
        localObject1 = localObject2;
        localObject1 = MainActivity.access$400((MainActivity)localObject2);
        localObject2 = localObject1;
        localHttpTransportSE.call((String)localObject1, localSoapSerializationEnvelope);
        Object localObject6 = localSoapSerializationEnvelope.getResponse();
        localObject6 = (SoapPrimitive)localObject6;
        localObject2 = this;
        localObject2 = this$0;
        localObject1 = localObject2;
        localObject5 = ((SoapPrimitive)localObject6).toString();
        localObject2 = localObject5;
        localObject4 = localObject1;
        finalresp = ((String)localObject5);
        localObject1 = ((SoapPrimitive)localObject6).toString();
        localObject5 = "\"y\"";
        bool = ((String)localObject1).contains((CharSequence)localObject5);
        if (bool)
        {
          localObject2 = this;
          localObject2 = this$0;
          localObject1 = localObject2;
          localObject5 = new in/gov/mgov/ors/MainActivity$AsyncTaskRunner$1;
          localObject2 = localObject5;
          localObject4 = this;
          ((MainActivity.AsyncTaskRunner.1)localObject5).<init>(this, paramVarArgs);
          ((MainActivity)localObject1).runOnUiThread((Runnable)localObject5);
        }
        bool = false;
        localObject1 = null;
        localObject1 = paramVarArgs[0];
        localObject5 = "aadhaar";
        bool = ((String)localObject1).equals(localObject5);
        if (bool)
        {
          localObject2 = this;
          localObject2 = this$0;
          localObject1 = localObject2;
          localObject2 = finalresp;
          localObject1 = localObject2;
          localObject5 = "\"ret\":\"n\"";
          bool = ((String)localObject2).contains((CharSequence)localObject5);
          if (bool)
          {
            localObject2 = this;
            localObject2 = this$0;
            localObject1 = localObject2;
            localObject5 = new in/gov/mgov/ors/MainActivity$AsyncTaskRunner$2;
            localObject2 = localObject5;
            localObject4 = this;
            ((MainActivity.AsyncTaskRunner.2)localObject5).<init>(this, paramVarArgs);
            ((MainActivity)localObject1).runOnUiThread((Runnable)localObject5);
          }
        }
        bool = false;
        localObject1 = null;
        localObject1 = paramVarArgs[0];
        localObject5 = "AuthUsingName";
        bool = ((String)localObject1).equals(localObject5);
        if (bool)
        {
          localObject2 = this;
          localObject2 = this$0;
          localObject1 = localObject2;
          localObject2 = finalresp;
          localObject1 = localObject2;
          localObject5 = "\"ret\":\"n\"";
          bool = ((String)localObject2).contains((CharSequence)localObject5);
          if (bool)
          {
            localObject2 = this;
            localObject2 = this$0;
            localObject1 = localObject2;
            localObject5 = new in/gov/mgov/ors/MainActivity$AsyncTaskRunner$3;
            localObject2 = localObject5;
            localObject4 = this;
            ((MainActivity.AsyncTaskRunner.3)localObject5).<init>(this);
            ((MainActivity)localObject1).runOnUiThread((Runnable)localObject5);
          }
        }
        bool = false;
        localObject1 = null;
        localObject1 = paramVarArgs[0];
        localObject5 = "AuthUsingName";
        bool = ((String)localObject1).equals(localObject5);
        if (bool)
        {
          localObject2 = this;
          localObject2 = this$0;
          localObject1 = localObject2;
          localObject2 = finalresp;
          localObject1 = localObject2;
          localObject5 = "\"ret\":\"y\"";
          bool = ((String)localObject2).contains((CharSequence)localObject5);
          if (bool)
          {
            localObject2 = this;
            localObject2 = this$0;
            localObject1 = localObject2;
            localObject5 = new in/gov/mgov/ors/MainActivity$AsyncTaskRunner$4;
            localObject2 = localObject5;
            localObject4 = this;
            ((MainActivity.AsyncTaskRunner.4)localObject5).<init>(this);
            ((MainActivity)localObject1).runOnUiThread((Runnable)localObject5);
          }
        }
        localObject2 = this;
        localObject2 = this$0;
        localObject1 = localObject2;
        localObject1 = MainActivity.access$100((MainActivity)localObject2);
        localObject5 = "getRawOTP";
        bool = ((String)localObject1).equals(localObject5);
        if (bool)
        {
          JSONObject localJSONObject = new org/json/JSONObject;
          localObject2 = this;
          localObject2 = this$0;
          localObject1 = localObject2;
          localObject1 = finalresp;
          localObject2 = localJSONObject;
          localObject4 = localObject1;
          localJSONObject.<init>((String)localObject1);
          localObject1 = "status";
          localObject4 = localObject1;
          localObject1 = localJSONObject.getString((String)localObject1);
          localObject5 = "Y";
          bool = ((String)localObject1).equalsIgnoreCase((String)localObject5);
          if (bool)
          {
            localObject2 = this;
            localObject2 = this$0;
            localObject1 = localObject2;
            localObject5 = new in/gov/mgov/ors/MainActivity$AsyncTaskRunner$5;
            localObject2 = localObject5;
            localObject4 = this;
            ((MainActivity.AsyncTaskRunner.5)localObject5).<init>(this, localJSONObject, paramVarArgs);
            ((MainActivity)localObject1).runOnUiThread((Runnable)localObject5);
          }
        }
        bool = false;
        localObject1 = null;
        localObject1 = paramVarArgs[0];
        localObject5 = "otp";
        bool = ((String)localObject1).equals(localObject5);
        if (bool)
        {
          localObject2 = this;
          localObject2 = this$0;
          localObject1 = localObject2;
          localObject2 = finalresp;
          localObject1 = localObject2;
          localObject5 = "ret=\"N\"";
          bool = ((String)localObject2).contains((CharSequence)localObject5);
          if (bool)
          {
            localObject2 = this;
            localObject2 = this$0;
            localObject1 = localObject2;
            localObject2 = finalresp;
            localObject1 = localObject2;
            localObject5 = "err=\"K-100\"";
            bool = ((String)localObject2).contains((CharSequence)localObject5);
            if (!bool) {
              continue;
            }
            localObject2 = this;
            localObject2 = this$0;
            localObject1 = localObject2;
            localObject5 = new in/gov/mgov/ors/MainActivity$AsyncTaskRunner$6;
            localObject2 = localObject5;
            localObject4 = this;
            ((MainActivity.AsyncTaskRunner.6)localObject5).<init>(this, paramVarArgs);
            ((MainActivity)localObject1).runOnUiThread((Runnable)localObject5);
          }
        }
      }
      catch (Exception localException1)
      {
        label2679:
        localObject2 = this;
        localObject1 = this$0;
        localObject5 = new in/gov/mgov/ors/MainActivity$AsyncTaskRunner$9;
        localObject2 = localObject5;
        localObject4 = this;
        ((MainActivity.AsyncTaskRunner.9)localObject5).<init>(this);
        ((MainActivity)localObject1).runOnUiThread((Runnable)localObject5);
        localException1.printStackTrace();
        continue;
        localObject2 = this;
        localObject2 = this$0;
        localObject1 = localObject2;
        localObject5 = new in/gov/mgov/ors/MainActivity$AsyncTaskRunner$7;
        localObject2 = localObject5;
        localObject4 = this;
        ((MainActivity.AsyncTaskRunner.7)localObject5).<init>(this, paramVarArgs);
        ((MainActivity)localObject1).runOnUiThread((Runnable)localObject5);
        continue;
      }
      bool = false;
      localObject1 = null;
      localObject1 = paramVarArgs[0];
      localObject5 = "otp";
      bool = ((String)localObject1).equals(localObject5);
      if (bool)
      {
        localObject2 = this;
        localObject2 = this$0;
        localObject1 = localObject2;
        localObject2 = finalresp;
        localObject1 = localObject2;
        localObject5 = "ret=\"Y\"";
        bool = ((String)localObject2).contains((CharSequence)localObject5);
        if (bool)
        {
          localObject2 = this;
          localObject2 = this$0;
          localObject1 = localObject2;
          j = 1;
          k = j;
          localObject4 = localObject2;
          vaild = j;
          m = 27;
          k = m;
          localObject2 = new String[m];
          localObject7 = localObject2;
        }
      }
      for (;;)
      {
        try
        {
          localObject1 = DocumentBuilderFactory.newInstance();
          DocumentBuilder localDocumentBuilder = ((DocumentBuilderFactory)localObject1).newDocumentBuilder();
          InputSource localInputSource = new org/xml/sax/InputSource;
          localInputSource.<init>();
          localObject1 = new java/io/StringReader;
          localObject2 = this;
          localObject2 = this$0;
          localObject5 = localObject2;
          localObject2 = finalresp;
          localObject5 = localObject2;
          ((StringReader)localObject1).<init>((String)localObject2);
          localObject2 = localInputSource;
          localObject4 = localObject1;
          localInputSource.setCharacterStream((Reader)localObject1);
          Document localDocument = localDocumentBuilder.parse(localInputSource);
          Element localElement = localDocument.getDocumentElement();
          localObject2 = this;
          localObject2 = this$0;
          localObject1 = localObject2;
          localObject1 = finalresp;
          localObject2 = localElement;
          localObject4 = localObject1;
          localElement.getAttribute((String)localObject1);
          localObject1 = "Poi";
          localObject4 = localObject1;
          NodeList localNodeList1 = localElement.getElementsByTagName((String)localObject1);
          m = 0;
          localObject1 = null;
          k = 0;
          localObject2 = null;
          localObject8 = localNodeList1.item(0);
          localObject8 = (Element)localObject8;
          localObject1 = "Poa";
          localObject2 = localElement;
          localObject4 = localObject1;
          NodeList localNodeList2 = localElement.getElementsByTagName((String)localObject1);
          m = 0;
          localObject1 = null;
          k = 0;
          localObject2 = null;
          localObject9 = localNodeList2.item(0);
          localObject9 = (Element)localObject9;
          localObject1 = "Pht";
          localObject2 = localElement;
          localObject4 = localObject1;
          NodeList localNodeList3 = localElement.getElementsByTagName((String)localObject1);
          m = 0;
          localObject1 = null;
          k = 0;
          localObject2 = null;
          Object localObject10 = localNodeList3.item(0);
          localObject10 = (Element)localObject10;
          str1 = ((Element)localObject10).getTextContent();
          m = 0;
          localObject1 = null;
          localObject5 = "name";
          localObject2 = localObject5;
          localObject5 = ((Element)localObject8).getAttribute((String)localObject5);
          localObject7[0] = localObject5;
          localObject1 = "dob";
          localObject2 = localObject1;
          str2 = ((Element)localObject8).getAttribute((String)localObject1);
          m = 1;
        }
        catch (Exception localException2)
        {
          Object localObject8;
          Object localObject9;
          String str1;
          String str2;
          localObject2 = this;
          localObject2 = this$0;
          localObject1 = localObject2;
          localObject5 = new in/gov/mgov/ors/MainActivity$AsyncTaskRunner$8;
          localObject2 = localObject5;
          localObject4 = this;
          ((MainActivity.AsyncTaskRunner.8)localObject5).<init>(this);
          ((MainActivity)localObject1).runOnUiThread((Runnable)localObject5);
          continue;
        }
        try
        {
          localObject5 = new java/lang/StringBuilder;
          ((StringBuilder)localObject5).<init>();
          localObject3 = "\\-";
          localObject2 = str2;
          localObject4 = localObject3;
          localObject3 = str2.split((String)localObject3);
          i = 0;
          localClass = null;
          localObject3 = localObject3[0];
          localObject5 = ((StringBuilder)localObject5).append((String)localObject3);
          localObject3 = "-";
          localObject5 = ((StringBuilder)localObject5).append((String)localObject3);
          localObject3 = "\\-";
          localObject4 = localObject3;
          localObject3 = str2.split((String)localObject3);
          i = 1;
          localObject3 = localObject3[i];
          localObject5 = ((StringBuilder)localObject5).append((String)localObject3);
          localObject3 = "-";
          localObject5 = ((StringBuilder)localObject5).append((String)localObject3);
          localObject3 = "\\-";
          localObject4 = localObject3;
          localObject3 = str2.split((String)localObject3);
          i = 2;
          localObject3 = localObject3[i];
          localObject5 = ((StringBuilder)localObject5).append((String)localObject3);
          localObject5 = ((StringBuilder)localObject5).toString();
          localObject7[m] = localObject5;
        }
        catch (Exception localException3)
        {
          m = 1;
          localObject5 = "10-10-2010";
          localObject7[m] = localObject5;
        }
      }
      m = 2;
      localObject5 = "gender";
      localObject2 = localObject5;
      localObject5 = ((Element)localObject8).getAttribute((String)localObject5);
      localObject7[m] = localObject5;
      m = 3;
      localObject5 = "phone";
      localObject2 = localObject5;
      localObject5 = ((Element)localObject8).getAttribute((String)localObject5);
      localObject7[m] = localObject5;
      m = 4;
      localObject5 = "email";
      localObject2 = localObject5;
      localObject5 = ((Element)localObject8).getAttribute((String)localObject5);
      localObject7[m] = localObject5;
      m = 5;
      localObject5 = "co";
      localObject2 = localObject5;
      localObject5 = ((Element)localObject9).getAttribute((String)localObject5);
      localObject7[m] = localObject5;
      m = 6;
      localObject5 = "street";
      localObject2 = localObject5;
      localObject5 = ((Element)localObject9).getAttribute((String)localObject5);
      localObject7[m] = localObject5;
      m = 7;
      localObject5 = "house";
      localObject2 = localObject5;
      localObject5 = ((Element)localObject9).getAttribute((String)localObject5);
      localObject7[m] = localObject5;
      m = 8;
      localObject5 = "lm";
      localObject2 = localObject5;
      localObject5 = ((Element)localObject9).getAttribute((String)localObject5);
      localObject7[m] = localObject5;
      m = 9;
      localObject5 = "loc";
      localObject2 = localObject5;
      localObject5 = ((Element)localObject9).getAttribute((String)localObject5);
      localObject7[m] = localObject5;
      m = 10;
      localObject5 = "vtc";
      localObject2 = localObject5;
      localObject5 = ((Element)localObject9).getAttribute((String)localObject5);
      localObject7[m] = localObject5;
      m = 11;
      localObject5 = "dist";
      localObject2 = localObject5;
      localObject5 = ((Element)localObject9).getAttribute((String)localObject5);
      localObject7[m] = localObject5;
      m = 12;
      localObject5 = "state";
      localObject2 = localObject5;
      localObject5 = ((Element)localObject9).getAttribute((String)localObject5);
      localObject7[m] = localObject5;
      m = 13;
      localObject5 = "pc";
      localObject2 = localObject5;
      localObject5 = ((Element)localObject9).getAttribute((String)localObject5);
      localObject7[m] = localObject5;
      m = 14;
      localObject5 = "po";
      localObject2 = localObject5;
      localObject5 = ((Element)localObject9).getAttribute((String)localObject5);
      localObject7[m] = localObject5;
      m = 15;
      localObject7[m] = str1;
      localObject2 = this;
      localObject1 = this$0;
      localObject2 = localObject7;
      localObject4 = localObject1;
      finalArray = ((String[])localObject7);
      localObject2 = this;
      localObject2 = resp;
      localObject1 = localObject2;
      return (String)localObject2;
      localSoapObject = new org/ksoap2/serialization/SoapObject;
      localObject1 = "http://kycWS/";
      localObject2 = this;
      localObject2 = this$0;
      localObject5 = localObject2;
      localObject5 = MainActivity.access$100((MainActivity)localObject2);
      localObject2 = localSoapObject;
      localObject4 = localObject1;
      localSoapObject.<init>((String)localObject1, (String)localObject5);
      break;
      localHttpTransportSE = new org/ksoap2/transport/HttpTransportSE;
      localObject1 = "http://orf.gov.in/aadhaarekyc/validateKYC?wsdl";
      j = 60000;
      localObject2 = localObject1;
      localHttpTransportSE.<init>((String)localObject1, j);
      break label966;
      localObject1 = "http://kycWS/";
      localObject2 = localObject1;
      localHttpTransportSE.call((String)localObject1, localSoapSerializationEnvelope);
    }
  }
  
  protected void onPostExecute(String paramString)
  {
    Object localObject1 = dlog;
    boolean bool = ((ProgressDialog)localObject1).isShowing();
    if (bool)
    {
      localObject1 = dlog;
      ((ProgressDialog)localObject1).dismiss();
    }
    localObject1 = this$0.check;
    Object localObject2 = "otp";
    bool = ((String)localObject1).equals(localObject2);
    if (bool)
    {
      localObject1 = this$0;
      bool = vaild;
      if (bool)
      {
        Intent localIntent = new android/content/Intent;
        localObject1 = this$0.getApplicationContext();
        localIntent.<init>((Context)localObject1, ShowUIDAIData.class);
        localObject2 = this$0.finalArray;
        localIntent.putExtra("uid_data", (String[])localObject2);
        localObject2 = this$0.aadhaar.getText().toString();
        localIntent.putExtra("aaddhaarid", (String)localObject2);
        this$0.finish();
        localObject1 = this$0;
        ((MainActivity)localObject1).startActivity(localIntent);
      }
    }
  }
  
  protected void onPreExecute()
  {
    int i = 1;
    Object localObject1 = new android/app/ProgressDialog;
    Object localObject2 = this$0;
    ((ProgressDialog)localObject1).<init>((Context)localObject2);
    dlog = ((ProgressDialog)localObject1);
    localObject1 = dlog;
    localObject2 = this$0.getResources();
    int j = 2131034289;
    localObject2 = ((Resources)localObject2).getString(j);
    ((ProgressDialog)localObject1).setTitle((CharSequence)localObject2);
    localObject1 = MainActivity.access$100(this$0);
    localObject2 = "getRawOTP";
    boolean bool = ((String)localObject1).equals(localObject2);
    if (bool)
    {
      localObject1 = dlog;
      localObject2 = this$0.getResources();
      j = 2131034163;
      localObject2 = ((Resources)localObject2).getString(j);
      ((ProgressDialog)localObject1).setMessage((CharSequence)localObject2);
    }
    for (;;)
    {
      int k = Build.VERSION.SDK_INT;
      int m = 11;
      if (k >= m)
      {
        dlog.setProgressStyle(i);
        dlog.setIndeterminate(i);
        dlog.setProgressNumberFormat(null);
        localObject1 = dlog;
        ((ProgressDialog)localObject1).setProgressPercentFormat(null);
      }
      dlog.setCancelable(false);
      dlog.show();
      return;
      localObject1 = dlog;
      localObject2 = this$0.getResources();
      j = 2131034165;
      localObject2 = ((Resources)localObject2).getString(j);
      ((ProgressDialog)localObject1).setMessage((CharSequence)localObject2);
    }
  }
  
  protected void onProgressUpdate(String... paramVarArgs) {}
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/MainActivity$AsyncTaskRunner.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */