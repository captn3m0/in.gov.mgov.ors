package org.kobjects.isodate;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class IsoDate
{
  public static final int DATE = 1;
  public static final int DATE_TIME = 3;
  public static final int TIME = 2;
  
  public static String dateToString(Date paramDate, int paramInt)
  {
    char c1 = ':';
    char c2 = '-';
    Calendar localCalendar = Calendar.getInstance();
    Object localObject = TimeZone.getTimeZone("GMT");
    localCalendar.setTimeZone((TimeZone)localObject);
    localCalendar.setTime(paramDate);
    StringBuffer localStringBuffer = new java/lang/StringBuffer;
    localStringBuffer.<init>();
    int i = paramInt & 0x1;
    if (i != 0)
    {
      int j = localCalendar.get(1);
      i = j / 100;
      dd(localStringBuffer, i);
      i = j % 100;
      dd(localStringBuffer, i);
      localStringBuffer.append(c2);
      i = localCalendar.get(2) + 0 + 1;
      dd(localStringBuffer, i);
      localStringBuffer.append(c2);
      i = localCalendar.get(5);
      dd(localStringBuffer, i);
      i = 3;
      if (paramInt == i)
      {
        localObject = "T";
        localStringBuffer.append((String)localObject);
      }
    }
    i = paramInt & 0x2;
    if (i != 0)
    {
      i = localCalendar.get(11);
      dd(localStringBuffer, i);
      localStringBuffer.append(c1);
      i = localCalendar.get(12);
      dd(localStringBuffer, i);
      localStringBuffer.append(c1);
      i = localCalendar.get(13);
      dd(localStringBuffer, i);
      localStringBuffer.append('.');
      int k = localCalendar.get(14);
      i = (char)(k / 100 + 48);
      localStringBuffer.append(i);
      i = k % 100;
      dd(localStringBuffer, i);
      i = 90;
      localStringBuffer.append(i);
    }
    return localStringBuffer.toString();
  }
  
  static void dd(StringBuffer paramStringBuffer, int paramInt)
  {
    char c = (char)(paramInt / 10 + 48);
    paramStringBuffer.append(c);
    c = (char)(paramInt % 10 + 48);
    paramStringBuffer.append(c);
  }
  
  public static Date stringToDate(String paramString, int paramInt)
  {
    int i = 2;
    int j = 14;
    int k = 5;
    int m = 11;
    Calendar localCalendar = Calendar.getInstance();
    int n = paramInt & 0x1;
    int i1;
    label179:
    int i3;
    int i4;
    int i5;
    label297:
    int i6;
    if (n != 0)
    {
      String str = paramString.substring(0, 4);
      i1 = Integer.parseInt(str);
      localCalendar.set(1, i1);
      n = Integer.parseInt(paramString.substring(k, 7)) + -1 + 0;
      localCalendar.set(i, n);
      i1 = 10;
      localObject = paramString.substring(8, i1);
      n = Integer.parseInt((String)localObject);
      localCalendar.set(k, n);
      n = 3;
      if (paramInt == n)
      {
        n = paramString.length();
        if (n >= m) {}
      }
      else
      {
        localCalendar.set(m, 0);
        localCalendar.set(12, 0);
        n = 13;
        localCalendar.set(n, 0);
        localCalendar.set(j, 0);
        localObject = localCalendar.getTime();
        return (Date)localObject;
      }
      paramString = paramString.substring(m);
      localObject = paramString.substring(0, i);
      n = Integer.parseInt((String)localObject);
      localCalendar.set(m, n);
      i1 = Integer.parseInt(paramString.substring(3, k));
      localCalendar.set(12, i1);
      int i2 = 8;
      str = paramString.substring(6, i2);
      i1 = Integer.parseInt(str);
      localCalendar.set(13, i1);
      i3 = 8;
      n = paramString.length();
      if (i3 >= n) {
        break label503;
      }
      n = paramString.charAt(i3);
      i1 = 46;
      if (n != i1) {
        break label503;
      }
      i4 = 0;
      i5 = 100;
      i3 += 1;
      i6 = paramString.charAt(i3);
      n = 48;
      if (i6 >= n)
      {
        n = 57;
        if (i6 <= n) {
          break label476;
        }
      }
      localCalendar.set(j, i4);
      label341:
      n = paramString.length();
      if (i3 < n)
      {
        n = paramString.charAt(i3);
        i1 = 43;
        if (n != i1)
        {
          n = paramString.charAt(i3);
          i1 = 45;
          if (n != i1) {
            break label513;
          }
        }
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        localObject = ((StringBuilder)localObject).append("GMT");
        str = paramString.substring(i3);
        localObject = TimeZone.getTimeZone(str);
        localCalendar.setTimeZone((TimeZone)localObject);
      }
    }
    for (;;)
    {
      localObject = localCalendar.getTime();
      break;
      localObject = new java/util/Date;
      long l = 0L;
      ((Date)localObject).<init>(l);
      localCalendar.setTime((Date)localObject);
      break label179;
      label476:
      n = (i6 + -48) * i5;
      i4 += n;
      i5 /= 10;
      break label297;
      label503:
      localCalendar.set(j, 0);
      break label341;
      label513:
      n = paramString.charAt(i3);
      i1 = 90;
      if (n != i1) {
        break label549;
      }
      localObject = TimeZone.getTimeZone("GMT");
      localCalendar.setTimeZone((TimeZone)localObject);
    }
    label549:
    Object localObject = new java/lang/RuntimeException;
    ((RuntimeException)localObject).<init>("illegal time format!");
    throw ((Throwable)localObject);
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/isodate/IsoDate.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */