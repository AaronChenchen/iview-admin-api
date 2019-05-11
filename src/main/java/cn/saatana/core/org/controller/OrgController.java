package cn.saatana.core.org.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.saatana.core.annotation.LogOparetion;
import cn.saatana.core.common.CurdController;
import cn.saatana.core.common.Res;
import cn.saatana.core.org.entity.Org;
import cn.saatana.core.org.repository.OrgRepository;
import cn.saatana.core.org.service.OrgService;
import cn.saatana.core.role.entity.Role;
import cn.saatana.core.role.service.RoleService;
import cn.saatana.core.utils.TreeUtils;
import cn.saatana.core.utils.tree.TreeNode;

@RestController
@RequestMapping("/org")
@LogOparetion("组织机构管理")
public class OrgController extends CurdController<OrgService, OrgRepository, Org> {

	@RequestMapping("tree")
	public Res<List<TreeNode<Org>>> tree() {
		List<Org> all = service.findList(new Org());
		List<TreeNode<Org>> tree = TreeUtils.buildTree(all);
		return Res.ok(tree);
	}

}
