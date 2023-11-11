package com.twelvet.gen.server.service.impl;

import com.twelvet.gen.api.domain.GenTemplateGroup;
import com.twelvet.gen.server.mapper.GenTemplateGroupMapper;
import com.twelvet.gen.server.service.IGenTemplateGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 模板分组关联Service业务层处理
 *
 * @author TwelveT
 * @WebSite twelvet.cn
 */
@Service
public class GenTemplateGroupServiceImpl implements IGenTemplateGroupService {

	@Autowired
	private GenTemplateGroupMapper genTemplateGroupMapper;

	/**
	 * 查询模板分组关联
	 * @param groupId 模板分组关联主键
	 * @return 模板分组关联
	 */
	@Override
	public GenTemplateGroup selectGenTemplateGroupByGroupId(Long groupId) {
		return genTemplateGroupMapper.selectGenTemplateGroupByGroupId(groupId);
	}

	/**
	 * 新增模板分组关联
	 * @param genTemplateGroup 模板分组关联
	 * @return 结果
	 */
	@Override
	public int insertGenTemplateGroup(GenTemplateGroup genTemplateGroup) {
		return genTemplateGroupMapper.insertGenTemplateGroup(genTemplateGroup);
	}

	/**
	 * 修改模板分组关联
	 * @param genTemplateGroup 模板分组关联
	 * @return 结果
	 */
	@Override
	public int updateGenTemplateGroup(GenTemplateGroup genTemplateGroup) {
		return genTemplateGroupMapper.updateGenTemplateGroup(genTemplateGroup);
	}

	/**
	 * 批量删除模板分组关联
	 * @param groupIds 需要删除的模板分组关联主键
	 * @return 结果
	 */
	@Override
	public int deleteGenTemplateGroupByGroupIds(Long[] groupIds) {
		return genTemplateGroupMapper.deleteGenTemplateGroupByGroupIds(groupIds);
	}

	/**
	 * 删除模板分组关联信息
	 * @param groupId 模板分组关联主键
	 * @return 结果
	 */
	@Override
	public int deleteGenTemplateGroupByGroupId(Long groupId) {
		return genTemplateGroupMapper.deleteGenTemplateGroupByGroupId(groupId);
	}

}
