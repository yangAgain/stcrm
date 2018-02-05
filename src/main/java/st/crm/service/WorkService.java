package st.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.core.mapper.BaseMapper;
import st.core.service.BaseService;
import st.crm.mapper.WorkMapper;

@Service("workService")
public class WorkService<T> extends BaseService<T> {
	@Autowired
	private WorkMapper<T> workMapper;

	@Override
	public BaseMapper<T> getMapper() {
		// TODO Auto-generated method stub
		return workMapper;
	}

}
