package io.jboot.admin.service.entity.status.system;


import io.jboot.admin.base.common.BaseStatus;

/**
 * 系统角色状态类
 * @author Rlax
 *
 */
public class AutoCommitStatus extends BaseStatus {

    public final static String UNUSED = "0";
    public final static String USED = "1";

    public AutoCommitStatus() {
        add(UNUSED, "手动");
        add(USED, "自动");
    }

    private static AutoCommitStatus me;

    public static AutoCommitStatus me() {
        if (me == null) {
            me = new AutoCommitStatus();
        }
        return me;
    }
}
