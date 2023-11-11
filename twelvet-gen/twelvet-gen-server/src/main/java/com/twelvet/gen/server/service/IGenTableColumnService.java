package com.twelvet.gen.server.service;

import com.twelvet.gen.api.domain.GenGroup;
import com.twelvet.gen.api.domain.GenTableColumn;

import java.util.List;

/**
 * @author twelvet
 * @WebSite twelvet.cn
 * @Description: 业务字段 服务层
 */
public interface IGenTableColumnService {

	/**
	 * 查询业务字段列表
	 * @param tableId 业务字段编号
	 * @return 业务字段集合
	 */
	List<GenTableColumn> selectGenTableColumnListByTableId(Long tableId);

	/**
	 * 新增业务字段
	 * @param genTableColumn 业务字段信息
	 * @return 结果
	 */
	int insertGenTableColumn(GenTableColumn genTableColumn);

	/**
	 * 修改业务字段
	 * @param genTableColumn 业务字段信息
	 * @return 结果
	 */
	int updateGenTableColumn(GenTableColumn genTableColumn);

	/**
	 * 删除业务字段信息
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	int deleteGenTableColumnByIds(String ids);

	/**
	 * 查询代码生成业务所有模板分组列表
	 * @return List GenTemplate
	 */
	public List<GenGroup> selectGenGroupAll();

}
