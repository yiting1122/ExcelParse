package com.kingsoft.usermodel;

public class CellFill {
	private String patternType; // 暂时使用string 如果知道填充码表后可以改为byte
	private ColorStyle bgColorStyle;
	private ColorStyle fgColorStyle;

	public String getPatternType() {
		return patternType;
	}

	public void setPatternType(String patternType) {
		this.patternType = patternType;
	}

	public ColorStyle getBgColorStyle() {
		return bgColorStyle;
	}

	public void setBgColorStyle(ColorStyle bgColorStyle) {
		this.bgColorStyle = bgColorStyle;
	}

	public ColorStyle getFgColorStyle() {
		return fgColorStyle;
	}

	public void setFgColorStyle(ColorStyle fgColorStyle) {
		this.fgColorStyle = fgColorStyle;
	}

	@Override
	public String toString() {
		String fgcolorString = fgColorStyle == null ? "null" : fgColorStyle
				.toString();
		String bgcolorString =bgColorStyle == null ? "null" : bgColorStyle
				.toString();
		return "CellFill [patternType=" + patternType + ", bgColorStyle="
				+ fgcolorString + ", fgColorStyle=" + bgcolorString + "]";
	}

}
