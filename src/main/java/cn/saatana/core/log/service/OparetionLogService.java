package cn.saatana.core.log.service;

import org.springframework.stereotype.Service;

import cn.saatana.core.common.CurdService;
import cn.saatana.core.log.dao.OparetionLogDao;
import cn.saatana.core.log.entity.OparetionLog;

@Service
public class OparetionLogService extends CurdService<OparetionLogDao, OparetionLog> {
}
