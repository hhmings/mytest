package com.hhm.workshirodemo.service.impl;

import com.hhm.workshirodemo.dao.SysMsgMapper;
import com.hhm.workshirodemo.domain.SysMsg;
import com.hhm.workshirodemo.service.SysMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ming
 * @create 2018-07-12 15:08
 */
@Service
public class SysMsgServiceImpl implements SysMsgService {
    @Autowired
    private SysMsgMapper sysMsgMapper;
    @Override
    public int insertMsg(SysMsg sysMsg) {
        return sysMsgMapper.insertMsg(sysMsg);
    }

    @Override
    public int deleteMsg(int id) {
        return sysMsgMapper.deleteMsg(id);
    }

    @Override
    public int updateMsg(SysMsg sysMsg) {
        return sysMsgMapper.updateMsg(sysMsg);
    }

    @Override
    public List<SysMsg> selectMsgList() {
        return sysMsgMapper.selectMsgList();
    }
}
