package st.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.core.mapper.BaseMapper;
import st.core.service.BaseService;
import st.crm.mapper.QuestionMapper;

@Service("questionService")
public class QuestionService<T> extends BaseService<T> {
	@Autowired
	private QuestionMapper<T> questionMapper;

	@Override
	public BaseMapper<T> getMapper() {
		// TODO Auto-generated method stub
		return questionMapper;
	}

}
