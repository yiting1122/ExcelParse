package com.kingsoft.usermodel;

public class CellBorder {
	private boolean diagonalDown;
	private boolean diagonalUp;
	private CellLineBorder leftCellLineBorder;
	private CellLineBorder rightCellLineBorder;
	private CellLineBorder topCellLineBorder;
	private CellLineBorder bottomCellLineBorder;
	private CellLineBorder diagonalCellLineBorder;

	public CellBorder() {
	}

	public boolean getDiagonalDown() {
		return diagonalDown;
	}

	public void setDiagonalDown(boolean diagonalDown) {
		this.diagonalDown = diagonalDown;
	}

	public boolean getDiagonalUp() {
		return diagonalUp;
	}

	public void setDiagonalUp(boolean diagonalUp) {
		this.diagonalUp = diagonalUp;
	}

	public boolean hasLeft() {
		return leftCellLineBorder == null ? false : true;
	}

	public CellLineBorder getLeftCellLineBorder() {
		return leftCellLineBorder;
	}

	public boolean hasRight() {
		return rightCellLineBorder == null ? false : true;
	}

	public boolean hasTop() {
		return topCellLineBorder == null ? false : true;
	}

	public boolean hasBottm() {
		return bottomCellLineBorder == null ? false : true;
	}

	public boolean hasDiagonal() {
		return diagonalCellLineBorder == null ? false : true;
	}

	public CellLineBorder getRightCellLineBorder() {
		return rightCellLineBorder;
	}

	public void setRightCellLineBorder(CellLineBorder rightCellLineBorder) {
		this.rightCellLineBorder = rightCellLineBorder;
	}

	public CellLineBorder getTopCellLineBorder() {
		return topCellLineBorder;
	}

	public void setTopCellLineBorder(CellLineBorder topCellLineBorder) {
		this.topCellLineBorder = topCellLineBorder;
	}

	public CellLineBorder getBottomCellLineBorder() {
		return bottomCellLineBorder;
	}

	public void setBottomCellLineBorder(CellLineBorder bottomCellLineBorder) {
		this.bottomCellLineBorder = bottomCellLineBorder;
	}

	public CellLineBorder getDiagonalCellLineBorder() {
		return diagonalCellLineBorder;
	}

	public void setDiagonalCellLineBorder(CellLineBorder diagonalCellLineBorder) {
		this.diagonalCellLineBorder = diagonalCellLineBorder;
	}

	public void setLeftCellLineBorder(CellLineBorder leftCellLineBorder) {
		this.leftCellLineBorder = leftCellLineBorder;
	}

	@Override
	public String toString() {
		return "CellBorder [diagonalDown=" + diagonalDown + ", diagonalUp="
				+ diagonalUp + ", leftCellLineBorder=" + leftCellLineBorder.toString()
				+ ", rightCellLineBorder=" + rightCellLineBorder.toString()
				+ ", topCellLineBorder=" + topCellLineBorder.toString()
				+ ", bottomCellLineBorder=" + bottomCellLineBorder.toString()
				+ ", diagonalCellLineBorder=" + diagonalCellLineBorder.toString() + "]";
	}
	
	
	
	

}
