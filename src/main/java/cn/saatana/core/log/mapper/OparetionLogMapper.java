package cn.saatana.core.log.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import cn.saatana.core.common.CommonMapper;
import cn.saatana.core.log.entity.OparetionLog;

@Mapper
@Component
public interface OparetionLogMapper extends CommonMapper<OparetionLog> {

}
