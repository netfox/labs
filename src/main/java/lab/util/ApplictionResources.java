/*************************************************************************
 (C) COPYRIGHT International Business Machines Corp. 2012
 All Rights Reserved

 US Government Users Restricted Rights - Use, duplication or
 disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 **************************************************************************/
package lab.util;

import javax.servlet.ServletContext;
import java.io.InputStream;

public class ApplictionResources {

  private static ApplictionResources instance;
  private ServletContext context;

  private ApplictionResources() {

  }

  public static ApplictionResources getInstance() {
    if (instance == null) {
      instance = new ApplictionResources();
    }
    return instance;
  }

  public InputStream getResourceAsStream(String path) {
    return context.getResourceAsStream(path);
  }

  public void setContext(ServletContext context) {
    this.context = context;
  }
}
