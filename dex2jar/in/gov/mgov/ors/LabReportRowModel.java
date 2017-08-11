package in.gov.mgov.ors;

public class LabReportRowModel
{
  private String date = "";
  private String sample_no = "";
  private String test = "";
  private String type = "";
  
  public LabReportRowModel() {}
  
  public LabReportRowModel(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    test = paramString1;
    type = paramString2;
    date = paramString3;
    sample_no = paramString4;
  }
  
  public String getdate()
  {
    return date;
  }
  
  public String getsample_no()
  {
    return sample_no;
  }
  
  public String gettest()
  {
    return test;
  }
  
  public String gettype()
  {
    return type;
  }
  
  public void setdate(String paramString)
  {
    date = paramString;
  }
  
  public void setsample_no(String paramString)
  {
    sample_no = paramString;
  }
  
  public void settest(String paramString)
  {
    test = paramString;
  }
  
  public void settype(String paramString)
  {
    type = paramString;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/LabReportRowModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */