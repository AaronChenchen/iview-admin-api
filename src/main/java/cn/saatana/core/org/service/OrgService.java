package cn.saatana.core.org.service;

import org.springframework.stereotype.Service;

import cn.saatana.core.common.CurdService;
import cn.saatana.core.org.dao.OrgMapper;
import cn.saatana.core.org.entity.Org;

@Service
public class OrgService extends CurdService<OrgMapper, Org> {

}
