package org.kobjects.pim;

public class VCard
  extends PimItem
{
  public VCard() {}
  
  public VCard(VCard paramVCard)
  {
    super(paramVCard);
  }
  
  public int getArraySize(String paramString)
  {
    String str = "n";
    boolean bool1 = paramString.equals(str);
    int i;
    if (bool1) {
      i = 5;
    }
    for (;;)
    {
      return i;
      str = "adr";
      boolean bool2 = paramString.equals(str);
      int j;
      if (bool2) {
        j = 6;
      } else {
        j = -1;
      }
    }
  }
  
  public String getType()
  {
    return "vcard";
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/pim/VCard.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */