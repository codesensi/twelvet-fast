package com.twelvet.system.server.service.impl;

import com.twelvet.framework.utils.TUtils;
import com.twelvet.system.api.domain.SysLoginInfo;
import com.twelvet.system.api.domain.SysUser;
import com.twelvet.system.server.mapper.SysUserMapper;
import com.twelvet.system.server.service.ISysLoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author twelvet
 * @WebSite www.twelvet.cn
 * @Description: 系统操作/访问日志
 */
@Service
public class ISysLoginInfoServiceImpl implements ISysLoginInfoService {

	@Autowired
	private SysLoginInfoMapper SysLoginInfoMapper;

	@Autowired
	private SysUserMapper sysUserMapper;

	/**
	 * 查询系统登录日志集合
	 * @param loginInfo 访问日志对象
	 * @return List<SysLoginInfo>
	 */
	@Override
	public List<SysLoginInfo> selectLoginInfoList(SysLoginInfo loginInfo) {
		return SysLoginInfoMapper.selectLoginInfoList(loginInfo);
	}

	/**
	 * 批量删除系统登录日志
	 * @param infoIds 需要删除的登录日志ID
	 * @return 操作结果
	 */
	@Override
	public int deleteLoginInfoByIds(Long[] infoIds) {
		return SysLoginInfoMapper.deleteLoginInfoByIds(infoIds);
	}

	/**
	 * 清空系统登录日志
	 */
	@Override
	public void cleanLoginInfo() {
		SysLoginInfoMapper.cleanLoginInfo();
	}

	/**
	 * 新增系统登录日志
	 * @param loginInfo 访问日志对象
	 */
	@Override
	public int insertLoginInfo(SysLoginInfo loginInfo) {
		String userName = loginInfo.getUserName();

		if (TUtils.isNotEmpty(userName)) {
			SysUser sysUser = sysUserMapper.selectUserByUserName(userName);
			if (TUtils.isNotEmpty(sysUser)) {
				Long deptId = sysUser.getDeptId();
				loginInfo.setDeptId(deptId);
				return SysLoginInfoMapper.insertLoginInfo(loginInfo);
			}
		}

		return 0;
	}

}
