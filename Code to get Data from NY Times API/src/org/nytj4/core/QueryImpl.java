
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

import java.util.Date;

public class QueryImpl implements Query {


	private Date beginDate;
	private Date endDate;
	private ResponseFormat responseFormat;
	private int offset;

	private int page;
	private String query;

	private String begindate;
	private String enddate;



	public QueryImpl() {

	}




	public String getBegindate() {
		return begindate;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}


	@Override
	public Date getBeginDate() {
		return beginDate;
	}

	@Override
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@Override
	public Date getEndDate() {
		return endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public ResponseFormat getResponseFormat() {
		return responseFormat;
	}

	@Override
	public void setResponseFormat(ResponseFormat format) {
		this.responseFormat = format;
	}

	@Override
	public int getOffset() {
		return offset;
	}

	@Override
	public void setOffset(int offset) {
		this.offset = offset;
	}

}
