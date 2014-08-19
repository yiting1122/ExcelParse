package com.kingsoft.usermodel;

public class Font {
	/**
	 * defalut font_name and font_size
	 */
	public static final String DEFAULT_FONT_NAME = "Calibri";
	public static final byte DEFAULT_FONT_SIZE = 11;
	public static final short DEFAULT_FONT_COLOR = IndexedColors.BLACK
			.getIndex();

	private byte size;
	private String name;
	private ColorStyle colorStyle;
	private byte family;
	private short charset;
	private String scheme;
	private String vertAlign;

	public byte getSize() {
		return size;
	}

	public void setSize(byte size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getFamily() {
		return family;
	}

	public void setFamily(byte family) {
		this.family = family;
	}

	public short getCharset() {
		return charset;
	}

	public void setCharset(short charset) {
		this.charset = charset;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getVertAlign() {
		return vertAlign;
	}

	public void setVertAlign(String vertAlign) {
		this.vertAlign = vertAlign;
	}

	public ColorStyle getColorStyle() {
		return colorStyle;
	}

	public void setColorStyle(ColorStyle colorStyle) {
		this.colorStyle = colorStyle;
	}

	@Override
	public String toString() {
		String colorString = colorStyle == null ? "null" : colorStyle
				.toString();
		return "Font [size=" + size + ", name=" + name + ", colorStyle="
				+ colorString + ", family=" + family + ", charset=" + charset
				+ ", scheme=" + scheme + ", vertAlign=" + vertAlign + "]";
	}

}
