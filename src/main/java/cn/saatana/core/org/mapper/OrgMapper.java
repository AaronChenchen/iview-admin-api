package cn.saatana.core.org.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import cn.saatana.core.common.CommonMapper;
import cn.saatana.core.org.entity.Org;

@Mapper
@Component
public interface OrgMapper extends CommonMapper<Org> {

}
