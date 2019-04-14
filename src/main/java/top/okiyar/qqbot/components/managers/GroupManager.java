package top.okiyar.qqbot.components.managers;

import top.okiyar.qqbot.bean.info.GroupInfo;
import top.okiyar.qqbot.bean.info.GroupMemberInfo;
import top.okiyar.qqbot.components.Bot;
import top.okiyar.qqbot.base.Callback;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

/**
 * 群管理器
 */
public class GroupManager {

    private boolean isInited;

    private Bot bot;

    public GroupManager(Bot bot) {

    }

    private void init() {
        Executors.newCachedThreadPool().execute(() -> {
            // 获取群列表
            bot.getQqApi().getGroupList(new Callback<List<GroupInfo>>() {
                @Override
                public void onMessage(List<GroupInfo> info) {
                    // 获取群成员
                }
            });
        });
    }

    /**
     * Refreshing: 刷新中，禁止读取信息
     * Working: 忙绿中禁止刷新缓存
     * Free: 空闲
     */
    private enum Status {
        Refreshing, Working, Free
    }

    ;

    /**
     * 标识管理器状态
     */
    private Status status;

    /**
     * 群缓存
     * Key: 群号
     * Value: 群信息封装类
     */
    private ConcurrentHashMap<Long, GroupInfo> groupInfoMap;

    /**
     * 群成员缓存
     * Key：群成员QQ
     * Value： 群成员信息封装类
     */
    private ConcurrentHashMap<Long, List<GroupMemberInfo>> groupMemberInfoMap;

    /**
     * 判断群是否存在
     *
     * @param groupId 群号
     * @return true 存在 false 不存在 null 缓存刷新中
     */
    public Boolean isInGroupList(long groupId) {
        if (!status.equals(Status.Refreshing)) {
            status = Status.Working;
            boolean ret = groupInfoMap.containsKey(groupId);
            status = Status.Free;
            return ret;
        }
        return null;
    }

    /**
     * 判断成员是否属于某群
     *
     * @param groupId  群号
     * @param memberId 成员QQ号
     */
    public Boolean isInGroup(long groupId, long memberId) {
        if (!status.equals(Status.Refreshing)) {
            status = Status.Working;
            boolean ret = groupInfoMap.containsKey(groupId);
            if (ret) {
                ret = groupMemberInfoMap.get(groupId).contains(memberId);
            }
            status = Status.Free;
            return ret;
        }
        return null;
    }

    /**
     * 获取群信息
     *
     * @param groupId 群号
     */
    public GroupInfo getGroup(long groupId) {
        if (!status.equals(Status.Refreshing)) {
            status = Status.Working;
            GroupInfo groupInfo = groupInfoMap.get(groupId);
            status = Status.Free;
            return groupInfo;
        }
        return null;
    }

    /**
     * 获取群成员信息
     *
     * @param groupId  群号
     * @param memberId 成员QQ号
     */
    public GroupMemberInfo getGroupMemberInfo(long groupId, long memberId) {
        if (!status.equals(Status.Refreshing)) {
            status = Status.Working;
            List<GroupMemberInfo> groupMemberInfos = groupMemberInfoMap.get(groupId);
            for (GroupMemberInfo groupMemberInfo : groupMemberInfos) {
                if (groupMemberInfo.getUserId() == memberId) {
                    status = Status.Free;
                    return groupMemberInfo;
                }
            }
        }
        status = Status.Free;
        return null;
    }

    /**
     * 判断当前可否刷新
     *
     * @return
     */
    public boolean canRefresh() {
        return status.equals(Status.Free);
    }

    public void refreshGroupInfo() {

    }

    public void refreshGroupMemberInfo(long groupId) {

    }

    public void refreshAllGroupMemberInfo() {

    }

    public void refreshAll() {

    }
}
