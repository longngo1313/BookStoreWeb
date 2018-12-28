package com.nguyenvulong2002.bookclient.base;


public interface BasePm <REQUEST extends RequestBase, RESPONSE extends ResponseBase> {
	public RESPONSE execute(REQUEST request);
}

