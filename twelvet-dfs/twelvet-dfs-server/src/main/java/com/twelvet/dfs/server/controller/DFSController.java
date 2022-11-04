package com.twelvet.dfs.server.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.twelvet.dfs.api.domain.SysDfs;
import com.twelvet.framework.core.application.controller.TWTController;
import com.twelvet.framework.core.application.domain.JsonResult;
import com.twelvet.framework.jdbc.web.page.TableDataInfo;
import com.twelvet.framework.jdbc.web.utils.PageUtils;
import com.twelvet.framework.log.annotation.Log;
import com.twelvet.framework.log.enums.BusinessType;
import com.twelvet.dfs.server.service.IDFSService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 文件请求处理
 */
@Tag(description = "DFSController", name = "文件请求处理")
@RestController
@RequestMapping("/dfs")
public class DFSController extends TWTController {

	@Autowired
	private IDFSService sysFileService;

	/**
	 * 多文件上传
	 * @param files MultipartFile[]
	 * @return JsonResult<List<SysDfs>>
	 */
	@Operation(summary = "多文件上传")
	@Log(service = "多文件上传", businessType = BusinessType.IMPORT)
	@PostMapping("/batchUpload")
	public JsonResult<List<SysDfs>> batchUpload(MultipartFile[] files) {
		// 上传并返回访问地址
		List<SysDfs> sysDfsList = sysFileService.uploadFiles(files);

		return JsonResult.success(sysDfsList);
	}

	/**
	 * 单文件上传
	 * @param file MultipartFile
	 * @return JsonResult<String>
	 */
	@Operation(summary = "单文件上传")
	@PostMapping("/commonUpload")
	@Log(service = "单文件上传", businessType = BusinessType.IMPORT)
	public JsonResult<String> commonUpload(MultipartFile file) {
		// 上传并返回访问地址
		SysDfs sysDfs = sysFileService.uploadFile(file);
		return JsonResult.success("上传成功", sysDfs.getPath());
	}

	/**
	 * 分页查询
	 * @param fileIds 文件地址
	 * @return JsonResult<String>
	 */
	@Operation(summary = "查询代码生成列表")
	@SaCheckPermission("dfs:dfs:remove")
	@Log(service = "删除文件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fileIds}")
	public JsonResult<String> deleteFile(@PathVariable Long[] fileIds) {
		sysFileService.deleteFile(fileIds);
		return JsonResult.success();
	}

	/**
	 * 分页查询
	 * @param sysDfs SysDfs
	 * @return JsonResult<TableDataInfo>
	 */
	@Operation(summary = "分页查询")
	@SaCheckPermission("dfs:dfs:list")
	@GetMapping("/pageQuery")
	public JsonResult<TableDataInfo> pageQuery(SysDfs sysDfs) {
		PageUtils.startPage();
		List<SysDfs> sysDfsList = sysFileService.selectSysDfsList(sysDfs);
		return JsonResult.success(PageUtils.getDataTable(sysDfsList));
	}

}
