package cn.saatana.core.dict.service;

import org.springframework.stereotype.Service;

import cn.saatana.core.common.CurdService;
import cn.saatana.core.dict.dao.DictionaryDao;
import cn.saatana.core.dict.entity.Dictionary;

@Service
public class DictionaryService extends CurdService<DictionaryDao, Dictionary> {

}
