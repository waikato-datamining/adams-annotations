/*
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * License.java
 * Copyright (C) 2012-2024 University of Waikato, Hamilton, New Zealand
 */
package adams.core;

import java.net.URI;
import java.net.URL;

/**
 * Enumeration of software licenses.
 * 
 * @author  fracpete (fracpete at waikato dot ac dot nz)
 */
public enum License {

  /** UNKNOWN. */
  UNKNOWN,
  /** PROPRIETARY. */
  PROPRIETARY,
  /** to be determined. */
  TODO,
  /** Public domain, i.e., AS IS. */
  PUBLIC_DOMAIN("Public domain"),
  /** Apache 2.0. */
  APACHE2("Apache", "2.0", "http://opensource.org/licenses/Apache-2.0"),
  /** BSD 2-clause. */
  BSD2("BSD", "2-clause", "http://opensource.org/licenses/BSD-2-Clause"),
  /** BSD 3-clause. */
  BSD3("BSD", "3-clause", "http://opensource.org/licenses/BSD-3-Clause"),
  /** CC public domain. */
  CC_PD("CC Public Domain", null, "http://creativecommons.org/licenses/publicdomain/"),
  /** CC BY 2.5. */
  CC_BY_25("CC BY", "2.5", "http://creativecommons.org/licenses/by/2.5/"),
  /** CC BY 3.0. */
  CC_BY_3("CC BY", "3.0", "http://creativecommons.org/licenses/by/3.0/"),
  /** CC BY 3.0. */
  CC_BY_4("CC BY", "4.0", "http://creativecommons.org/licenses/by/4.0/"),
  /** CC BY-SA 2.5. */
  CC_BY_SA_25("CC BY-SA", "2.5", "http://creativecommons.org/licenses/by-sa/2.5/"),
  /** CC BY-SA 3.0. */
  CC_BY_SA_3("CC BY-SA", "3.0", "http://creativecommons.org/licenses/by-sa/3.0/"),
  /** CC BY-SA 4.0. */
  CC_BY_SA_4("CC BY-SA", "4.0", "http://creativecommons.org/licenses/by-sa/4.0/"),
  /** CC BY-NC-SA 2.5. */
  CC_BY_NC_SA_25("CC BY-NC-SA", "2.5", "http://creativecommons.org/licenses/by-nc-sa/2.5/"),
  /** CC BY-NC-SA 3.0. */
  CC_BY_NC_SA_3("CC BY-NC-SA", "3.0", "http://creativecommons.org/licenses/by-nc-sa/3.0/"),
  /** CC BY-NC-SA 4.0. */
  CC_BY_NC_SA_4("CC BY-NC-SA", "4.0", "http://creativecommons.org/licenses/by-nc-sa/4.0/"),
  /** GPL 2. */
  GPL2("GPL", "2", "http://opensource.org/licenses/GPL-2.0"),
  /** GPL 3. */
  GPL3("GPL", "3", "http://opensource.org/licenses/GPL-3.0"),
  /** LGPL 2.1. */
  LGPL21("LGPL", "2.1", "http://opensource.org/licenses/LGPL-2.1"),
  /** LGPL 2.1. */
  LGPL3("LGPL", "3.0", "http://opensource.org/licenses/LGPL-3.0"),
  /** MIT. */
  MIT("MIT", null, "http://opensource.org/licenses/MIT");
  
  /** the license. */
  private String m_License;
  
  /** the version. */
  private String m_Version;

  /** the commandline string. */
  private String m_Raw;
  
  /** the license URL. */
  private URL m_URL;

  /**
   * The constructor for versioned licenses.
   */
  private License() {
    this(null, null, null);
  }

  /**
   * The constructor for versioned licenses.
   *
   * @param license	the license to use
   */
  private License(String license) {
    this(license, null, null);
  }

  /**
   * The constructor for versioned licenses.
   *
   * @param license	the license to use
   * @param version	the version to use
   */
  private License(String license, String version) {
    this(license, version, null);
  }

  /**
   * The constructor for versioned licenses.
   *
   * @param license	the license to use
   * @param version	the version to use
   * @param url		the URL of the license
   */
  private License(String license, String version, String url) {
    m_Raw     = super.toString();
    m_License = license;
    m_Version = version;
    m_URL     = null;
    if (url != null) {
      try {
	m_URL = new URI(url).toURL();
      }
      catch (Exception e) {
	m_URL = null;
	throw new IllegalStateException("Failed to parse URL: " + url, e);
      }
    }
  }

  /**
   * Returns the display string.
   *
   * @return		the display string
   */
  public String toDisplay() {
    StringBuilder	result;
    
    result = new StringBuilder();
    
    if (m_URL != null)
      result.insert(0, " (" + m_URL + ")");
    
    if (m_Version != null) {
      if (result.length() > 0)
	result.insert(0, " ");
      result.insert(0, m_Version);
    }

    if (m_License != null) {
      if (result.length() > 0)
	result.insert(0, " ");
      result.insert(0, m_License);
    }

    // fallback
    if (result.length() == 0)
      result.append(m_Raw);
    
    return result.toString();
  }

  /**
   * Returns the raw enum string.
   *
   * @return		the raw enum string
   */
  public String toRaw() {
    return m_Raw;
  }

  /**
   * Returns the display string.
   *
   * @return		the display string
   */
  @Override
  public String toString() {
    return toDisplay();
  }
}
