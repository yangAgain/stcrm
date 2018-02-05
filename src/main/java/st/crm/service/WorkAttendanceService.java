package st.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.core.mapper.BaseMapper;
import st.core.service.BaseService;
import st.crm.mapper.WorkAttendanceMapper;

@Service("workAttendanceService")
public class WorkAttendanceService<T> extends BaseService<T> {
	@Autowired
	private WorkAttendanceMapper<T> workAttendanceMapper;

	@Override
	public BaseMapper<T> getMapper() {
		// TODO Auto-generated method stub
		return workAttendanceMapper;
	}

}
