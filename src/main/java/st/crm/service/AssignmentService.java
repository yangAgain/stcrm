package st.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.core.mapper.BaseMapper;
import st.core.service.BaseService;
import st.crm.mapper.AssignmentMapper;
@Service("assignmentService")
public class AssignmentService<T> extends BaseService<T> {

	@Autowired
	private AssignmentMapper<T> assignmentMapper;

	@Override
	public BaseMapper<T> getMapper() {
		// TODO Auto-generated method stub
		return assignmentMapper;
	}

}
