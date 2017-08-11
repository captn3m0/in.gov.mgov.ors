package com.aadhaar.auth;

public class Verhoeff
{
  static int[][] d;
  static int[] inv;
  static int[][] p;
  
  static
  {
    int i = 3;
    int j = 2;
    int k = 1;
    int m = 10;
    Object localObject = new int[m][];
    int[] arrayOfInt1 = new int[m];
    int[] tmp22_20 = arrayOfInt1;
    int[] tmp23_22 = tmp22_20;
    int[] tmp23_22 = tmp22_20;
    tmp23_22[0] = 0;
    tmp23_22[1] = 1;
    int[] tmp30_23 = tmp23_22;
    int[] tmp30_23 = tmp23_22;
    tmp30_23[2] = 2;
    tmp30_23[3] = 3;
    int[] tmp37_30 = tmp30_23;
    int[] tmp37_30 = tmp30_23;
    tmp37_30[4] = 4;
    tmp37_30[5] = 5;
    int[] tmp44_37 = tmp37_30;
    int[] tmp44_37 = tmp37_30;
    tmp44_37[6] = 6;
    tmp44_37[7] = 7;
    tmp44_37[8] = 8;
    tmp44_37[9] = 9;
    localObject[0] = arrayOfInt1;
    arrayOfInt1 = new int[m];
    int[] tmp78_76 = arrayOfInt1;
    int[] tmp79_78 = tmp78_76;
    int[] tmp79_78 = tmp78_76;
    tmp79_78[0] = 1;
    tmp79_78[1] = 2;
    int[] tmp86_79 = tmp79_78;
    int[] tmp86_79 = tmp79_78;
    tmp86_79[2] = 3;
    tmp86_79[3] = 4;
    int[] tmp93_86 = tmp86_79;
    int[] tmp93_86 = tmp86_79;
    tmp93_86[4] = 0;
    tmp93_86[5] = 6;
    int[] tmp101_93 = tmp93_86;
    int[] tmp101_93 = tmp93_86;
    tmp101_93[6] = 7;
    tmp101_93[7] = 8;
    tmp101_93[8] = 9;
    tmp101_93[9] = 5;
    localObject[k] = arrayOfInt1;
    arrayOfInt1 = new int[m];
    int[] tmp134_132 = arrayOfInt1;
    int[] tmp135_134 = tmp134_132;
    int[] tmp135_134 = tmp134_132;
    tmp135_134[0] = 2;
    tmp135_134[1] = 3;
    int[] tmp142_135 = tmp135_134;
    int[] tmp142_135 = tmp135_134;
    tmp142_135[2] = 4;
    tmp142_135[3] = 0;
    int[] tmp149_142 = tmp142_135;
    int[] tmp149_142 = tmp142_135;
    tmp149_142[4] = 1;
    tmp149_142[5] = 7;
    int[] tmp157_149 = tmp149_142;
    int[] tmp157_149 = tmp149_142;
    tmp157_149[6] = 8;
    tmp157_149[7] = 9;
    tmp157_149[8] = 5;
    tmp157_149[9] = 6;
    localObject[j] = arrayOfInt1;
    arrayOfInt1 = new int[m];
    int[] tmp190_188 = arrayOfInt1;
    int[] tmp191_190 = tmp190_188;
    int[] tmp191_190 = tmp190_188;
    tmp191_190[0] = 3;
    tmp191_190[1] = 4;
    int[] tmp198_191 = tmp191_190;
    int[] tmp198_191 = tmp191_190;
    tmp198_191[2] = 0;
    tmp198_191[3] = 1;
    int[] tmp205_198 = tmp198_191;
    int[] tmp205_198 = tmp198_191;
    tmp205_198[4] = 2;
    tmp205_198[5] = 8;
    int[] tmp213_205 = tmp205_198;
    int[] tmp213_205 = tmp205_198;
    tmp213_205[6] = 9;
    tmp213_205[7] = 5;
    tmp213_205[8] = 6;
    tmp213_205[9] = 7;
    localObject[i] = arrayOfInt1;
    int[] arrayOfInt2 = new int[m];
    int[] tmp246_244 = arrayOfInt2;
    int[] tmp247_246 = tmp246_244;
    int[] tmp247_246 = tmp246_244;
    tmp247_246[0] = 4;
    tmp247_246[1] = 0;
    int[] tmp254_247 = tmp247_246;
    int[] tmp254_247 = tmp247_246;
    tmp254_247[2] = 1;
    tmp254_247[3] = 2;
    int[] tmp261_254 = tmp254_247;
    int[] tmp261_254 = tmp254_247;
    tmp261_254[4] = 3;
    tmp261_254[5] = 9;
    int[] tmp269_261 = tmp261_254;
    int[] tmp269_261 = tmp261_254;
    tmp269_261[6] = 5;
    tmp269_261[7] = 6;
    tmp269_261[8] = 7;
    tmp269_261[9] = 8;
    localObject[4] = arrayOfInt2;
    arrayOfInt2 = new int[m];
    int[] tmp302_300 = arrayOfInt2;
    int[] tmp303_302 = tmp302_300;
    int[] tmp303_302 = tmp302_300;
    tmp303_302[0] = 5;
    tmp303_302[1] = 9;
    int[] tmp311_303 = tmp303_302;
    int[] tmp311_303 = tmp303_302;
    tmp311_303[2] = 8;
    tmp311_303[3] = 7;
    int[] tmp320_311 = tmp311_303;
    int[] tmp320_311 = tmp311_303;
    tmp320_311[4] = 6;
    tmp320_311[5] = 0;
    int[] tmp328_320 = tmp320_311;
    int[] tmp328_320 = tmp320_311;
    tmp328_320[6] = 4;
    tmp328_320[7] = 3;
    tmp328_320[8] = 2;
    tmp328_320[9] = 1;
    localObject[5] = arrayOfInt2;
    arrayOfInt2 = new int[m];
    int[] tmp358_356 = arrayOfInt2;
    int[] tmp359_358 = tmp358_356;
    int[] tmp359_358 = tmp358_356;
    tmp359_358[0] = 6;
    tmp359_358[1] = 5;
    int[] tmp367_359 = tmp359_358;
    int[] tmp367_359 = tmp359_358;
    tmp367_359[2] = 9;
    tmp367_359[3] = 8;
    int[] tmp376_367 = tmp367_359;
    int[] tmp376_367 = tmp367_359;
    tmp376_367[4] = 7;
    tmp376_367[5] = 1;
    int[] tmp384_376 = tmp376_367;
    int[] tmp384_376 = tmp376_367;
    tmp384_376[6] = 0;
    tmp384_376[7] = 4;
    tmp384_376[8] = 3;
    tmp384_376[9] = 2;
    localObject[6] = arrayOfInt2;
    arrayOfInt2 = new int[m];
    int[] tmp415_413 = arrayOfInt2;
    int[] tmp416_415 = tmp415_413;
    int[] tmp416_415 = tmp415_413;
    tmp416_415[0] = 7;
    tmp416_415[1] = 6;
    int[] tmp425_416 = tmp416_415;
    int[] tmp425_416 = tmp416_415;
    tmp425_416[2] = 5;
    tmp425_416[3] = 9;
    int[] tmp433_425 = tmp425_416;
    int[] tmp433_425 = tmp425_416;
    tmp433_425[4] = 8;
    tmp433_425[5] = 2;
    int[] tmp441_433 = tmp433_425;
    int[] tmp441_433 = tmp433_425;
    tmp441_433[6] = 1;
    tmp441_433[7] = 0;
    tmp441_433[8] = 4;
    tmp441_433[9] = 3;
    localObject[7] = arrayOfInt2;
    arrayOfInt2 = new int[m];
    int[] tmp472_470 = arrayOfInt2;
    int[] tmp473_472 = tmp472_470;
    int[] tmp473_472 = tmp472_470;
    tmp473_472[0] = 8;
    tmp473_472[1] = 7;
    int[] tmp482_473 = tmp473_472;
    int[] tmp482_473 = tmp473_472;
    tmp482_473[2] = 6;
    tmp482_473[3] = 5;
    int[] tmp490_482 = tmp482_473;
    int[] tmp490_482 = tmp482_473;
    tmp490_482[4] = 9;
    tmp490_482[5] = 3;
    int[] tmp498_490 = tmp490_482;
    int[] tmp498_490 = tmp490_482;
    tmp498_490[6] = 2;
    tmp498_490[7] = 1;
    tmp498_490[8] = 0;
    tmp498_490[9] = 4;
    localObject[8] = arrayOfInt2;
    arrayOfInt2 = new int[m];
    int[] tmp529_527 = arrayOfInt2;
    int[] tmp530_529 = tmp529_527;
    int[] tmp530_529 = tmp529_527;
    tmp530_529[0] = 9;
    tmp530_529[1] = 8;
    int[] tmp539_530 = tmp530_529;
    int[] tmp539_530 = tmp530_529;
    tmp539_530[2] = 7;
    tmp539_530[3] = 6;
    int[] tmp548_539 = tmp539_530;
    int[] tmp548_539 = tmp539_530;
    tmp548_539[4] = 5;
    tmp548_539[5] = 4;
    int[] tmp555_548 = tmp548_539;
    int[] tmp555_548 = tmp548_539;
    tmp555_548[6] = 3;
    tmp555_548[7] = 2;
    tmp555_548[8] = 1;
    tmp555_548[9] = 0;
    localObject[9] = arrayOfInt2;
    d = (int[][])localObject;
    localObject = new int[8][];
    arrayOfInt1 = new int[m];
    int[] tmp598_596 = arrayOfInt1;
    int[] tmp599_598 = tmp598_596;
    int[] tmp599_598 = tmp598_596;
    tmp599_598[0] = 0;
    tmp599_598[1] = 1;
    int[] tmp606_599 = tmp599_598;
    int[] tmp606_599 = tmp599_598;
    tmp606_599[2] = 2;
    tmp606_599[3] = 3;
    int[] tmp613_606 = tmp606_599;
    int[] tmp613_606 = tmp606_599;
    tmp613_606[4] = 4;
    tmp613_606[5] = 5;
    int[] tmp620_613 = tmp613_606;
    int[] tmp620_613 = tmp613_606;
    tmp620_613[6] = 6;
    tmp620_613[7] = 7;
    tmp620_613[8] = 8;
    tmp620_613[9] = 9;
    localObject[0] = arrayOfInt1;
    arrayOfInt1 = new int[m];
    int[] tmp654_652 = arrayOfInt1;
    int[] tmp655_654 = tmp654_652;
    int[] tmp655_654 = tmp654_652;
    tmp655_654[0] = 1;
    tmp655_654[1] = 5;
    int[] tmp662_655 = tmp655_654;
    int[] tmp662_655 = tmp655_654;
    tmp662_655[2] = 7;
    tmp662_655[3] = 6;
    int[] tmp671_662 = tmp662_655;
    int[] tmp671_662 = tmp662_655;
    tmp671_662[4] = 2;
    tmp671_662[5] = 8;
    int[] tmp679_671 = tmp671_662;
    int[] tmp679_671 = tmp671_662;
    tmp679_671[6] = 3;
    tmp679_671[7] = 0;
    tmp679_671[8] = 9;
    tmp679_671[9] = 4;
    localObject[k] = arrayOfInt1;
    arrayOfInt1 = new int[m];
    int[] tmp710_708 = arrayOfInt1;
    int[] tmp711_710 = tmp710_708;
    int[] tmp711_710 = tmp710_708;
    tmp711_710[0] = 5;
    tmp711_710[1] = 8;
    int[] tmp719_711 = tmp711_710;
    int[] tmp719_711 = tmp711_710;
    tmp719_711[2] = 0;
    tmp719_711[3] = 3;
    int[] tmp726_719 = tmp719_711;
    int[] tmp726_719 = tmp719_711;
    tmp726_719[4] = 7;
    tmp726_719[5] = 9;
    int[] tmp735_726 = tmp726_719;
    int[] tmp735_726 = tmp726_719;
    tmp735_726[6] = 6;
    tmp735_726[7] = 1;
    tmp735_726[8] = 4;
    tmp735_726[9] = 2;
    localObject[j] = arrayOfInt1;
    arrayOfInt1 = new int[m];
    int[] tmp766_764 = arrayOfInt1;
    int[] tmp767_766 = tmp766_764;
    int[] tmp767_766 = tmp766_764;
    tmp767_766[0] = 8;
    tmp767_766[1] = 9;
    int[] tmp776_767 = tmp767_766;
    int[] tmp776_767 = tmp767_766;
    tmp776_767[2] = 1;
    tmp776_767[3] = 6;
    int[] tmp784_776 = tmp776_767;
    int[] tmp784_776 = tmp776_767;
    tmp784_776[4] = 0;
    tmp784_776[5] = 4;
    int[] tmp791_784 = tmp784_776;
    int[] tmp791_784 = tmp784_776;
    tmp791_784[6] = 3;
    tmp791_784[7] = 5;
    tmp791_784[8] = 2;
    tmp791_784[9] = 7;
    localObject[i] = arrayOfInt1;
    arrayOfInt2 = new int[m];
    int[] tmp822_820 = arrayOfInt2;
    int[] tmp823_822 = tmp822_820;
    int[] tmp823_822 = tmp822_820;
    tmp823_822[0] = 9;
    tmp823_822[1] = 4;
    int[] tmp831_823 = tmp823_822;
    int[] tmp831_823 = tmp823_822;
    tmp831_823[2] = 5;
    tmp831_823[3] = 3;
    int[] tmp838_831 = tmp831_823;
    int[] tmp838_831 = tmp831_823;
    tmp838_831[4] = 1;
    tmp838_831[5] = 2;
    int[] tmp845_838 = tmp838_831;
    int[] tmp845_838 = tmp838_831;
    tmp845_838[6] = 6;
    tmp845_838[7] = 8;
    tmp845_838[8] = 7;
    tmp845_838[9] = 0;
    localObject[4] = arrayOfInt2;
    arrayOfInt2 = new int[m];
    int[] tmp878_876 = arrayOfInt2;
    int[] tmp879_878 = tmp878_876;
    int[] tmp879_878 = tmp878_876;
    tmp879_878[0] = 4;
    tmp879_878[1] = 2;
    int[] tmp886_879 = tmp879_878;
    int[] tmp886_879 = tmp879_878;
    tmp886_879[2] = 8;
    tmp886_879[3] = 6;
    int[] tmp895_886 = tmp886_879;
    int[] tmp895_886 = tmp886_879;
    tmp895_886[4] = 5;
    tmp895_886[5] = 7;
    int[] tmp903_895 = tmp895_886;
    int[] tmp903_895 = tmp895_886;
    tmp903_895[6] = 3;
    tmp903_895[7] = 9;
    tmp903_895[8] = 0;
    tmp903_895[9] = 1;
    localObject[5] = arrayOfInt2;
    arrayOfInt2 = new int[m];
    int[] tmp934_932 = arrayOfInt2;
    int[] tmp935_934 = tmp934_932;
    int[] tmp935_934 = tmp934_932;
    tmp935_934[0] = 2;
    tmp935_934[1] = 7;
    int[] tmp943_935 = tmp935_934;
    int[] tmp943_935 = tmp935_934;
    tmp943_935[2] = 9;
    tmp943_935[3] = 3;
    int[] tmp951_943 = tmp943_935;
    int[] tmp951_943 = tmp943_935;
    tmp951_943[4] = 8;
    tmp951_943[5] = 0;
    int[] tmp959_951 = tmp951_943;
    int[] tmp959_951 = tmp951_943;
    tmp959_951[6] = 6;
    tmp959_951[7] = 4;
    tmp959_951[8] = 1;
    tmp959_951[9] = 5;
    localObject[6] = arrayOfInt2;
    arrayOfInt2 = new int[m];
    int[] tmp991_989 = arrayOfInt2;
    int[] tmp992_991 = tmp991_989;
    int[] tmp992_991 = tmp991_989;
    tmp992_991[0] = 7;
    tmp992_991[1] = 0;
    int[] tmp1000_992 = tmp992_991;
    int[] tmp1000_992 = tmp992_991;
    tmp1000_992[2] = 4;
    tmp1000_992[3] = 6;
    int[] tmp1008_1000 = tmp1000_992;
    int[] tmp1008_1000 = tmp1000_992;
    tmp1008_1000[4] = 9;
    tmp1008_1000[5] = 1;
    int[] tmp1016_1008 = tmp1008_1000;
    int[] tmp1016_1008 = tmp1008_1000;
    tmp1016_1008[6] = 3;
    tmp1016_1008[7] = 2;
    tmp1016_1008[8] = 5;
    tmp1016_1008[9] = 8;
    localObject[7] = arrayOfInt2;
    p = (int[][])localObject;
    localObject = new int[m];
    Object tmp1053_1051 = localObject;
    Object tmp1054_1053 = tmp1053_1051;
    Object tmp1054_1053 = tmp1053_1051;
    tmp1054_1053[0] = 0;
    tmp1054_1053[1] = 4;
    Object tmp1061_1054 = tmp1054_1053;
    Object tmp1061_1054 = tmp1054_1053;
    tmp1061_1054[2] = 3;
    tmp1061_1054[3] = 2;
    Object tmp1068_1061 = tmp1061_1054;
    Object tmp1068_1061 = tmp1061_1054;
    tmp1068_1061[4] = 1;
    tmp1068_1061[5] = 5;
    Object tmp1075_1068 = tmp1068_1061;
    Object tmp1075_1068 = tmp1068_1061;
    tmp1075_1068[6] = 6;
    tmp1075_1068[7] = 7;
    tmp1075_1068[8] = 8;
    tmp1075_1068[9] = 9;
    inv = (int[])localObject;
  }
  
