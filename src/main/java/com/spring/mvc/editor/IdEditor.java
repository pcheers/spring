package com.spring.mvc.editor;

import java.beans.PropertyEditorSupport;

public class IdEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String value) {
		Integer intValue = new Integer("0");
		String strValue = value.toString();
		if(strValue.contains("a")) {
			super.setValue(intValue);
		}
		
	}

}
