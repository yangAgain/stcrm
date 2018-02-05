package st.core.session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import st.core.tool.Constant;

/**
 * Cookie 宸ュ叿绫�
 */
public final class SessionUtils {

	private static HttpSession getHttpSession(HttpServletRequest request) {
		return request.getSession(true);
	}

	/**
	 * 璁剧疆session鐨勫��
	 * 
	 * @param request
	 * @param key
	 * @param value
	 */
	public static void setAttr(HttpServletRequest request, String key, Object value) {
		getHttpSession(request).setAttribute(key, value);
	}

	/**
	 * 鑾峰彇session鐨勫��
	 * 
	 * @param request
	 * @param key
	 * @param value
	 */
	public static Object getAttr(HttpServletRequest request, String key) {
		return getHttpSession(request).getAttribute(key);
	}

	/**
	 * 鍒犻櫎Session鍊�
	 * 
	 * @param request
	 * @param key
	 */
	public static void removeAttr(HttpServletRequest request, String key) {
		getHttpSession(request).removeAttribute(key);
	}

	/**
	 * 璁剧疆楠岃瘉鐮� 鍒皊ession
	 * 
	 * @param request
	 * @param user
	 */
	public static void setValidateCode(HttpServletRequest request, String validateCode) {
		setAttr(request, Constant.SYS_SESSION_VALIDATECODE, validateCode);
	}

	/**
	 * 浠巗ession涓幏鍙栭獙璇佺爜
	 * 
	 * @param request
	 * @return SysUser
	 */
	public static String getValidateCode(HttpServletRequest request) {
		return getAttr(request, Constant.SYS_SESSION_VALIDATECODE).toString();
	}

	/**
	 * 浠巗ession涓幏鍒犻櫎楠岃瘉鐮�
	 * 
	 * @param request
	 * @return SysUser
	 */
	public static void removeValidateCode(HttpServletRequest request) {
		removeAttr(request, Constant.SYS_SESSION_VALIDATECODE);
	}

	/**
	 * 璁剧疆鐢ㄦ埛淇℃伅 鍒皊ession
	 * 
	 * @param request
	 * @param user
	 */
//	 public static void setUser(HttpServletRequest request, SysUserModel user) {
//	 setAttr(request, Constant.SYS_SESSION_USER, user);
//	 }

	/**
	 * 浠巗ession涓幏鍙栫敤鎴蜂俊鎭�
	 * 
	 * @param request
	 * @return SysUser
	 */
//	 public static SysUserModel getUser(HttpServletRequest request) {
//	 return (SysUserModel) getAttr(request, Constant.SYS_SESSION_USER);
//	 }

	/**
	 * 浠巗ession涓幏鍙栫敤鎴蜂俊鎭�
	 * 
	 * @param request
	 * @return SysUser
	 */
	// public static void removeUser(HttpServletRequest request) {
	// removeAttr(request, Constant.SYS_SESSION_USER);
	// }

	/**
	 * 鍒ゆ柇褰撳墠鐧诲綍鐢ㄦ埛鏄惁瓒呯骇绠＄悊鍛�
	 * 
	 * @param request
	 * @return
	 */
	// public static boolean isAdmin(HttpServletRequest request) { //
	// 鍒ゆ柇鐧诲綍鐢ㄦ埛鏄惁瓒呯骇绠＄悊鍛�
	// SysUserModel user = getUser(request);
	// if (user == null || user.getAdmin() != Constant.SYS_ADMIN_1) {
	// return false;
	// }
	// return true;
	// }
	//
	// public static void setSysDict(HttpServletRequest request, List<SysDictModel>
	// sysDictList) {
	// if (sysDictList == null || sysDictList.isEmpty()) {
	// return;
	// }
	// Map<String, Map<String, Object>> sysDictMap1 = new HashMap<>();
	// Map<String, List<SysDictModel>> sysDictMap2 = new HashMap<>();
	// for (SysDictModel sysDict : sysDictList) {
	// String typeCode = sysDict.getTypeCode();
	// Map<String, Object> map1 = sysDictMap1.get(typeCode);
	// if (map1 == null) {
	// map1 = new HashMap<>();
	// sysDictMap2.put(typeCode, new ArrayList<>());
	// }
	// map1.put(sysDict.getCode(), sysDict.getName());
	// sysDictMap1.put(typeCode, map1);
	// sysDictMap2.get(typeCode).add(sysDict);
	// }
	// for (Entry<String, Map<String, Object>> entry : sysDictMap1.entrySet()) {
	// entry.getValue().put("list", sysDictMap2.get(entry.getKey()));
	// setAttr(request, entry.getKey(), entry.getValue());
	// }
	// }
	//
	// @SuppressWarnings("unchecked")
	// public static List<SysDictModel> getSysDic(HttpServletRequest request, String
	// key) {
	// Object obj = getAttr(request, key);
	// return obj == null ? null : (List<SysDictModel>) ((Map<String, Object>)
	// obj).get("list");
	// }

}