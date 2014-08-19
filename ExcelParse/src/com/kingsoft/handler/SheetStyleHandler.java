package com.kingsoft.handler;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.kingsoft.log.ExcelLogger;
import com.kingsoft.stream.SheetStyle;
import com.kingsoft.usermodel.Alignment;
import com.kingsoft.usermodel.CellBorder;
import com.kingsoft.usermodel.CellFill;
import com.kingsoft.usermodel.CellLineBorder;
import com.kingsoft.usermodel.CellStyle;
import com.kingsoft.usermodel.CellStyleXf;
import com.kingsoft.usermodel.CellXf;
import com.kingsoft.usermodel.ColorStyle;
import com.kingsoft.usermodel.Font;
import com.kingsoft.usermodel.IndexBorderStyle;
import com.kingsoft.usermodel.NumFormat;
import com.kingsoft.util.ColorConvertor;

public class SheetStyleHandler extends DefaultHandler {

	public static final String NUM_FMT = "numFmt";
	public static final String NUM_FMT_CODE = "formatCode";
	public static final String NUM_FMT_ID = "numFmtId";

	public static final String COLOR_THEME = "theme";
	public static final String COLOR_RGB = "rgb";
	public static final String COLOR_INDEXED = "indexed";
	public static final String COLOR_TINT = "tint";
	public static final String COLOR_AUTO = "auto";

	public static final String FONT = "font";
	public static final String FONT_SZ = "sz";
	public static final String FONT_VALUE = "val";
	public static final String FONT_COLOR = "color";
	public static final String FONT_COLOR_THEMT = "theme";
	public static final String FONT_NAME = "name";
	public static final String FONT_FAMILY = "family";
	public static final String FONT_CHARSET = "charset";
	public static final String FONT_SCHEME = "scheme";
	public static final String FONT_VERTALIGN = "vertAlign";

	public static final String FILL = "fill";
	public static final String FILL_PATTERN = "patternFill";
	public static final String FILL_PATTERN_TYPE = "patternType";
	public static final String FILL_FG_COLOR = "fgColor";
	public static final String FILL_BG_COLOR = "bgColor";

	public static final String BORDER = "border";
	public static final String BORDER_DIAGONAL_DOWN = "diagnoalDown";
	public static final String BORDER_DIAGONAL_UP = "diagnoalUp";
	public static final String BORDER_STYLE = "style";
	public static final String BORDER_COLOR = "color";
	public static final String BORDER_COLOR_THEME = "theme";
	public static final String BORDER_COLOR_AUTO = "auto";
	public static final String BORDER_LEFT = "left";
	public static final String BORDER_RIGHT = "right";
	public static final String BORDER_TOP = "top";
	public static final String BORDER_BOTTOM = "bottom";
	public static final String BORDER_DIAGONAL = "diagonal";
	
	
	public static final String ALIGNMENT = "alignment";
	public static final String ALIGNMENT_READORDER="readingOrder";
	public static final String ALIGNMENT_INDENT="indent";
	public static final String ALIGNMENT_VERTICAL = "vertical";
	public static final String ALIGNMENT_HORIZONTAL = "Horizontal";

	public static final String CELLSTYLE_XF = "cellStyleXfs";
	public static final String CELLSTYLE_XF_COUNT = "count";
	public static final String CELLSTYLE_XF_XF = "xf";
	public static final String CELLSTYLE_XF_NUMFMT_ID = "numFmtId";
	public static final String CELLSTYLE_XF_FILL_ID = "fillId";
	public static final String CELLSTYLE_XF_FONT_ID = "fontId";
	public static final String CELLSTYLE_XF_BORDER_ID = "borderId";
//	public static final String CELLSTYLE_XF_ALIGNMENT = "alignment";
//	public static final String CELLSTYLE_XF_ALIGNMENT_READORDER="readingOrder";
//	public static final String CELLSTYLE_XF_ALIGNMENT_INDENT="indent";
//	public static final String CELLSTYLE_XF_VERTICAL = "vertical";
//	public static final String CELLSTYLE_XF_HORIZONTAL = "Horizontal";

