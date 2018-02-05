package st.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.core.mapper.BaseMapper;
import st.core.service.BaseService;
import st.crm.mapper.ProjectMapper;

@Service("projectService")
public class ProjectService<T> extends BaseService<T> {
	@Autowired
	private ProjectMapper<T> projectMapper;

	@Override
	public BaseMapper<T> getMapper() {
		// TODO Auto-generated method stub
		return projectMapper;
	}

}
