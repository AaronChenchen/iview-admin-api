package cn.saatana.core.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.saatana.core.dict.entity.Dictionary;
import cn.saatana.core.dict.service.DictionaryService;

@Component
public class DictUtils {
	private static DictionaryService dictService;

	@Autowired
	public void setDictService(DictionaryService dictService) {
		DictUtils.dictService = dictService;
	}

	/**
	 * 根据字典代码和字典值查询字典标签
	 *
	 * @param code
	 *            字典代码
	 * @param value
	 *            字典值
	 * @return 字典标签
	 */
	public static String query(String code, int value) {
		String res = "未知";
		Dictionary entity = new Dictionary(code, value);
		List<Dictionary> list = dictService.findList(entity);
		if (list.size() > 0) {
			res = list.get(0).getLabel();
		}
		return res;
	}

	/**
	 * 根据字典代码和字典值查询字典标签
	 *
	 * @param code
	 *            字典代码
	 * @param label
	 *            字典标签
	 * @return 字典值
	 */
	public static int query(String code, String label) {
		int res = -1;
		Dictionary entity = new Dictionary(code, label);
		List<Dictionary> list = dictService.findList(entity);
		if (list.size() > 0) {
			res = list.get(0).getValue();
		}
		return res;
	}
}
