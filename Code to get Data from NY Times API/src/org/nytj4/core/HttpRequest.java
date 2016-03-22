 
/**
 * @author Kartik Kapadia
 */
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// //////////////////////////////////////////////////////////////////////////////
package org.nytj4.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;

public class HttpRequest {

  String baseUrl;
  Query query;
  String response;
  NYTAPIKey apiKey;

  public HttpRequest(String baseUrl, Query query, NYTAPIKey key) {
    this.baseUrl = baseUrl;
    this.query = query;
    this.apiKey = key;
    try {
      request(new URL(baseUrl + "?query=obama&api-key=" + apiKey.getKey()));
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

  public HttpRequest() {
    apiKey = null;
  }

  public HttpRequest(URL url) {
    request(url);
  }

  public static JSONObject urlToJSON(URL url) {
    JSONObject json = null;
    try {
      json = new JSONObject(request(url));
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return json;
  }

  public static String request(URL url) {
    StringBuffer stringBuffer = new StringBuffer();
    String result = null;
    try {
      URLConnection connection = url.openConnection();
      BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String line;
      while ((line = rd.readLine()) != null) {
        stringBuffer.append(line);
      }
      rd.close();
      result = stringBuffer.toString();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  public JSONObject getResponseAsJSON() {
    JSONObject responseJson = null;
    try {
      responseJson = new JSONObject(response);
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return responseJson;
  }

  public String getResponseAsString() {
    return response;
  }

}
