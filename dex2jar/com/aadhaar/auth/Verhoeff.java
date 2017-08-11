package com.aadhaar.auth;

public class Verhoeff
{
  static int[][] d = { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 0, 6, 7, 8, 9, 5 }, { 2, 3, 4, 0, 1, 7, 8, 9, 5, 6 }, { 3, 4, 0, 1, 2, 8, 9, 5, 6, 7 }, { 4, 0, 1, 2, 3, 9, 5, 6, 7, 8 }, { 5, 9, 8, 7, 6, 0, 4, 3, 2, 1 }, { 6, 5, 9, 8, 7, 1, 0, 4, 3, 2 }, { 7, 6, 5, 9, 8, 2, 1, 0, 4, 3 }, { 8, 7, 6, 5, 9, 3, 2, 1, 0, 4 }, { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 } };
  static int[] inv = { 0, 4, 3, 2, 1, 5, 6, 7, 8, 9 };
  static int[][] p;
  
  static
  {
    int[] arrayOfInt1 = { 8, 9, 1, 6, 0, 4, 3, 5, 2, 7 };
    int[] arrayOfInt2 = { 9, 4, 5, 3, 1, 2, 6, 8, 7, 0 };
    int[] arrayOfInt3 = { 7, 0, 4, 6, 9, 1, 3, 2, 5, 8 };
    p = new int[][] { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 5, 7, 6, 2, 8, 3, 0, 9, 4 }, { 5, 8, 0, 3, 7, 9, 6, 1, 4, 2 }, arrayOfInt1, arrayOfInt2, { 4, 2, 8, 6, 5, 7, 3, 9, 0, 1 }, { 2, 7, 9, 3, 8, 0, 6, 4, 1, 5 }, arrayOfInt3 };
  }
  
  private static int[] Reverse(int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      arrayOfInt[i] = paramArrayOfInt[(paramArrayOfInt.length - (i + 1))];
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static int[] StringToReversedIntArray(String paramString)
  {
    int[] arrayOfInt = new int[paramString.length()];
    int i = 0;
    while (i < paramString.length())
    {
      arrayOfInt[i] = Integer.parseInt(paramString.substring(i, i + 1));
      i += 1;
    }
    return Reverse(arrayOfInt);
  }
  
  public static String generateVerhoeff(String paramString)
  {
    int j = 0;
    paramString = StringToReversedIntArray(paramString);
    int i = 0;
    while (i < paramString.length)
    {
      j = d[j][p[((i + 1) % 8)][paramString[i]]];
      i += 1;
    }
    return Integer.toString(inv[j]);
  }
  
  public static boolean validateVerhoeff(String paramString)
  {
    int j = 0;
    paramString = StringToReversedIntArray(paramString);
    int i = 0;
    while (i < paramString.length)
    {
      j = d[j][p[(i % 8)][paramString[i]]];
      i += 1;
    }
    return j == 0;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/com/aadhaar/auth/Verhoeff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */