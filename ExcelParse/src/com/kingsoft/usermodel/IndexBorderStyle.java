package com.kingsoft.usermodel;

public enum IndexBorderStyle {
	hair(1), 
	slantDashDot(2),
	dotted(3),
	mediumDashDot(4), 
	dashDotDot(5), 
	doubleL(6),
	medium(7), 
	mediumDashed(8),
	dashDot(9), 
	thin(10), 
	dashed(11), 
	thick(12),
	mediumDashDotDot(13);


	public final short index;

	IndexBorderStyle(int idx) {
		index = (short) idx;
	}

	public short getIndex() {
		return index;
	}
}
