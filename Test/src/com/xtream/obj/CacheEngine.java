package com.xtream.obj;

import java.util.List;

public  class CacheEngine {
	public String engineName;
	public String implClass;
	public String engineDesc;
	//public List<com.xtream.obj.Param> params;

	String getEngineName() {
		return engineName;
	}


	public void setEngineName(String value) {
		this.engineName = value;
	}

	/**
	 * Gets the value of the implClass property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getImplClass() {
		return implClass;
	}

	/**
	 * Sets the value of the implClass property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setImplClass(String value) {
		this.implClass = value;
	}

	/**
	 * Gets the value of the engineDesc property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEngineDesc() {
		return engineDesc;
	}

	/**
	 * Sets the value of the engineDesc property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEngineDesc(String value) {
		this.engineDesc = value;
	}


}

