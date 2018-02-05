package st.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.core.mapper.BaseMapper;
import st.core.service.BaseService;
import st.crm.mapper.AssessmentMapper;
@Service("assessmentService")
public class AssessmentService<T> extends BaseService<T> {

	@Autowired
	private AssessmentMapper<T> assessmentMapper;

	@Override
	public BaseMapper<T> getMapper() {
		// TODO Auto-generated method stub
		return assessmentMapper;
	}

}
