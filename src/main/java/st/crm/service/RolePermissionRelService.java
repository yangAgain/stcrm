package st.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.core.mapper.BaseMapper;
import st.core.service.BaseService;
import st.crm.mapper.RolePermissionRelMapper;

@Service("rolePermissionRelService")
public class RolePermissionRelService<T> extends BaseService<T> {
	@Autowired
	private RolePermissionRelMapper<T> rolePermissionRelMapper;

	@Override
	public BaseMapper<T> getMapper() {
		// TODO Auto-generated method stub
		return rolePermissionRelMapper;
	}

}
