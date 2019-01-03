package io.jboot.admin.service.entity.status.system;


import io.jboot.admin.base.common.BaseStatus;

/**
 * 系统角色状态类
 * @author Rlax
 *
 */
public class RedirectType extends BaseStatus {

    public final static String PC = "1";
    public final static String PHONE = "2";

    public RedirectType() {
        add(PC, "PC");
        add(PHONE, "移动端");
    }

    private static RedirectType me;

    public static RedirectType me() {
        if (me == null) {
            me = new RedirectType();
        }
        return me;
    }
}
