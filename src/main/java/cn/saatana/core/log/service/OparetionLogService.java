package cn.saatana.core.log.service;

import org.springframework.stereotype.Service;

import cn.saatana.core.common.CurdService;
import cn.saatana.core.log.entity.OparetionLog;
import cn.saatana.core.log.repository.OparetionLogRepository;

@Service
public class OparetionLogService extends CurdService<OparetionLogRepository, OparetionLog> {
}
