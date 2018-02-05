package st.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.core.mapper.BaseMapper;
import st.core.service.BaseService;
import st.crm.mapper.RoleMapper;

@Service("roleService")
public class RoleService<T> extends BaseService<T> {
	@Autowired
	private RoleMapper<T> roleMapper;

	@Override
	public BaseMapper<T> getMapper() {
		// TODO Auto-generated method stub
		return roleMapper;
	}
}
