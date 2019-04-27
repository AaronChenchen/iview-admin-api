package cn.saatana.core.log.service;

import org.springframework.stereotype.Service;

import cn.saatana.core.common.CommonService;
import cn.saatana.core.log.entity.OparetionLog;
import cn.saatana.core.log.mapper.OparetionLogMapper;

@Service
public class OparetionLogService extends CommonService<OparetionLogMapper, OparetionLog> {
}
