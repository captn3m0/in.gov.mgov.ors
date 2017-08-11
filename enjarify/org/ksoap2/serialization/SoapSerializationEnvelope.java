package org.ksoap2.serialization;

import java.util.Hashtable;
import java.util.Vector;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.SoapFault12;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

public class SoapSerializationEnvelope
  extends SoapEnvelope
{
  private static final String ANY_TYPE_LABEL = "anyType";
  private static final String ARRAY_MAPPING_NAME = "Array";
  private static final String ARRAY_TYPE_LABEL = "arrayType";
  static final Marshal DEFAULT_MARSHAL;
  private static final String HREF_LABEL = "href";
  private static final String ID_LABEL = "id";
  private static final String ITEM_LABEL = "item";
  private static final String NIL_LABEL = "nil";
  private static final String NULL_LABEL = "null";
  protected static final int QNAME_MARSHAL = 3;
  protected static final int QNAME_NAMESPACE = 0;
  protected static final int QNAME_TYPE = 1;
  private static final String ROOT_LABEL = "root";
  private static final String TYPE_LABEL = "type";
  static Class class$org$ksoap2$serialization$SoapObject;
  protected boolean addAdornments;
  public boolean avoidExceptionForUnknownProperty;
  protected Hashtable classToQName;
  public boolean dotNet;
  Hashtable idMap;
  public boolean implicitTypes;
  Vector multiRef;
  public Hashtable properties;
  protected Hashtable qNameToClass;
  
  static
  {
    DM localDM = new org/ksoap2/serialization/DM;
    localDM.<init>();
    DEFAULT_MARSHAL = localDM;
  }
  
  public SoapSerializationEnvelope(int paramInt)
  {
    super(paramInt);
    Object localObject = new java/util/Hashtable;
    ((Hashtable)localObject).<init>();
    properties = ((Hashtable)localObject);
    localObject = new java/util/Hashtable;
    ((Hashtable)localObject).<init>();
    idMap = ((Hashtable)localObject);
    localObject = new java/util/Hashtable;
    ((Hashtable)localObject).<init>();
    qNameToClass = ((Hashtable)localObject);
    localObject = new java/util/Hashtable;
    ((Hashtable)localObject).<init>();
    classToQName = ((Hashtable)localObject);
    addAdornments = true;
    localObject = enc;
    Class localClass = PropertyInfo.VECTOR_CLASS;
    addMapping((String)localObject, "Array", localClass);
    DEFAULT_MARSHAL.register(this);
  }
  
  static Class class$(String paramString)
  {
    try
    {
      return Class.forName(paramString);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      NoClassDefFoundError localNoClassDefFoundError = new java/lang/NoClassDefFoundError;
      String str = localClassNotFoundException.getMessage();
      localNoClassDefFoundError.<init>(str);
      throw localNoClassDefFoundError;
    }
  }
  
  private int getIndex(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {}
    for (;;)
    {
      return paramInt2;
      int i = paramString.length() - paramInt1;
      int j = 3;
      if (i >= j)
      {
        i = paramInt1 + 1;
        j = paramString.length() + -1;
        String str = paramString.substring(i, j);
        paramInt2 = Integer.parseInt(str);
      }
    }
  }
  
  private void writeElement(XmlSerializer paramXmlSerializer, Object paramObject1, PropertyInfo paramPropertyInfo, Object paramObject2)
  {
    if (paramObject2 != null)
    {
      paramObject2 = (Marshal)paramObject2;
      ((Marshal)paramObject2).writeInstance(paramXmlSerializer, paramObject1);
    }
    for (;;)
    {
      return;
      boolean bool = paramObject1 instanceof SoapObject;
      if (bool)
      {
        paramObject1 = (SoapObject)paramObject1;
        writeObjectBody(paramXmlSerializer, (SoapObject)paramObject1);
      }
      else
      {
        bool = paramObject1 instanceof KvmSerializable;
        if (bool)
        {
          paramObject1 = (KvmSerializable)paramObject1;
          writeObjectBody(paramXmlSerializer, (KvmSerializable)paramObject1);
        }
        else
        {
          bool = paramObject1 instanceof Vector;
          if (!bool) {
            break;
          }
          paramObject1 = (Vector)paramObject1;
          localObject1 = elementType;
          writeVectorBody(paramXmlSerializer, (Vector)paramObject1, (PropertyInfo)localObject1);
        }
      }
    }
    Object localObject1 = new java/lang/RuntimeException;
    Object localObject2 = new java/lang/StringBuffer;
    ((StringBuffer)localObject2).<init>();
    localObject2 = "Cannot serialize: " + paramObject1;
    ((RuntimeException)localObject1).<init>((String)localObject2);
    throw ((Throwable)localObject1);
  }
  
  public void addMapping(String paramString1, String paramString2, Class paramClass)
  {
    addMapping(paramString1, paramString2, paramClass, null);
  }
  
  public void addMapping(String paramString1, String paramString2, Class paramClass, Marshal paramMarshal)
  {
    Object localObject1 = qNameToClass;
    Object localObject2 = new org/ksoap2/serialization/SoapPrimitive;
    ((SoapPrimitive)localObject2).<init>(paramString1, paramString2, null);
    if (paramMarshal == null) {}
    for (Object localObject3 = paramClass;; localObject3 = paramMarshal)
    {
      ((Hashtable)localObject1).put(localObject2, localObject3);
      localObject3 = classToQName;
      localObject1 = paramClass.getName();
      localObject2 = new Object[4];
      localObject2[0] = paramString1;
      localObject2[1] = paramString2;
      localObject2[2] = null;
      localObject2[3] = paramMarshal;
      ((Hashtable)localObject3).put(localObject1, localObject2);
      return;
    }
  }
  
  public void addTemplate(SoapObject paramSoapObject)
  {
    Hashtable localHashtable = qNameToClass;
    SoapPrimitive localSoapPrimitive = new org/ksoap2/serialization/SoapPrimitive;
    String str1 = namespace;
    String str2 = name;
    localSoapPrimitive.<init>(str1, str2, null);
    localHashtable.put(localSoapPrimitive, paramSoapObject);
  }
  
  public Object[] getInfo(Object paramObject1, Object paramObject2)
  {
    int i = 3;
    int j = 2;
    int k = 1;
    boolean bool1;
    Object localObject2;
    Object localObject3;
    if (paramObject1 == null)
    {
      bool1 = paramObject2 instanceof SoapObject;
      if (!bool1)
      {
        bool1 = paramObject2 instanceof SoapPrimitive;
        if (!bool1) {}
      }
      else
      {
        paramObject1 = paramObject2;
      }
    }
    else
    {
      bool1 = paramObject1 instanceof SoapObject;
      if (!bool1) {
        break label115;
      }
      Object localObject1 = paramObject1;
      localObject1 = (SoapObject)paramObject1;
      int m = 4;
      localObject2 = new Object[m];
      localObject3 = ((SoapObject)localObject1).getNamespace();
      localObject2[0] = localObject3;
      localObject3 = ((SoapObject)localObject1).getName();
      localObject2[k] = localObject3;
      localObject2[j] = null;
      localObject2[i] = null;
    }
    for (;;)
    {
      return (Object[])localObject2;
      paramObject1 = paramObject2.getClass();
      break;
      label115:
      boolean bool2 = paramObject1 instanceof SoapPrimitive;
      if (bool2)
      {
        Object localObject4 = paramObject1;
        localObject4 = (SoapPrimitive)paramObject1;
        int n = 4;
        localObject2 = new Object[n];
        localObject3 = ((SoapPrimitive)localObject4).getNamespace();
        localObject2[0] = localObject3;
        localObject3 = ((SoapPrimitive)localObject4).getName();
        localObject2[k] = localObject3;
        localObject2[j] = null;
        localObject3 = DEFAULT_MARSHAL;
        localObject2[i] = localObject3;
      }
      else
      {
        boolean bool3 = paramObject1 instanceof Class;
        if (bool3)
        {
          localObject3 = PropertyInfo.OBJECT_CLASS;
          if (paramObject1 != localObject3)
          {
            localObject3 = classToQName;
            paramObject1 = (Class)paramObject1;
            String str = ((Class)paramObject1).getName();
            localObject3 = (Object[])((Hashtable)localObject3).get(str);
            localObject2 = localObject3;
            localObject2 = (Object[])localObject3;
            if (localObject2 != null) {
              continue;
            }
          }
        }
        int i1 = 4;
        localObject2 = new Object[i1];
        localObject3 = xsd;
        localObject2[0] = localObject3;
        localObject3 = "anyType";
        localObject2[k] = localObject3;
        localObject2[j] = null;
        localObject2[i] = null;
      }
    }
  }
  
  public Object getResponse()
  {
    Object localObject1 = bodyIn;
    boolean bool = localObject1 instanceof SoapFault;
    if (bool) {
      throw ((SoapFault)bodyIn);
    }
    KvmSerializable localKvmSerializable = (KvmSerializable)bodyIn;
    int i = localKvmSerializable.getPropertyCount();
    if (i == 0) {}
    for (Object localObject2 = null;; localObject2 = localKvmSerializable.getProperty(0))
    {
      return localObject2;
      i = localKvmSerializable.getPropertyCount();
      int j = 1;
      if (i != j) {
        break;
      }
      i = 0;
      localObject1 = null;
    }
    localObject2 = new java/util/Vector;
    ((Vector)localObject2).<init>();
    int k = 0;
    for (;;)
    {
      i = localKvmSerializable.getPropertyCount();
      if (k >= i) {
        break;
      }
      localObject1 = localKvmSerializable.getProperty(k);
      ((Vector)localObject2).add(localObject1);
      k += 1;
    }
  }
  
  public boolean isAddAdornments()
  {
    return addAdornments;
  }
  
  public void parseBody(XmlPullParser paramXmlPullParser)
  {
    int i = 2;
    bodyIn = null;
    paramXmlPullParser.nextTag();
    int j = paramXmlPullParser.getEventType();
    Object localObject1;
    Object localObject2;
    int k;
    if (j == i)
    {
      localObject1 = paramXmlPullParser.getNamespace();
      localObject2 = env;
      boolean bool1 = ((String)localObject1).equals(localObject2);
      if (bool1)
      {
        localObject1 = paramXmlPullParser.getName();
        localObject2 = "Fault";
        bool1 = ((String)localObject1).equals(localObject2);
        if (bool1)
        {
          k = version;
          int m = 120;
          Object localObject3;
          if (k < m)
          {
            localObject3 = new org/ksoap2/SoapFault;
            k = version;
            ((SoapFault)localObject3).<init>(k);
          }
          for (;;)
          {
            ((SoapFault)localObject3).parse(paramXmlPullParser);
            bodyIn = localObject3;
            return;
            localObject3 = new org/ksoap2/SoapFault12;
            k = version;
            ((SoapFault12)localObject3).<init>(k);
          }
        }
      }
    }
    for (;;)
    {
      k = paramXmlPullParser.getEventType();
      if (k != i) {
        break;
      }
      localObject1 = enc;
      String str1 = paramXmlPullParser.getAttributeValue((String)localObject1, "root");
      int n = -1;
      String str2 = paramXmlPullParser.getNamespace();
      String str3 = paramXmlPullParser.getName();
      PropertyInfo localPropertyInfo = PropertyInfo.OBJECT_TYPE;
      localObject1 = this;
      localObject2 = paramXmlPullParser;
      Object localObject4 = read(paramXmlPullParser, null, n, str2, str3, localPropertyInfo);
      localObject1 = "1";
      boolean bool2 = ((String)localObject1).equals(str1);
      if (!bool2)
      {
        localObject1 = bodyIn;
        if (localObject1 != null) {}
      }
      else
      {
        bodyIn = localObject4;
      }
      paramXmlPullParser.nextTag();
    }
  }
  
  public Object read(XmlPullParser paramXmlPullParser, Object paramObject, int paramInt, String paramString1, String paramString2, PropertyInfo paramPropertyInfo)
  {
    String str1 = paramXmlPullParser.getName();
    int i = 0;
    Object localObject1 = null;
    String str2 = "href";
    Object localObject2 = paramXmlPullParser;
    int k = 0;
    String str3 = str2;
    String str4 = paramXmlPullParser.getAttributeValue(null, str2);
    Object localObject3;
    Object localObject4;
    if (str4 != null)
    {
      if (paramObject == null)
      {
        localObject1 = new java/lang/RuntimeException;
        ((RuntimeException)localObject1).<init>("href at root level?!?");
        throw ((Throwable)localObject1);
      }
      i = 1;
      int m = i;
      str4 = str4.substring(i);
      localObject2 = this;
      localObject2 = idMap;
      localObject1 = localObject2;
      localObject3 = ((Hashtable)localObject2).get(str4);
      if (localObject3 != null)
      {
        int n = localObject3 instanceof FwdRef;
        i = n;
        if (n == 0) {}
      }
      else
      {
        localObject4 = new org/ksoap2/serialization/FwdRef;
        ((FwdRef)localObject4).<init>();
        localObject3 = (FwdRef)localObject3;
        next = ((FwdRef)localObject3);
        localObject2 = paramObject;
        obj = paramObject;
        int i1 = paramInt;
        index = paramInt;
        localObject2 = this;
        localObject2 = idMap;
        localObject1 = localObject2;
        ((Hashtable)localObject2).put(str4, localObject4);
        localObject3 = null;
      }
      paramXmlPullParser.nextTag();
      i = 3;
      str2 = null;
      localObject2 = paramXmlPullParser;
      k = i;
      str3 = null;
      paramXmlPullParser.require(i, null, str1);
      localObject2 = paramXmlPullParser;
      k = 3;
      paramXmlPullParser.require(k, null, str1);
      return localObject3;
    }
    localObject2 = this;
    localObject1 = xsi;
    localObject2 = paramXmlPullParser;
    str3 = "nil";
    String str5 = paramXmlPullParser.getAttributeValue((String)localObject1, str3);
    i = 0;
    localObject1 = null;
    str2 = "id";
    k = 0;
    str3 = str2;
    String str6 = paramXmlPullParser.getAttributeValue(null, str2);
    if (str5 == null)
    {
      localObject2 = this;
      localObject1 = xsi;
      str2 = "null";
      localObject2 = paramXmlPullParser;
      str3 = str2;
      str5 = paramXmlPullParser.getAttributeValue((String)localObject1, str2);
    }
    int j;
    label392:
    Object localObject5;
    if (str5 != null)
    {
      boolean bool = SoapEnvelope.stringToBoolean(str5);
      if (bool)
      {
        localObject3 = null;
        paramXmlPullParser.nextTag();
        j = 3;
        str2 = null;
        localObject2 = paramXmlPullParser;
        k = j;
        str3 = null;
        paramXmlPullParser.require(j, null, str1);
        if (str6 == null) {
          break label703;
        }
        localObject2 = this;
        localObject2 = idMap;
        localObject1 = localObject2;
        localObject5 = ((Hashtable)localObject2).get(str6);
        int i2 = localObject5 instanceof FwdRef;
        j = i2;
        if (i2 == 0) {
          break label899;
        }
        localObject4 = localObject5;
        localObject4 = (FwdRef)localObject5;
        do
        {
          localObject2 = obj;
          localObject1 = localObject2;
          i2 = localObject2 instanceof KvmSerializable;
          j = i2;
          if (i2 == 0) {
            break;
          }
          localObject2 = obj;
          localObject1 = localObject2;
          localObject1 = (KvmSerializable)localObject2;
          i3 = index;
          localObject2 = localObject1;
          k = i3;
          ((KvmSerializable)localObject1).setProperty(i3, localObject3);
          localObject4 = next;
        } while (localObject4 != null);
      }
    }
    label635:
    label703:
    label899:
    while (localObject5 == null) {
      for (;;)
      {
        localObject2 = this;
        localObject2 = idMap;
        localObject1 = localObject2;
        ((Hashtable)localObject2).put(str6, localObject3);
        break;
        localObject2 = this;
        localObject1 = xsi;
        str2 = "type";
        localObject2 = paramXmlPullParser;
        str3 = str2;
        String str7 = paramXmlPullParser.getAttributeValue((String)localObject1, str2);
        int i4;
        String str8;
        if (str7 != null)
        {
          i4 = str7.indexOf(':');
          j = i4 + 1;
          paramString2 = str7.substring(j);
          j = -1;
          i3 = j;
          if (i4 == j)
          {
            str8 = "";
            localObject2 = paramXmlPullParser;
            paramString1 = paramXmlPullParser.getNamespace(str8);
          }
        }
        for (;;)
        {
          if (str7 == null)
          {
            j = 1;
            i3 = j;
            implicitTypes = j;
          }
          localObject2 = this;
          str3 = paramString1;
          localObject3 = readInstance(paramXmlPullParser, paramString1, paramString2, paramPropertyInfo);
          if (localObject3 != null) {
            break label392;
          }
          localObject3 = readUnknown(paramXmlPullParser, paramString1, paramString2);
          break label392;
          break;
          j = 0;
          localObject1 = null;
          i3 = 0;
          localObject2 = null;
          str8 = str7.substring(0, i4);
          break label635;
          if ((paramString2 == null) && (paramString1 == null))
          {
            localObject2 = this;
            localObject1 = enc;
            str2 = "arrayType";
            localObject2 = paramXmlPullParser;
            str3 = str2;
            localObject1 = paramXmlPullParser.getAttributeValue((String)localObject1, str2);
            if (localObject1 != null)
            {
              localObject2 = this;
              localObject2 = enc;
              paramString1 = (String)localObject2;
              paramString2 = "Array";
            }
            else
            {
              localObject2 = paramPropertyInfo;
              localObject1 = type;
              str2 = null;
              localObject2 = this;
              str3 = null;
              Object[] arrayOfObject = getInfo(localObject1, null);
              localObject1 = null;
              paramString1 = (String)arrayOfObject[0];
              j = 1;
              paramString2 = (String)arrayOfObject[j];
            }
          }
        }
        localObject2 = obj;
        localObject1 = localObject2;
        localObject1 = (Vector)localObject2;
        int i3 = index;
        localObject2 = localObject1;
        k = i3;
        ((Vector)localObject1).setElementAt(localObject3, i3);
      }
    }
    localObject1 = new java/lang/RuntimeException;
    ((RuntimeException)localObject1).<init>("double ID");
    throw ((Throwable)localObject1);
  }
  
  public Object readInstance(XmlPullParser paramXmlPullParser, String paramString1, String paramString2, PropertyInfo paramPropertyInfo)
  {
    boolean bool = false;
    Object localObject1 = null;
    Object localObject2 = qNameToClass;
    Object localObject3 = new org/ksoap2/serialization/SoapPrimitive;
    ((SoapPrimitive)localObject3).<init>(paramString1, paramString2, null);
    Object localObject4 = ((Hashtable)localObject2).get(localObject3);
    if (localObject4 == null) {
      localObject4 = null;
    }
    for (;;)
    {
      return localObject4;
      bool = localObject4 instanceof Marshal;
      if (bool)
      {
        localObject4 = ((Marshal)localObject4).readInstance(paramXmlPullParser, paramString1, paramString2, paramPropertyInfo);
      }
      else
      {
        bool = localObject4 instanceof SoapObject;
        if (bool) {
          localObject4 = ((SoapObject)localObject4).newInstance();
        }
        for (;;)
        {
          bool = localObject4 instanceof SoapObject;
          if (bool)
          {
            localObject1 = localObject4;
            localObject1 = (SoapObject)localObject4;
            readSerializable(paramXmlPullParser, (SoapObject)localObject1);
            break;
            localObject1 = class$org$ksoap2$serialization$SoapObject;
            if (localObject1 == null)
            {
              localObject1 = class$("org.ksoap2.serialization.SoapObject");
              class$org$ksoap2$serialization$SoapObject = (Class)localObject1;
            }
            for (;;)
            {
              if (localObject4 != localObject1) {
                break label185;
              }
              localObject4 = new org/ksoap2/serialization/SoapObject;
              ((SoapObject)localObject4).<init>(paramString1, paramString2);
              break;
              localObject1 = class$org$ksoap2$serialization$SoapObject;
            }
            try
            {
              label185:
              localObject4 = (Class)localObject4;
              localObject4 = ((Class)localObject4).newInstance();
            }
            catch (Exception localException)
            {
              localObject1 = new java/lang/RuntimeException;
              localObject2 = localException.toString();
              ((RuntimeException)localObject1).<init>((String)localObject2);
              throw ((Throwable)localObject1);
            }
          }
        }
        bool = localObject4 instanceof KvmSerializable;
        if (bool)
        {
          localObject1 = localObject4;
          localObject1 = (KvmSerializable)localObject4;
          readSerializable(paramXmlPullParser, (KvmSerializable)localObject1);
        }
        else
        {
          bool = localObject4 instanceof Vector;
          if (!bool) {
            break;
          }
          localObject1 = localObject4;
          localObject1 = (Vector)localObject4;
          localObject2 = elementType;
          readVector(paramXmlPullParser, (Vector)localObject1, (PropertyInfo)localObject2);
        }
      }
    }
    localObject1 = new java/lang/RuntimeException;
    localObject2 = new java/lang/StringBuffer;
    ((StringBuffer)localObject2).<init>();
    localObject2 = ((StringBuffer)localObject2).append("no deserializer for ");
    localObject3 = localObject4.getClass();
    localObject2 = localObject3;
    ((RuntimeException)localObject1).<init>((String)localObject2);
    throw ((Throwable)localObject1);
  }
  
  protected void readSerializable(XmlPullParser paramXmlPullParser, KvmSerializable paramKvmSerializable)
  {
    for (;;)
    {
      int i = paramXmlPullParser.nextTag();
      int k = 3;
      if (i == k) {
        break;
      }
      String str1 = paramXmlPullParser.getName();
      boolean bool1 = implicitTypes;
      if (bool1)
      {
        bool1 = paramKvmSerializable instanceof SoapObject;
        if (bool1) {}
      }
      else
      {
        PropertyInfo localPropertyInfo1 = new org/ksoap2/serialization/PropertyInfo;
        localPropertyInfo1.<init>();
        int m = ((KvmSerializable)paramKvmSerializable).getPropertyCount();
        int n = 0;
        int i1 = 0;
        while ((i1 < m) && (n == 0))
        {
          localPropertyInfo1.clear();
          localObject1 = properties;
          ((KvmSerializable)paramKvmSerializable).getPropertyInfo(i1, (Hashtable)localObject1, localPropertyInfo1);
          localObject1 = name;
          bool1 = str1.equals(localObject1);
          if (bool1)
          {
            localObject1 = namespace;
            if (localObject1 == null) {}
          }
          else
          {
            localObject1 = name;
            bool1 = str1.equals(localObject1);
            if (!bool1) {
              break label223;
            }
            localObject1 = paramXmlPullParser.getNamespace();
            localObject2 = namespace;
            bool1 = ((String)localObject1).equals(localObject2);
            if (!bool1) {
              break label223;
            }
          }
          n = 1;
          localObject1 = this;
          localObject2 = paramXmlPullParser;
          localObject3 = paramKvmSerializable;
          localObject1 = read(paramXmlPullParser, paramKvmSerializable, i1, null, null, localPropertyInfo1);
          ((KvmSerializable)paramKvmSerializable).setProperty(i1, localObject1);
          label223:
          i1 += 1;
        }
        if (n != 0) {
          continue;
        }
        bool1 = avoidExceptionForUnknownProperty;
        if (bool1) {
          for (;;)
          {
            int j = paramXmlPullParser.next();
            k = 3;
            if (j == k)
            {
              localObject1 = paramXmlPullParser.getName();
              boolean bool2 = str1.equals(localObject1);
              if (bool2) {
                break;
              }
            }
          }
        }
        localObject1 = new java/lang/RuntimeException;
        localObject2 = new java/lang/StringBuffer;
        ((StringBuffer)localObject2).<init>();
        localObject2 = "Unknown Property: " + str1;
        ((RuntimeException)localObject1).<init>((String)localObject2);
        throw ((Throwable)localObject1);
      }
      Object localObject1 = paramKvmSerializable;
      localObject1 = (SoapObject)paramKvmSerializable;
      Object localObject3 = paramXmlPullParser.getName();
      int i2 = ((KvmSerializable)paramKvmSerializable).getPropertyCount();
      Object localObject2 = paramKvmSerializable;
      String str2 = ((SoapObject)paramKvmSerializable).getNamespace();
      PropertyInfo localPropertyInfo2 = PropertyInfo.OBJECT_TYPE;
      localObject2 = read(paramXmlPullParser, paramKvmSerializable, i2, str2, str1, localPropertyInfo2);
      ((SoapObject)localObject1).addProperty((String)localObject3, localObject2);
    }
    paramXmlPullParser.require(3, null, null);
  }
  
  protected void readSerializable(XmlPullParser paramXmlPullParser, SoapObject paramSoapObject)
  {
    int i = 0;
    for (;;)
    {
      int j = paramXmlPullParser.getAttributeCount();
      if (i >= j) {
        break;
      }
      String str1 = paramXmlPullParser.getAttributeName(i);
      String str2 = paramXmlPullParser.getAttributeValue(i);
      paramSoapObject.addAttribute(str1, str2);
      i += 1;
    }
    readSerializable(paramXmlPullParser, paramSoapObject);
  }
  
  protected Object readUnknown(XmlPullParser paramXmlPullParser, String paramString1, String paramString2)
  {
    String str1 = paramXmlPullParser.getName();
    String str2 = paramXmlPullParser.getNamespace();
    Vector localVector = new java/util/Vector;
    localVector.<init>();
    int i = 0;
    Object localObject1;
    for (;;)
    {
      j = paramXmlPullParser.getAttributeCount();
      if (i >= j) {
        break;
      }
      AttributeInfo localAttributeInfo = new org/ksoap2/serialization/AttributeInfo;
      localAttributeInfo.<init>();
      localObject1 = paramXmlPullParser.getAttributeName(i);
      localAttributeInfo.setName((String)localObject1);
      localObject1 = paramXmlPullParser.getAttributeValue(i);
      localAttributeInfo.setValue(localObject1);
      localObject1 = paramXmlPullParser.getAttributeNamespace(i);
      localAttributeInfo.setNamespace((String)localObject1);
      localObject1 = paramXmlPullParser.getAttributeType(i);
      localAttributeInfo.setType(localObject1);
      localVector.addElement(localAttributeInfo);
      i += 1;
    }
    paramXmlPullParser.next();
    Object localObject2 = null;
    String str3 = null;
    int j = paramXmlPullParser.getEventType();
    int k = 4;
    if (j == k)
    {
      str3 = paramXmlPullParser.getText();
      SoapPrimitive localSoapPrimitive = new org/ksoap2/serialization/SoapPrimitive;
      localSoapPrimitive.<init>(paramString1, paramString2, str3);
      localObject2 = localSoapPrimitive;
      m = 0;
      for (;;)
      {
        j = localVector.size();
        if (m >= j) {
          break;
        }
        localObject1 = (AttributeInfo)localVector.elementAt(m);
        localSoapPrimitive.addAttribute((AttributeInfo)localObject1);
        m += 1;
      }
      paramXmlPullParser.next();
    }
    for (;;)
    {
      j = paramXmlPullParser.getEventType();
      k = 2;
      if (j != k) {
        break label524;
      }
      if (str3 == null) {
        break;
      }
      localObject1 = str3.trim();
      j = ((String)localObject1).length();
      if (j == 0) {
        break;
      }
      localObject1 = new java/lang/RuntimeException;
      ((RuntimeException)localObject1).<init>("Malformed input: Mixed content");
      throw ((Throwable)localObject1);
      j = paramXmlPullParser.getEventType();
      k = 3;
      if (j == k)
      {
        localSoapObject = new org/ksoap2/serialization/SoapObject;
        localSoapObject.<init>(paramString1, paramString2);
        m = 0;
        for (;;)
        {
          j = localVector.size();
          if (m >= j) {
            break;
          }
          localObject1 = (AttributeInfo)localVector.elementAt(m);
          localSoapObject.addAttribute((AttributeInfo)localObject1);
          m += 1;
        }
        localObject2 = localSoapObject;
      }
    }
    SoapObject localSoapObject = new org/ksoap2/serialization/SoapObject;
    localSoapObject.<init>(paramString1, paramString2);
    int m = 0;
    for (;;)
    {
      j = localVector.size();
      if (m >= j) {
        break;
      }
      localObject1 = (AttributeInfo)localVector.elementAt(m);
      localSoapObject.addAttribute((AttributeInfo)localObject1);
      m += 1;
    }
    for (;;)
    {
      j = paramXmlPullParser.getEventType();
      k = 3;
      if (j == k) {
        break;
      }
      String str4 = paramXmlPullParser.getName();
      int n = localSoapObject.getPropertyCount();
      PropertyInfo localPropertyInfo = PropertyInfo.OBJECT_TYPE;
      localObject1 = this;
      localObject1 = read(paramXmlPullParser, localSoapObject, n, null, null, localPropertyInfo);
      localSoapObject.addProperty(str4, localObject1);
      paramXmlPullParser.nextTag();
    }
    localObject2 = localSoapObject;
    label524:
    paramXmlPullParser.require(3, str2, str1);
    return localObject2;
  }
  
  protected void readVector(XmlPullParser paramXmlPullParser, Vector paramVector, PropertyInfo paramPropertyInfo)
  {
    String str1 = null;
    String str2 = null;
    int i = paramVector.size();
    int j = 1;
    Object localObject1 = enc;
    Object localObject2 = "arrayType";
    String str3 = paramXmlPullParser.getAttributeValue((String)localObject1, (String)localObject2);
    int k;
    int m;
    int n;
    if (str3 != null)
    {
      k = str3.indexOf(':');
      localObject1 = "[";
      m = str3.indexOf((String)localObject1, k);
      n = k + 1;
      str2 = str3.substring(n, m);
      n = -1;
      if (k != n) {
        break label312;
      }
    }
    for (String str4 = "";; str4 = str3.substring(0, k))
    {
      str1 = paramXmlPullParser.getNamespace(str4);
      i = getIndex(str3, m, -1);
      n = -1;
      if (i != n)
      {
        paramVector.setSize(i);
        j = 0;
      }
      if (paramPropertyInfo == null) {
        paramPropertyInfo = PropertyInfo.OBJECT_TYPE;
      }
      paramXmlPullParser.nextTag();
      localObject1 = enc;
      localObject1 = paramXmlPullParser.getAttributeValue((String)localObject1, "offset");
      int i1 = 0;
      localObject2 = null;
      int i2 = getIndex((String)localObject1, 0, 0);
      for (;;)
      {
        n = paramXmlPullParser.getEventType();
        i1 = 3;
        if (n == i1) {
          break;
        }
        localObject1 = enc;
        localObject1 = paramXmlPullParser.getAttributeValue((String)localObject1, "position");
        i1 = 0;
        localObject2 = null;
        i2 = getIndex((String)localObject1, 0, i2);
        if ((j != 0) && (i2 >= i))
        {
          i = i2 + 1;
          paramVector.setSize(i);
        }
        localObject1 = this;
        localObject2 = paramXmlPullParser;
        localObject1 = read(paramXmlPullParser, paramVector, i2, str1, str2, paramPropertyInfo);
        paramVector.setElementAt(localObject1, i2);
        i2 += 1;
        paramXmlPullParser.nextTag();
      }
      label312:
      n = 0;
      localObject1 = null;
    }
    paramXmlPullParser.require(3, null, null);
  }
  
  public void setAddAdornments(boolean paramBoolean)
  {
    addAdornments = paramBoolean;
  }
  
  public void setBodyOutEmpty(boolean paramBoolean)
  {
    if (paramBoolean) {
      bodyOut = null;
    }
  }
  
  public void writeBody(XmlSerializer paramXmlSerializer)
  {
    int i = 2;
    int j = 1;
    Object localObject1 = bodyOut;
    Object[] arrayOfObject;
    if (localObject1 != null)
    {
      localObject1 = new java/util/Vector;
      ((Vector)localObject1).<init>();
      multiRef = ((Vector)localObject1);
      localObject1 = multiRef;
      localObject2 = bodyOut;
      ((Vector)localObject1).addElement(localObject2);
      localObject1 = bodyOut;
      arrayOfObject = getInfo(null, localObject1);
      boolean bool = dotNet;
      if (!bool) {
        break label280;
      }
      localObject1 = "";
      localObject2 = localObject1;
      localObject1 = (String)arrayOfObject[j];
      paramXmlSerializer.startTag((String)localObject2, (String)localObject1);
      bool = dotNet;
      if (bool)
      {
        localObject2 = "xmlns";
        localObject1 = (String)arrayOfObject[0];
        paramXmlSerializer.attribute(null, (String)localObject2, (String)localObject1);
      }
      bool = addAdornments;
      if (bool)
      {
        localObject2 = "id";
        localObject1 = arrayOfObject[i];
        if (localObject1 != null) {
          break label296;
        }
        localObject1 = "o0";
        label173:
        paramXmlSerializer.attribute(null, (String)localObject2, (String)localObject1);
        localObject1 = enc;
        localObject2 = "root";
        String str = "1";
        paramXmlSerializer.attribute((String)localObject1, (String)localObject2, str);
      }
      localObject1 = bodyOut;
      int k = 3;
      localObject2 = arrayOfObject[k];
      writeElement(paramXmlSerializer, localObject1, null, localObject2);
      bool = dotNet;
      if (!bool) {
        break label308;
      }
      localObject1 = "";
    }
    for (Object localObject2 = localObject1;; localObject2 = localObject1)
    {
      localObject1 = (String)arrayOfObject[j];
      paramXmlSerializer.endTag((String)localObject2, (String)localObject1);
      return;
      label280:
      localObject1 = (String)arrayOfObject[0];
      localObject2 = localObject1;
      break;
      label296:
      localObject1 = (String)arrayOfObject[i];
      break label173;
      label308:
      localObject1 = (String)arrayOfObject[0];
    }
  }
  
  public void writeObjectBody(XmlSerializer paramXmlSerializer, KvmSerializable paramKvmSerializable)
  {
    int i = paramKvmSerializable.getPropertyCount();
    PropertyInfo localPropertyInfo = new org/ksoap2/serialization/PropertyInfo;
    localPropertyInfo.<init>();
    int j = 0;
    while (j < i)
    {
      Object localObject1 = paramKvmSerializable.getProperty(j);
      Object localObject2 = properties;
      paramKvmSerializable.getPropertyInfo(j, (Hashtable)localObject2, localPropertyInfo);
      boolean bool1 = localObject1 instanceof SoapObject;
      int k;
      String str1;
      if (!bool1)
      {
        k = flags & 0x1;
        if (k == 0)
        {
          localObject2 = namespace;
          str1 = name;
          paramXmlSerializer.startTag((String)localObject2, str1);
          localObject2 = paramKvmSerializable.getProperty(j);
          writeProperty(paramXmlSerializer, localObject2, localPropertyInfo);
          localObject2 = namespace;
          str1 = name;
          paramXmlSerializer.endTag((String)localObject2, str1);
        }
        j += 1;
      }
      else
      {
        Object localObject3 = localObject1;
        localObject3 = (SoapObject)localObject1;
        Object[] arrayOfObject = getInfo(null, localObject3);
        String str2 = (String)arrayOfObject[0];
        k = 1;
        String str3 = (String)arrayOfObject[k];
        localObject2 = name;
        String str4;
        if (localObject2 != null)
        {
          localObject2 = name;
          k = ((String)localObject2).length();
          if (k > 0)
          {
            str4 = name;
            label238:
            localObject2 = namespace;
            if (localObject2 == null) {
              break label414;
            }
            localObject2 = namespace;
            k = ((String)localObject2).length();
            if (k <= 0) {
              break label414;
            }
          }
        }
        for (str2 = namespace;; str2 = (String)arrayOfObject[0])
        {
          paramXmlSerializer.startTag(str2, str4);
          boolean bool2 = implicitTypes;
          if (!bool2)
          {
            bool2 = true;
            String str5 = paramXmlSerializer.getPrefix(str2, bool2);
            localObject2 = xsi;
            str1 = "type";
            Object localObject4 = new java/lang/StringBuffer;
            ((StringBuffer)localObject4).<init>();
            localObject4 = ((StringBuffer)localObject4).append(str5);
            String str6 = ":";
            localObject4 = str6 + str3;
            paramXmlSerializer.attribute((String)localObject2, str1, (String)localObject4);
          }
          writeObjectBody(paramXmlSerializer, (SoapObject)localObject3);
          paramXmlSerializer.endTag(str2, str4);
          break;
          bool2 = true;
          str4 = (String)arrayOfObject[bool2];
          break label238;
          label414:
          bool2 = false;
          localObject2 = null;
        }
      }
    }
  }
  
  public void writeObjectBody(XmlSerializer paramXmlSerializer, SoapObject paramSoapObject)
  {
    SoapObject localSoapObject = paramSoapObject;
    int i = paramSoapObject.getAttributeCount();
    int j = 0;
    while (j < i)
    {
      AttributeInfo localAttributeInfo = new org/ksoap2/serialization/AttributeInfo;
      localAttributeInfo.<init>();
      localSoapObject.getAttributeInfo(j, localAttributeInfo);
      String str1 = localAttributeInfo.getNamespace();
      String str2 = localAttributeInfo.getName();
      String str3 = localAttributeInfo.getValue().toString();
      paramXmlSerializer.attribute(str1, str2, str3);
      j += 1;
    }
    writeObjectBody(paramXmlSerializer, paramSoapObject);
  }
  
  protected void writeProperty(XmlSerializer paramXmlSerializer, Object paramObject, PropertyInfo paramPropertyInfo)
  {
    boolean bool1 = true;
    int i = 2;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramObject == null)
    {
      localObject1 = xsi;
      int j = version;
      int n = 120;
      if (j >= n)
      {
        localObject2 = "nil";
        localObject3 = "true";
        paramXmlSerializer.attribute((String)localObject1, (String)localObject2, (String)localObject3);
      }
    }
    for (;;)
    {
      return;
      localObject2 = "null";
      break;
      Object[] arrayOfObject = getInfo(null, paramObject);
      boolean bool2 = multiRef;
      if (!bool2)
      {
        localObject2 = arrayOfObject[i];
        if (localObject2 == null) {}
      }
      else
      {
        localObject2 = multiRef;
        int i1 = ((Vector)localObject2).indexOf(paramObject);
        int k = -1;
        if (i1 == k)
        {
          i1 = multiRef.size();
          localObject2 = multiRef;
          ((Vector)localObject2).addElement(paramObject);
        }
        localObject1 = "href";
        localObject2 = arrayOfObject[i];
        if (localObject2 == null)
        {
          localObject2 = new java/lang/StringBuffer;
          ((StringBuffer)localObject2).<init>();
          localObject3 = "#o";
        }
        for (localObject2 = (String)localObject3 + i1;; localObject2 = localObject3)
        {
          paramXmlSerializer.attribute(null, (String)localObject1, (String)localObject2);
          break;
          localObject2 = new java/lang/StringBuffer;
          ((StringBuffer)localObject2).<init>();
          localObject2 = ((StringBuffer)localObject2).append("#");
          localObject3 = arrayOfObject[i];
        }
      }
      boolean bool3 = implicitTypes;
      if (bool3)
      {
        localObject2 = paramObject.getClass();
        localObject1 = type;
        if (localObject2 == localObject1) {}
      }
      else
      {
        bool3 = false;
        localObject2 = (String)arrayOfObject[0];
        String str = paramXmlSerializer.getPrefix((String)localObject2, bool1);
        localObject2 = xsi;
        localObject1 = "type";
        localObject3 = new java/lang/StringBuffer;
        ((StringBuffer)localObject3).<init>();
        localObject3 = ((StringBuffer)localObject3).append(str).append(":");
        Object localObject4 = arrayOfObject[bool1];
        localObject3 = localObject4;
        paramXmlSerializer.attribute((String)localObject2, (String)localObject1, (String)localObject3);
      }
      int m = 3;
      localObject2 = arrayOfObject[m];
      writeElement(paramXmlSerializer, paramObject, paramPropertyInfo, localObject2);
    }
  }
  
  protected void writeVectorBody(XmlSerializer paramXmlSerializer, Vector paramVector, PropertyInfo paramPropertyInfo)
  {
    String str1 = "item";
    String str2 = null;
    Object localObject1;
    String str3;
    Object[] arrayOfObject;
    boolean bool;
    Object localObject2;
    Object localObject3;
    label168:
    int k;
    int m;
    if (paramPropertyInfo == null)
    {
      paramPropertyInfo = PropertyInfo.OBJECT_TYPE;
      int i = paramVector.size();
      localObject1 = type;
      str3 = null;
      arrayOfObject = getInfo(localObject1, null);
      bool = implicitTypes;
      if (bool) {
        break label252;
      }
      str3 = enc;
      localObject2 = "arrayType";
      localObject3 = new java/lang/StringBuffer;
      ((StringBuffer)localObject3).<init>();
      localObject1 = (String)arrayOfObject[0];
      localObject1 = paramXmlSerializer.getPrefix((String)localObject1, false);
      localObject1 = ((StringBuffer)localObject3).append((String)localObject1).append(":");
      int j = 1;
      localObject3 = arrayOfObject[j];
      localObject1 = ((StringBuffer)localObject1).append(localObject3).append("[").append(i);
      localObject3 = "]";
      localObject1 = (String)localObject3;
      paramXmlSerializer.attribute(str3, (String)localObject2, (String)localObject1);
      k = 0;
      m = 0;
      label174:
      if (m >= i) {
        return;
      }
      localObject1 = paramVector.elementAt(m);
      if (localObject1 != null) {
        break label269;
      }
      k = 1;
    }
    for (;;)
    {
      m += 1;
      break label174;
      bool = paramPropertyInfo instanceof PropertyInfo;
      if (!bool) {
        break;
      }
      localObject1 = name;
      if (localObject1 == null) {
        break;
      }
      str1 = name;
      str2 = namespace;
      break;
      label252:
      if (str2 != null) {
        break label168;
      }
      str2 = (String)arrayOfObject[0];
      break label168;
      label269:
      paramXmlSerializer.startTag(str2, str1);
      if (k != 0)
      {
        localObject1 = enc;
        str3 = "position";
        localObject2 = new java/lang/StringBuffer;
        ((StringBuffer)localObject2).<init>();
        localObject2 = ((StringBuffer)localObject2).append("[").append(m);
        localObject3 = "]";
        localObject2 = (String)localObject3;
        paramXmlSerializer.attribute((String)localObject1, str3, (String)localObject2);
        k = 0;
      }
      localObject1 = paramVector.elementAt(m);
      writeProperty(paramXmlSerializer, localObject1, (PropertyInfo)paramPropertyInfo);
      paramXmlSerializer.endTag(str2, str1);
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/ksoap2/serialization/SoapSerializationEnvelope.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */