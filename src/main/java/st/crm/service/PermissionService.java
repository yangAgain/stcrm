package st.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.core.mapper.BaseMapper;
import st.core.service.BaseService;
import st.crm.mapper.PermissionMapper;

@Service("permissionService")
public class PermissionService<T> extends BaseService<T> {

	@Autowired
	private PermissionMapper<T> permissionMapper;

	@Override
	public BaseMapper<T> getMapper() {
		// TODO Auto-generated method stub
		return permissionMapper;
	}

}
