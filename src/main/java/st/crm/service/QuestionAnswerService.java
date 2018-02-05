package st.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.core.mapper.BaseMapper;
import st.core.service.BaseService;
import st.crm.mapper.QuestionAnswerMapper;

@Service("questionAnswerService")
public class QuestionAnswerService<T> extends BaseService<T> {
	@Autowired
	private QuestionAnswerMapper<T> questionAnswerMapper;

	@Override
	public BaseMapper<T> getMapper() {
		// TODO Auto-generated method stub
		return questionAnswerMapper;
	}

}
