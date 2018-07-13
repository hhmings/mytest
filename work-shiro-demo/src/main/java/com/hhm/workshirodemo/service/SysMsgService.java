package com.hhm.workshirodemo.service;

import com.hhm.workshirodemo.domain.SysMsg;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Ming
 * @create 2018-07-12 15:08
 */
public interface SysMsgService {
    int insertMsg(SysMsg sysMsg);

    int deleteMsg(int id);

    int updateMsg(SysMsg sysMsg);

    List<SysMsg> selectMsgList();
}
