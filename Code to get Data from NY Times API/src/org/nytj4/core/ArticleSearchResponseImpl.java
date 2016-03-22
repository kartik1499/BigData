 
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

import static org.nytj4.core.JSONParseUtil.JSONArrayToList;
import static org.nytj4.core.JSONParseUtil.getInt;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArticleSearchResponseImpl extends ResponseImpl implements ArticleSearchResponse {

	private int total;
	private JSONArray resultsJSON;
	private List<SearchResult> searchResults;
	private SearchResultList searchResultList;

	public ArticleSearchResponseImpl(JSONObject json) {
		super(json);
		parse();
	}

	private void parse() {
		

		try {
			JSONObject response = json.getJSONObject("response");
			JSONObject meta = response.getJSONObject("meta");
			total = getInt("hits", meta);
			if (!response.isNull("docs")) {
				resultsJSON = response.getJSONArray("docs");
				searchResultList = new JSONFactoryImpl().searchResultListFromJSON(resultsJSON);
			}
		}catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int getTotal() {
		return total;
	}

	@Override
	public List<Article> getArticles() {
		return searchResultList.getArticles();
	}

	@Override
	public List<SearchResult> getSearchResults() {
		return searchResults;
	}

	@Override
	public List<JSONObject> getResultsAsJSONList() {
		return JSONArrayToList(resultsJSON);
	}

}
