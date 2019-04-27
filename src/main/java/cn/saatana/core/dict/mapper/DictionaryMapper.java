package cn.saatana.core.dict.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import cn.saatana.core.common.CommonMapper;
import cn.saatana.core.dict.entity.Dictionary;

@Mapper
@Component
public interface DictionaryMapper extends CommonMapper<Dictionary> {

}