  private static int[] Reverse(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i];
    int j = 0;
    for (;;)
    {
      i = paramArrayOfInt.length;
      if (j >= i) {
        break;
      }
      i = paramArrayOfInt.length;
      int k = j + 1;
      i -= k;
      i = paramArrayOfInt[i];
      arrayOfInt[j] = i;
      j += 1;
    }
    return arrayOfInt;
  }
  
  private static int[] StringToReversedIntArray(String paramString)
  {
    int i = paramString.length();
    int[] arrayOfInt = new int[i];
    int j = 0;
    for (;;)
    {
      i = paramString.length();
      if (j >= i) {
        break;
      }
      i = j + 1;
      String str = paramString.substring(j, i);
      i = Integer.parseInt(str);
      arrayOfInt[j] = i;
      j += 1;
    }
    return Reverse(arrayOfInt);
  }
  
  public static String generateVerhoeff(String paramString)
  {
    int i = 0;
    int[] arrayOfInt1 = StringToReversedIntArray(paramString);
    int j = 0;
    for (;;)
    {
      int k = arrayOfInt1.length;
      if (j >= k) {
        break;
      }
      int[] arrayOfInt2 = d[i];
      Object localObject = p;
      int m = (j + 1) % 8;
      localObject = localObject[m];
      m = arrayOfInt1[j];
      int n = localObject[m];
      i = arrayOfInt2[n];
      j += 1;
    }
    return Integer.toString(inv[i]);
  }
  
  public static boolean validateVerhoeff(String paramString)
  {
    int i = 0;
    int[] arrayOfInt1 = StringToReversedIntArray(paramString);
    int j = 0;
    int k;
    int[] arrayOfInt2;
    for (;;)
    {
      k = arrayOfInt1.length;
      if (j >= k) {
        break;
      }
      arrayOfInt2 = d[i];
      Object localObject = p;
      int n = j % 8;
      localObject = localObject[n];
      n = arrayOfInt1[j];
      int i1 = localObject[n];
      i = arrayOfInt2[i1];
      j += 1;
    }
    if (i == 0) {
      k = 1;
    }
    for (;;)
    {
      return k;
      int m = 0;
      arrayOfInt2 = null;
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/com/aadhaar/auth/Verhoeff.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */