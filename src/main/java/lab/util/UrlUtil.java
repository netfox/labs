/*************************************************************************
 (C) COPYRIGHT International Business Machines Corp. 2012
 All Rights Reserved

 US Government Users Restricted Rights - Use, duplication or
 disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 **************************************************************************/
package lab.util;

import javax.servlet.http.HttpServletRequest;

public class UrlUtil {

  public static String getCommandName(HttpServletRequest request) {
    return request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
  }

  public static String getPage(HttpServletRequest request) {
    String pageName;
    if (request.getRequestURI().contains("index.jsp".replace("jsp", "fc"))) {
      return request.getContextPath() + "/" + "index.jsp";
    }
    pageName = request.getRequestURI().substring(request.getContextPath().length());
    return pageName.replace("fc", "jsp");
  }
}
