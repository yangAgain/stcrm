package st.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.core.mapper.BaseMapper;
import st.core.service.BaseService;
import st.crm.mapper.LeaveMapper;

@Service("leaveService")
public class LeaveService<T> extends BaseService<T> {

	@Autowired
	private LeaveMapper<T> leaveMapper;

	@Override
	public BaseMapper<T> getMapper() {
		// TODO Auto-generated method stub
		return leaveMapper;
	}

}
