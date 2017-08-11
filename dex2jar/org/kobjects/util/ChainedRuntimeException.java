package org.kobjects.util;

public class ChainedRuntimeException
  extends RuntimeException
{
  Exception chain;
  
  ChainedRuntimeException() {}
  
  ChainedRuntimeException(Exception paramException, String paramString)
  {
    super(str + ": " + paramException.toString());
    chain = paramException;
  }
  
  public static ChainedRuntimeException create(Exception paramException, String paramString)
  {
    try
    {
      ChainedRuntimeException localChainedRuntimeException = ((ChainedRuntimeException)Class.forName("org.kobjects.util.ChainedRuntimeExceptionSE").newInstance())._create(paramException, paramString);
      return localChainedRuntimeException;
    }
    catch (Exception localException) {}
    return new ChainedRuntimeException(paramException, paramString);
  }
  
  ChainedRuntimeException _create(Exception paramException, String paramString)
  {
    throw new RuntimeException("ERR!");
  }
  
  public Exception getChained()
  {
    return chain;
  }
  
  public void printStackTrace()
  {
    super.printStackTrace();
    if (chain != null) {
      chain.printStackTrace();
    }
  }
}


/* Location:              /home/nemo/projects/personal/ors/ORS-dex2jar.jar!/org/kobjects/util/ChainedRuntimeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */