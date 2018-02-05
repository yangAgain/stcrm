package st.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import st.core.mapper.BaseMapper;
import st.core.service.BaseService;
import st.crm.mapper.UserMapper;
import st.crm.model.UserModel;

@Service("userService")
public class UserService<T> extends BaseService<T> {

	@Autowired(required = true)
	private UserMapper<T> userMapper;

	@Override
	public BaseMapper<T> getMapper() {
		// TODO Auto-generated method stub
		return userMapper;
	}

	public List<UserModel> selectAboutQA(UserModel um) {
		return userMapper.selectAboutQA(um);
	}

}
