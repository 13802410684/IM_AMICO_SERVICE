package io.jboot.admin.service.entity.status.system;

import io.jboot.admin.base.common.BaseStatus;

public class PayStatus extends BaseStatus {
	public final static String INIT = "0";
	public final static String PAY = "1";
	public final static String PAY_SUCC = "2";
	public final static String PAY_FAIL = "-1";

	public PayStatus() {
		add(INIT, "请求中");
		add(PAY, "待支付");
		add(PAY_SUCC, "支付成功");
		add(PAY_FAIL, "支付失败");
	}

	private static PayStatus me;

	public static PayStatus me() {
		if (me == null) {
			me = new PayStatus();
		}
		return me;
	}
}
