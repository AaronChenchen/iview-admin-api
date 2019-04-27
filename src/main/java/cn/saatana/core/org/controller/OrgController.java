package cn.saatana.core.org.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.saatana.core.annotation.LogOparetion;
import cn.saatana.core.common.CommonController;
import cn.saatana.core.common.Res;
import cn.saatana.core.org.entity.Org;
import cn.saatana.core.org.mapper.OrgMapper;
import cn.saatana.core.org.service.OrgService;
import cn.saatana.core.utils.TreeUtils;
import cn.saatana.core.utils.tree.TreeNode;

@RestController
@RequestMapping("/org")
@LogOparetion("组织机构管理")
public class OrgController extends CommonController<OrgService, OrgMapper, Org> {

	@RequestMapping("tree")
	public Res<List<TreeNode<Org>>> tree() {
		List<Org> all = service.findList(new Org());
		List<TreeNode<Org>> tree = TreeUtils.buildTree(all);
		return Res.ok(tree);
	}

	@RequestMapping("tree/{roleId}")
	public Res<List<TreeNode<Org>>> roleMenuTree(@PathVariable(required = true) String roleId) {
		// TODO
		List<TreeNode<Org>> data = tree().getData();
		return Res.ok(data);
	}
}