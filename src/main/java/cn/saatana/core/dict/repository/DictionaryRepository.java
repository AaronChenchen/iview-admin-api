package cn.saatana.core.dict.repository;

import org.springframework.stereotype.Component;

import cn.saatana.core.common.CurdRepository;
import cn.saatana.core.dict.entity.Dictionary;

@Component
public interface DictionaryRepository extends CurdRepository<Dictionary> {

}
