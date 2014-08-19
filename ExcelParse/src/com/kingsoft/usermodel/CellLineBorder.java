package com.kingsoft.usermodel;

public class CellLineBorder {
	private short style;
	private ColorStyle colorStyle;

	public short getStyle() {
		return style;
	}

	public void setStyle(short style) {
		this.style = style;
	}

	
	public ColorStyle getColorStyle() {
		return colorStyle;
	}

	public void setColorStyle(ColorStyle colorStyle) {
		this.colorStyle = colorStyle;
	}

	public static short getBorderStyle(String styleName){
		if(styleName.equals(IndexBorderStyle.medium.name())){
			return IndexBorderStyle.medium.getIndex();
		}else if(styleName.equals(IndexBorderStyle.thin.name())){
			return IndexBorderStyle.thin.getIndex();
		}else if(styleName.equals(IndexBorderStyle.hair.name())){
			return IndexBorderStyle.hair.getIndex();
		}
		else if(styleName.equals(IndexBorderStyle.slantDashDot.name())){
			return IndexBorderStyle.slantDashDot.getIndex();
		}
		else if(styleName.equals(IndexBorderStyle.dashDot.name())){
			return IndexBorderStyle.dashDot.getIndex();
		}
		else if(styleName.equals(IndexBorderStyle.dashDotDot.name())){
			return IndexBorderStyle.dashDotDot.getIndex();
		}
		else if(styleName.equals(IndexBorderStyle.dashed.name())){
			return IndexBorderStyle.dashed.getIndex();
		}
		else if(styleName.equals(IndexBorderStyle.dotted.name())){
			return IndexBorderStyle.dotted.getIndex();
		}
		else if(styleName.equals(IndexBorderStyle.doubleL.name())){
			return IndexBorderStyle.doubleL.getIndex();
		}
		else if(styleName.equals(IndexBorderStyle.mediumDashDot.name())){
			return IndexBorderStyle.mediumDashDot.getIndex();
		}
		else if(styleName.equals(IndexBorderStyle.mediumDashDotDot.name())){
			return IndexBorderStyle.mediumDashDotDot.getIndex();
		}
		else if(styleName.equals(IndexBorderStyle.mediumDashed.name())){
			return IndexBorderStyle.mediumDashed.getIndex();
		}
		else if(styleName.equals(IndexBorderStyle.thick.name())){
			return IndexBorderStyle.thick.getIndex();
		}
		
		return -1;
	}

	@Override
	public String toString() {
		String colorString = colorStyle == null ? "null" : colorStyle
				.toString();
		return "CellLineBorder [style=" + style + ", colorStyle=" + colorString
				+ "]";
	}
	
	

}
