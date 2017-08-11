package org.kobjects.util;

public class ChainedRuntimeException
  extends RuntimeException
{
  Exception chain;
  
  ChainedRuntimeException() {}
  
  ChainedRuntimeException(Exception paramException, String paramString)
  {
    super((String)localObject);
    chain = paramException;
  }
  
  public static ChainedRuntimeException create(Exception paramException, String paramString)
  {
    Object localObject = "org.kobjects.util.ChainedRuntimeExceptionSE";
    try
    {
      localObject = Class.forName((String)localObject);
      localObject = ((Class)localObject).newInstance();
      localObject = (ChainedRuntimeException)localObject;
      localObject = ((ChainedRuntimeException)localObject)._create(paramException, paramString);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ChainedRuntimeException localChainedRuntimeException = new org/kobjects/util/ChainedRuntimeException;
        localChainedRuntimeException.<init>(paramException, paramString);
      }
    }
    return (ChainedRuntimeException)localObject;
  }
  
  ChainedRuntimeException _create(Exception paramException, String paramString)
  {
    RuntimeException localRuntimeException = new java/lang/RuntimeException;
    localRuntimeException.<init>("ERR!");
    throw localRuntimeException;
  }
  
  public Exception getChained()
  {
    return chain;
  }
  
  public void printStackTrace()
  {
    super.printStackTrace();
    Exception localException = chain;
    if (localException != null)
    {
      localException = chain;
      localException.printStackTrace();
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-enjarify.jar!/org/kobjects/util/ChainedRuntimeException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */