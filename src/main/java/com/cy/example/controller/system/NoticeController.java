package com.cy.example.controller.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cy.example.controller.BaseController;
import com.cy.example.entity.system.SysNoticeEntity;
import com.cy.example.model.Page;
import com.cy.example.model.Result;
import com.cy.example.service.INoticeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/notice")
public class NoticeController extends BaseController {

	@Autowired
	private INoticeService noticeService;
	
	@PostMapping
	@RequiresPermissions("notice:add")
	public Result<String> add(@ModelAttribute("notice") SysNoticeEntity notice) {
		boolean flag = noticeService.insert(notice);
		return new Result<>(flag,flag?"添加成功！":"添加失败！",0,null);
	}

	@PutMapping
	@RequiresPermissions("notice:update")
	public Result<String> update(@ModelAttribute("role") SysNoticeEntity notice) {
		boolean flag = noticeService.updateById(notice);
		return new Result<>(flag,flag?"更新成功！":"更新失败！",0,null);
	}

	@DeleteMapping("/{id}")
	@RequiresPermissions("notice:delete")
	public Result<String> delete(@PathVariable("id")Long id) {
		boolean flag = noticeService.deleteById(id);
		return new Result<>(flag,flag?"删除成功！":"删除失败！",0,null);
	}

	@GetMapping
	@RequiresPermissions("notice:list")
	public Result<List<SysNoticeEntity>> findAll(int page, int rows) {
		com.baomidou.mybatisplus.plugins.Page list = noticeService.selectPage(new com.baomidou.mybatisplus.plugins.Page(page, rows)
				, new EntityWrapper<SysNoticeEntity>().setSqlSelect("c_title,c_content,n_order,c_createDate,c_updateDate,id"));
		int sum = noticeService.selectCount(new EntityWrapper<SysNoticeEntity>());
		return new Result<>(true,null,sum,list.getRecords());
	}

	@GetMapping("/search")
	@RequiresPermissions("notice:list")
	public Result<List<SysNoticeEntity>> search(
			@ModelAttribute("notice") SysNoticeEntity notice,
			@ModelAttribute("page") Page page) {
		List<SysNoticeEntity> list = noticeService.searchAll(
				notice, page);
		int sum = noticeService.searchAllCount(notice);
		return new Result<>(true,null,sum,list);
	}

}
