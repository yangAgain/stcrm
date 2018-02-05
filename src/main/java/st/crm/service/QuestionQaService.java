package st.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.core.mapper.BaseMapper;
import st.core.service.BaseService;
import st.crm.mapper.QuestionQaMapper;

@Service("questionQaService")
public class QuestionQaService<T> extends BaseService<T> {
	@Autowired
	private QuestionQaMapper<T> questionQaMapper;

	@Override
	public BaseMapper<T> getMapper() {
		// TODO Auto-generated method stub
		return questionQaMapper;
	}

}
