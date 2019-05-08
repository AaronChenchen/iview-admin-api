package cn.saatana.core.log.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.saatana.core.annotation.Admin;
import cn.saatana.core.annotation.LogOparetion;
import cn.saatana.core.common.CurdController;
import cn.saatana.core.log.dao.OparetionLogDao;
import cn.saatana.core.log.entity.OparetionLog;
import cn.saatana.core.log.service.OparetionLogService;

@Admin
@RestController
@LogOparetion("操作日志管理")
@RequestMapping("/log")
public class OparetionLogController extends CurdController<OparetionLogService, OparetionLogDao, OparetionLog> {

}