	public static final String CELL_XF = "cellXfs";
	public static final String CELL_XF_COUNT = "count";
	public static final String CELL_XF_XF = "xf";
	public static final String CELL_XF_ID = "xfId";
	public static final String CELL_XF_NUMFMT_ID = "numFmtId";
	public static final String CELL_XF_FILL_ID = "fillId";
	public static final String CELL_XF_FONT_ID = "fontId";
	public static final String CELL_XF_BORDER_ID = "borderId";
//	public static final String CELL_XF_ALIGNMENT = "alignment";
//	public static final String CELL_XF_VERTICAL = "vertical";
//	public static final String CELL_XF_HORIZONTAL = "Horizontal";
	public static final String CELL_XF_NUMFMT_APPLY = "applyNumberFormat";
	public static final String CELL_XF_FILL_APPLY = "applyFill";
	public static final String CELL_XF_BORDER_APPLY = "applyBorder";
	public static final String CELL_XF_ALIGNMENT_APPLY = "applyAlignment";

	public static final String CELL_STYLE = "cellStyle";
	public static final String CELL_STYLE_XF_ID = "xfId";
	public static final String CELL_STYLE_BUILTIN_ID = "builtinId";
	public static final String CELL_STYLE_NAME = "name";
	private ExcelLogger logger = (ExcelLogger) ExcelLogger
			.getLogger("com.kingsoft");
	private SheetStyle sheetStyle;
	private String preTag = "";
	private String preColorTag = "";
	private String preXFTag = "";
	private Font font = null;
	private CellFill cellFill = null;
	private CellBorder border = null;
	private CellLineBorder leftCellLineBorder;
	private CellLineBorder rightCellLineBorder;
	private CellLineBorder topCellLineBorder;
	private CellLineBorder bottomCellLineBorder;
	private CellLineBorder diagonalCellLineBorder;
	private CellStyleXf cellStyleXf;
	private CellXf cellXF;
	private CellStyle cellStyle;
	
	

	public SheetStyleHandler(SheetStyle sheetStyle) {
		this.sheetStyle = sheetStyle;
	}

	@Override
	public void startDocument() throws SAXException {
//		System.out.println("*******��ʼ�����ĵ�*******");
	}

	@Override
	public void endDocument() throws SAXException {
//		System.out.println("*******�����ĵ�����*******");
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) {
//		System.out.println("\nǰ׺ӳ��: " + prefix + " ��ʼ!" + "  ���URI��:" + uri);
	}

	@Override
	public void endPrefixMapping(String prefix) {
//		System.out.println("\nǰ׺ӳ��: " + prefix + " ����!");
	}

	@SuppressWarnings("null")
	@Override
	public void startElement(String namespaceURI, String localName,
			String fullName, Attributes attributes) throws SAXException {
//		System.out.println("\nԪ��: " + "[" + fullName + "]" + " ��ʼ����!");

		if (NUM_FMT.equals(fullName)) {
			NumFormat format = new NumFormat();
			format.setNumFormatCode(attributes.getValue(NUM_FMT_CODE));
			format.setNumFormatId(Integer.parseInt(attributes
					.getValue(NUM_FMT_ID)));
			sheetStyle.addNumFomat(format);
		} else if (FONT.equals(fullName)) {
			preTag = FONT;
			font = new Font();
		} else if (FONT_SZ.equals(fullName)) {
			if (attributes.getValue(FONT_VALUE) != null) {
				font.setSize(Byte.parseByte(attributes.getValue(FONT_VALUE)));
			}
		} else if (FONT.equals(preTag) && FONT_COLOR.equals(fullName)) {
			ColorStyle colorStyle = getColorStyle(attributes);
			font.setColorStyle(colorStyle);

		} else if (FONT_NAME.equals(fullName)) {
			font.setName(attributes.getValue(FONT_VALUE));
		} else if (FONT_FAMILY.equals(fullName)) {
			if (attributes.getValue(FONT_VALUE) != null) {
				font.setFamily(Byte.parseByte(attributes.getValue(FONT_VALUE)));
			}
		} else if (FONT_CHARSET.equals(fullName)) {
			if (attributes.getValue(FONT_VALUE) != null) {
				font.setCharset(Short.parseShort(attributes
						.getValue(FONT_VALUE)));
			}
		} else if (FONT_SCHEME.equals(fullName)) {
			font.setScheme(attributes.getValue(FONT_VALUE));
		} else if (FONT_VERTALIGN.equals(fullName)) {
			font.setVertAlign(attributes.getValue(FONT_VALUE));
		} else if (FILL.equals(fullName)) {
			cellFill = new CellFill();
		} else if (FILL_PATTERN.equals(fullName)) {
			cellFill.setPatternType(attributes.getValue(FILL_PATTERN_TYPE));
		} else if (FILL_FG_COLOR.equals(fullName)) {
			ColorStyle fgColorStyle = getColorStyle(attributes);
			cellFill.setFgColorStyle(fgColorStyle);
		} else if (FILL_BG_COLOR.equals(fullName)) {
			ColorStyle bgColorStyle = getColorStyle(attributes);
			cellFill.setFgColorStyle(bgColorStyle);
		} else if (BORDER.equals(fullName)) {
			preTag = BORDER;
			border = new CellBorder();
			border.setDiagonalDown(attributes.getValue(BORDER_DIAGONAL_DOWN) == "1" ? true
					: false);
			border.setDiagonalUp(attributes.getValue(BORDER_DIAGONAL_DOWN) == "1" ? true
					: false);
		} else if (BORDER_LEFT.equals(fullName)) {
			preColorTag = BORDER_LEFT;
			leftCellLineBorder = new CellLineBorder();
			if (attributes.getValue(BORDER_STYLE) != null) {
				leftCellLineBorder.setStyle(CellLineBorder
						.getBorderStyle(attributes.getValue(BORDER_STYLE)));
			}
		} else if (BORDER_RIGHT.equals(fullName)) {
			preColorTag = BORDER_RIGHT;
			rightCellLineBorder = new CellLineBorder();
			if (attributes.getValue(BORDER_STYLE) != null) {
				rightCellLineBorder.setStyle(CellLineBorder
						.getBorderStyle(attributes.getValue(BORDER_STYLE)));
			}
		} else if (BORDER_TOP.equals(fullName)) {
			preColorTag = BORDER_TOP;
			topCellLineBorder = new CellLineBorder();
			if (attributes.getValue(BORDER_STYLE) != null) {
				topCellLineBorder.setStyle(CellLineBorder
						.getBorderStyle(attributes.getValue(BORDER_STYLE)));
			}
		} else if (BORDER_BOTTOM.equals(fullName)) {
			preColorTag = BORDER_BOTTOM;
			bottomCellLineBorder = new CellLineBorder();
			if (attributes.getValue(BORDER_STYLE) != null) {

				bottomCellLineBorder.setStyle(CellLineBorder
						.getBorderStyle(attributes.getValue(BORDER_STYLE)));
			}
		} else if (BORDER_DIAGONAL.equals(fullName)) {
			preColorTag = BORDER_DIAGONAL;
			diagonalCellLineBorder = new CellLineBorder();
			if (attributes.getValue(BORDER_STYLE) != null) {
				diagonalCellLineBorder.setStyle(CellLineBorder
						.getBorderStyle(attributes.getValue(BORDER_STYLE)));
			}
		} else if (BORDER.equals(preTag) && BORDER_COLOR.equals(fullName)) {

			ColorStyle colorStyle = getColorStyle(attributes);
			if (BORDER_LEFT.equals(preColorTag)) {
				leftCellLineBorder.setColorStyle(colorStyle);
			} else if (BORDER_RIGHT.equals(preColorTag)) {
				rightCellLineBorder.setColorStyle(colorStyle);
			} else if (BORDER_TOP.equals(preColorTag)) {
				topCellLineBorder.setColorStyle(colorStyle);
			} else if (BORDER_BOTTOM.equals(preColorTag)) {
				bottomCellLineBorder.setColorStyle(colorStyle);
			} else if (BORDER_DIAGONAL.equals(preColorTag)) {
				diagonalCellLineBorder.setColorStyle(colorStyle);
			}
		} else if (CELLSTYLE_XF.equals(fullName)) {
			preXFTag = CELLSTYLE_XF;
		} else if (CELLSTYLE_XF.equals(preXFTag)
				&& CELLSTYLE_XF_XF.equals(fullName)) {
			cellStyleXf = new CellStyleXf();
			if (attributes.getValue(CELLSTYLE_XF_NUMFMT_ID) != null) {
				cellStyleXf.setNumFmtId(Integer.parseInt(attributes
						.getValue(CELLSTYLE_XF_NUMFMT_ID)));
			}
			if (attributes.getValue(CELLSTYLE_XF_BORDER_ID) != null) {
				cellStyleXf.setBorderId(Integer.parseInt(attributes
						.getValue(CELLSTYLE_XF_BORDER_ID)));
			}
			if (attributes.getValue(CELLSTYLE_XF_FONT_ID) != null) {
				cellStyleXf.setFontId(Integer.parseInt(attributes
						.getValue(CELLSTYLE_XF_FONT_ID)));
			}
			if (attributes.getValue(CELLSTYLE_XF_FILL_ID) != null) {
				cellStyleXf.setFillId(Integer.parseInt(attributes
						.getValue(CELLSTYLE_XF_FILL_ID)));
			}
		} else if (CELLSTYLE_XF.equals(preXFTag)&& ALIGNMENT.equals(fullName)) {
			Alignment alignment=getAlignment(attributes);
			cellStyleXf.setAlignment(alignment);
		} else if (CELL_XF.equals(fullName)) {
			preXFTag = CELL_XF;

		} else if (CELL_XF.equals(preXFTag) && CELL_XF_XF.equals(fullName)) {
			cellXF = new CellXf();
			if (attributes.getValue(CELL_XF_NUMFMT_ID) != null) {
				cellXF.setNumFmtId(Integer.parseInt(attributes
						.getValue(CELL_XF_NUMFMT_ID)));
			}
			if (attributes.getValue(CELL_XF_BORDER_ID) != null) {
				cellXF.setBorderId(Integer.parseInt(attributes
						.getValue(CELL_XF_BORDER_ID)));
			}
			if (attributes.getValue(CELL_XF_FONT_ID) != null) {
				cellXF.setFontId(Integer.parseInt(attributes
						.getValue(CELL_XF_FONT_ID)));
			}
			if (attributes.getValue(CELL_XF_FILL_ID) != null) {
				cellXF.setFillId(Integer.parseInt(attributes
						.getValue(CELL_XF_FILL_ID)));
			}
			if (attributes.getValue(CELL_XF_ID) != null) {
				cellXF.setXfId(Integer.parseInt(attributes.getValue(CELL_XF_ID)));
			}

			if (attributes.getValue(CELL_XF_NUMFMT_APPLY) != null) {

				if ("1".equals(attributes.getValue(CELL_XF_NUMFMT_APPLY))) {
					cellXF.setApplyNumberFormat(true);
				} else {
					cellXF.setApplyNumberFormat(false);
				}

			}
			if (attributes.getValue(CELL_XF_BORDER_APPLY) != null) {

				if ("1".equals(attributes.getValue(CELL_XF_BORDER_APPLY))) {
					cellXF.setApplyBorder(true);
				} else {
					cellXF.setApplyBorder(false);
				}
			}

			if (attributes.getValue(CELL_XF_FILL_APPLY) != null) {

				if ("1".equals(attributes.getValue(CELL_XF_FILL_APPLY))) {
					cellXF.setApplyFill(true);
				} else {
					cellXF.setApplyFill(false);
				}

			}
			if (attributes.getValue(CELL_XF_ALIGNMENT_APPLY) != null) {

				if ("1".equals(attributes.getValue(CELL_XF_ALIGNMENT_APPLY))) {
					cellXF.setApplyAlignment(true);
				} else {
					cellXF.setApplyAlignment(false);
				}
			}

		} else if (CELL_XF.equals(preXFTag)&& ALIGNMENT.equals(fullName)) {
			Alignment alignment=getAlignment(attributes);
			cellXF.setAlignment(alignment);
		} else if (CELL_STYLE.equals(fullName)) {
			cellStyle = new CellStyle();
			if (attributes.getValue(CELL_STYLE_XF_ID) != null) {
				cellStyle.setXfId(Integer.parseInt(attributes
						.getValue(CELL_STYLE_XF_ID)));
			}
			if (attributes.getValue(CELL_STYLE_BUILTIN_ID) != null) {
				cellStyle.setBuiltinId(Integer.parseInt(attributes
						.getValue(CELL_STYLE_BUILTIN_ID)));
			}
			cellStyle.setName(attributes.getValue(CELL_STYLE_NAME));
		}

	}

	@Override
	public void endElement(String namespaceURI, String localName,
			String fullName) throws SAXException {
		if (FONT.equals(fullName)) {
			sheetStyle.addFont(font);
			font = null;
			preTag = null;
		} else if (FILL.equals(fullName)) {
			sheetStyle.addFill(cellFill);
			cellFill = null;
		} else if (BORDER_LEFT.equals(fullName)) {
			border.setLeftCellLineBorder(leftCellLineBorder);
			preTag = null;
			leftCellLineBorder = null;
		} else if (BORDER_RIGHT.equals(fullName)) {
			border.setRightCellLineBorder(rightCellLineBorder);
			preTag = null;
			rightCellLineBorder = null;
		} else if (BORDER_TOP.equals(fullName)) {
			border.setTopCellLineBorder(topCellLineBorder);
			preTag = null;
			topCellLineBorder = null;
		} else if (BORDER_BOTTOM.equals(fullName)) {
			border.setBottomCellLineBorder(bottomCellLineBorder);
			preTag = null;
			bottomCellLineBorder = null;
		} else if (BORDER_DIAGONAL.equals(fullName)) {
			border.setDiagonalCellLineBorder(diagonalCellLineBorder);
			preTag = null;
			diagonalCellLineBorder = null;
		} else if (BORDER.equals(fullName)) {
			sheetStyle.addBorder(border);
			border = null;
		} else if (CELLSTYLE_XF.equals(preXFTag)
				&& CELLSTYLE_XF_XF.equals(fullName)) {
			sheetStyle.addCellStyleXf(cellStyleXf);
			cellStyleXf = null;
		} else if (CELL_XF.equals(preXFTag) && CELL_XF_XF.equals(fullName)) {
			sheetStyle.addCellXf(cellXF);
			cellXF = null;
		} else if (CELL_STYLE.equals(fullName)) {
			sheetStyle.addCellStyle(cellStyle);
			cellStyle = null;
		}
	}

	@Override
	public void characters(char[] chars, int start, int length)
			throws SAXException {

	}

	@Override
	public void warning(SAXParseException exception) {

		System.out.println("*******WARNING******");
		System.out.println("\t��:\t" + exception.getLineNumber());
		System.out.println("\t��:\t" + exception.getColumnNumber());
		System.out.println("\t������Ϣ:\t" + exception.getMessage());
		System.out.println("********************");
		logger.warn(StringValueHandler.class.getName(), exception.getLineNumber()
				+ exception.getMessage());
	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		System.out.println("******* ERROR ******");
		System.out.println("\t��:\t" + exception.getLineNumber());
		System.out.println("\t��:\t" + exception.getColumnNumber());
		System.out.println("\t������Ϣ:\t" + exception.getMessage());
		System.out.println("********************");
		logger.error(StringValueHandler.class.getName(), exception.getLineNumber()
				+ exception.getMessage());
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		System.out.println("******** FATAL ERROR ********");
		System.out.println("\t��:\t" + exception.getLineNumber());
		System.out.println("\t��:\t" + exception.getColumnNumber());
		System.out.println("\t������Ϣ:\t" + exception.getMessage());
		System.out.println("*****************************");
		logger.error(StringValueHandler.class.getName(), exception.getLineNumber()
				+ exception.getMessage());
	}

	private ColorStyle getColorStyle(Attributes attributes) {
		ColorStyle colorStyle = new ColorStyle();
		if (attributes.getValue(COLOR_THEME) != null) {
//			colorStyle.setTheme(Short.parseShort(attributes
//					.getValue(COLOR_THEME)));
			colorStyle.setType(ColorStyle.ColorStyleType.theme.ordinal());
			colorStyle.setValue(Integer.parseInt(attributes.getValue(COLOR_THEME)));
		}
		if (attributes.getValue(COLOR_AUTO) != null) {
//			colorStyle.setTheme(Short.parseShort(attributes
//					.getValue(COLOR_AUTO)));
			colorStyle.setType(ColorStyle.ColorStyleType.theme.ordinal());
			colorStyle.setValue(Integer.parseInt(attributes.getValue(COLOR_AUTO)));
		}
		if (attributes.getValue(COLOR_RGB) != null) {
//			colorStyle.setRgb(ColorConvertor.toInt(attributes
//					.getValue(COLOR_RGB)));
			colorStyle.setType(ColorStyle.ColorStyleType.rgb.ordinal());
			colorStyle.setValue(ColorConvertor.toInt(attributes.getValue(COLOR_RGB)));
		}
		if (attributes.getValue(COLOR_INDEXED) != null) {
//			colorStyle.setIndexed(Short.parseShort(attributes
//					.getValue(COLOR_INDEXED)));
			colorStyle.setType(ColorStyle.ColorStyleType.indexed.ordinal());
			colorStyle.setValue(Integer.parseInt(attributes.getValue(COLOR_INDEXED)));
		}
		if (attributes.getValue(COLOR_TINT) != null) {
			colorStyle.setTint(attributes.getValue(COLOR_TINT));
		}
		return colorStyle;
	}

	
	private Alignment getAlignment(Attributes attributes){
		Alignment alignment=new Alignment();
		if(attributes.getValue(ALIGNMENT_VERTICAL)!=null){
			alignment.setVertical(getAligmentType(attributes.getValue(ALIGNMENT_VERTICAL)));
		}
		if(attributes.getValue(ALIGNMENT_HORIZONTAL)!=null){
			alignment.setHorizontal(getAligmentType(attributes.getValue(ALIGNMENT_HORIZONTAL)));
		}
		if(attributes.getValue(ALIGNMENT_READORDER)!=null){
			alignment.setReadingOrder(Byte.parseByte(attributes.getValue(ALIGNMENT_READORDER)));
		}
		if(attributes.getValue(ALIGNMENT_INDENT)!=null){
			alignment.setReadingOrder(Byte.parseByte(attributes.getValue(ALIGNMENT_INDENT)));
		}
		return alignment;
	}
	
	
	
	private int getAligmentType(String value) {
		if(value.equals(Alignment.Type.center.name())){
			return Alignment.Type.center.ordinal();
		}else if(value.equals(Alignment.Type.justify.name())){
			return Alignment.Type.justify.ordinal();
		}else if(value.equals(Alignment.Type.left.name())){
			return Alignment.Type.left.ordinal();
		} else if(value.equals(Alignment.Type.right.name())){
			return Alignment.Type.right.ordinal();
		}else {
			return -1;
		}
	}
	
}