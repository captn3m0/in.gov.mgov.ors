package in.gov.mgov.ors;

public class CancelRowModel
{
  private String appt_date = "";
  private String department = "";
  private String hospital = "";
  private String status = "";
  
  public CancelRowModel() {}
  
  public CancelRowModel(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    department = paramString1;
    appt_date = paramString2;
    hospital = paramString3;
    status = paramString4;
  }
  
  public String getAppt_date()
  {
    return appt_date;
  }
  
  public String getStatus()
  {
    return status;
  }
  
  public String getdepartment()
  {
    return department;
  }
  
  public String gethospital()
  {
    return hospital;
  }
  
  public void setAppt_date(String paramString)
  {
    appt_date = paramString;
  }
  
  public void setStatus(String paramString)
  {
    status = paramString;
  }
  
  public void setdepartment(String paramString)
  {
    department = paramString;
  }
  
  public void sethospital(String paramString)
  {
    hospital = paramString;
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/in/gov/mgov/ors/CancelRowModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */