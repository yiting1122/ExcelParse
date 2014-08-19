package com.kingsoft.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.border.Border;

import com.kingsoft.usermodel.CellBorder;
import com.kingsoft.usermodel.CellFill;
import com.kingsoft.usermodel.CellStyle;
import com.kingsoft.usermodel.CellStyleXf;
import com.kingsoft.usermodel.CellXf;
import com.kingsoft.usermodel.Font;
import com.kingsoft.usermodel.NumFormat;

public class SheetStyle {
	private final List<NumFormat> numberFormats = new ArrayList<NumFormat>();
	private final List<Font> fonts = new ArrayList<Font>();
	private final List<CellFill> cellFills = new ArrayList<CellFill>();
	private final List<CellBorder> cellBorders = new ArrayList<CellBorder>();
	private final List<CellStyle> cellStyles = new ArrayList<CellStyle>();
	private final List<CellStyleXf> cellStyleXfs = new ArrayList<CellStyleXf>();
	private final List<CellXf> cellXfs = new ArrayList<CellXf>();
	

	public void addNumFomat(NumFormat numFormat) {
		if (numFormat != null) {
			numberFormats.add(numFormat);
		}
	}

	public NumFormat getNumFormat(int id) {
		if (id < 0 || id >=numberFormats.size()) {
			throw new IndexOutOfBoundsException(
					"numformat id is outofBoundsException at " + id);
		}
		return numberFormats.get(id);
	}

	public void deleteNumFomat(NumFormat numFormat) {
		if (numFormat != null) {
			numberFormats.remove(numFormat);
		}
	}

	public void addFont(Font font) {
		if (font != null) {
			fonts.add(font);
		}
	}

	public Font getFont(int id) {
		if (id < 0 || id >= fonts.size()) {
			throw new IndexOutOfBoundsException(
					"numformat id is outofBoundsException at " + id);
		}
		return fonts.get(id);
	}

	public void addBorder(CellBorder cellBorder) {
		if (cellBorder != null) {
			cellBorders.add(cellBorder);
		}
	}

	public CellBorder getBorder(int id) {
		if (id < 0 || id >=cellBorders.size()) {
			throw new IndexOutOfBoundsException(
					"numformat id is outofBoundsException at " + id);
		}
		return cellBorders.get(id);
	}

	public void addFill(CellFill cellFill) {
		if (cellFill != null) {
			cellFills.add(cellFill);
		}
	}

	public CellFill getCellFill(int id) {
		if (id < 0 || id >= cellFills.size()) {
			throw new IndexOutOfBoundsException(
					"numformat id is outofBoundsException at " + id);
		}
		return cellFills.get(id);
	}

	public void addCellStyle(CellStyle cellStyle) {
		if (cellStyle != null) {
			cellStyles.add(cellStyle);
		}
	}

	public CellStyle getCellStyle(int id) {
		if (id < 0 || id >= cellStyles.size()) {
			throw new IndexOutOfBoundsException(
					"numformat id is outofBoundsException at " + id);
		}
		return cellStyles.get(id);
	}

	public void addCellStyleXf(CellStyleXf cellStyleXf) {
		if (cellStyleXf != null) {
			cellStyleXfs.add(cellStyleXf);
		}
	}

	public CellStyleXf getCellStyleXf(int id) {
		if (id < 0 || id >= cellStyleXfs.size()) {
			throw new IndexOutOfBoundsException(
					"numformat id is outofBoundsException at " + id);
		}
		return cellStyleXfs.get(id);
	}

	public void addCellXf(CellXf cellXF) {
		if (cellXF != null) {
			cellXfs.add(cellXF);
		}
	}

	public CellXf getCellXf(int id) {
		if (id < 0 || id >= cellXfs.size()) {
			throw new IndexOutOfBoundsException(
					"numformat id is outofBoundsException at " + id);
		}
		return cellXfs.get(id);
	}

	@Override
	public String toString() {
		return "SheetStyle [numberFormats=" + numberFormats.size() + ", fonts="
				+ fonts.size() + ", cellFills=" + cellFills.size()
				+ ", cellBorders=" + cellBorders.size() + ", cellStyles="
				+ cellStyles.size() + ", cellStyleXfs=" + cellStyleXfs.size()
				+ ", cellXFs=" + cellXfs.size() + "]";
	}
	
	

	public void printNumFormats() {
		for (NumFormat format : numberFormats) {
			System.out.println(format.toString());
		}
	}

	public void printFonts() {
		for (Font f : fonts) {
			System.out.println(f.toString());
		}
	}

	public void printCellFills() {
		for (CellFill cFill : cellFills) {
			System.out.println(cFill.toString());
		}
	}

	public void printCellStyles() {
		for (CellStyle cStyle : cellStyles) {
			System.out.println(cStyle.toString());
		}
	}

	public void printCellStyleXfs() {
		for (CellStyleXf cStyleXf : cellStyleXfs) {
			System.out.println(cStyleXf.toString());
		}
	}

	public void printCellXFs() {
		for (CellXf cXf : cellXfs) {
			System.out.println(cXf.toString());
		}
	}

	public void printCellCellBorders() {
		for (CellBorder cBorder : cellBorders) {
			System.out.println(cBorder.toString());
		}
	}
}
