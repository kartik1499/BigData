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

import static org.nytj4.core.JSONParseUtil.*;

import java.io.Serializable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArticleImpl implements Article, Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String documentType;
	public Headline headline;
	private String articleAbstract;
	private String author;
	public String news_desk;
	public String date;
	public String source;
	public String webUrl;
	public String snippet;
	public String leadParagraph;
	public String[] blog;
	public String body;
	JSONObject json;
	JSONArray jsonArr;
	JSONObject headlineObj;

	public ArticleImpl(JSONObject json) throws JSONException {
		this.json = new JSONObject(json.toString());
		parse();
	}

	public ArticleImpl(){

	}
	private void parse() throws JSONException {
		System.out.println(json);

		articleAbstract = getRawString("abstract", json);
		documentType = getRawString("document_type", json);
		news_desk = getRawString("news_desk", json);
		date = getRawString("pub_date", json).substring(0,10);
		source = getRawString("source", json);
		webUrl = getRawString("web_url", json);
		snippet = getRawString("snippet", json);
		leadParagraph = getRawString("lead_paragraph", json);
		jsonArr = getJSONArray("blog", json);
		int length = jsonArr.length();
		if (length > 0) {
			for (int i = 0; i < length; i++) {
				blog[i] = jsonArr.getString(i);
			}
		}

		headlineObj = getJSONObject("headline", json);
		if(headlineObj!=null){
			headline = new Headline();
			headline.setMain(getRawString("main", headlineObj));
			headline.setPrintHeadline(getRawString("print_headline", headlineObj));
		}
	}


	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public Headline getHeadline() {
		return headline;
	}

	public void setHeadline(Headline headline) {
		this.headline = headline;
	}

	public String getArticleAbstract() {
		return articleAbstract;
	}

	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getNews_desk() {
		return news_desk;
	}

	public void setNews_desk(String news_desk) {
		this.news_desk = news_desk;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public String getSnippet() {
		return snippet;
	}

	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

	public String getLeadParagraph() {
		return leadParagraph;
	}

	public void setLeadParagraph(String leadParagraph) {
		this.leadParagraph = leadParagraph;
	}

	public String[] getBlog() {
		return blog;
	}

	public void setBlog(String[] blog) {
		this.blog = blog;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}

	@Override
	public String toString() {
		return new StringBuffer("document_type:")
		.append(this.documentType)
		.append("\nheadline: { main:")
		.append(this.headline.getMain())
		.append(", print_headline:")
		.append(this.headline.getPrintHeadline())
		.append("}\nnews_desk:")
		.append(this.news_desk)
		.append("\npub_date:")
		.append(this.date)
		.append("\nsource:")
		.append(this.source)
		.append("\nweb_url:")
		.append(this.webUrl)
		.append("\nsnippet:")
		.append(this.snippet)
		.append("\nlead_paragraph:")
		.append(this.leadParagraph)
		.append("\nabstract:")
		.append(this.articleAbstract)
		.append("\nblog:")
		.append(this.blog)		
		.toString();
	}



}
