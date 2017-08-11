package in.gov.mgov.ors;

public class LabReportDetailsRowModel
{
  private String normal_range = "";
  private String observation_result = "";
  private String test_name = "";
  
  public LabReportDetailsRowModel() {}
  
  public LabReportDetailsRowModel(String paramString1, String paramString2, String paramString3)
  {
    test_name = paramString1;
    observation_result = paramString2;
    normal_range = paramString3;
  }
  
  public String getnormal_range()
  {
    return normal_range;
  }
  
  public String getobservation_result()
  {
    return observation_result;
  }
  
  public String gettest_name()
  {
    return test_name;
  }
  
  public void setnormal_range(String paramString)
  {
    normal_range = paramString;
  }
  
  public void setobservation_result(String paramString)
  {
    observation_result = paramString;
  }
  
  public void settest_name(String paramString)
  {
    test_name = paramString;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/in/gov/mgov/ors/LabReportDetailsRowModel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */