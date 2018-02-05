package st.core.tool;

import java.security.MessageDigest;

public class FormatMD5 {

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * MD5 鍔犲�?
     * 
     */
    public static String MD5(String origin) {
        String resultString = MD5Encode(origin, "UTF-8");
        if (!FormatEmpty.isEmpty(resultString)) {
            return resultString.toUpperCase();
        }
        return resultString;
    }

    /**
     * MD5 姣旇�? 鍖归厤origin 鍔犲瘑鍚庢槸鍚︾瓑浜巑d5
     * 
     * @param origin
     *            瀵嗙爜锛�? 鏈姞�?��
     * @param md5
     *            宸插姞�?�嗗瓧绗︿覆
     * @return
     */
    public static boolean ecompareMD5(String origin, String md5) {
        String result = MD5(origin);
        return md5.equals(result);
    }

    /*
     * MD5 鍔犲�?
     */
    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            else
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
        } catch (Exception exception) {

        }
        return resultString;
    }

    private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f" };

    /**
     * 灏哹yte鏁扮粍杞崲涓鸿〃绀�?16杩涘埗鍊肩殑瀛楃涓诧紝 濡傦細byte[]{8,18}杞崲涓猴細0813锛� 鍜宲ublic static byte[]
     * hexStr2ByteArr(String strIn) 浜掍负鍙�嗙殑杞崲杩囩▼
     * 
     * @param arrB
     *            闇�瑕佽浆鎹㈢殑byte鏁扮�?
     * @return 杞崲鍚庣殑瀛楃涓�?
     * @throws Exception
     *             鏈柟娉曚笉澶勭悊浠讳綍寮傚父锛屾墍鏈夊紓甯稿叏閮ㄦ姏鍑�?
     */
    public static String byteArr2HexStr(byte[] arrB) throws Exception {
        int iLen = arrB.length;
        // 姣忎釜byte鐢ㄤ袱涓瓧绗︽墠鑳借�?�绀猴紝鎵�浠ュ瓧绗︿覆鐨勯暱搴︽槸鏁扮粍闀垮害鐨勪袱鍊�?
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // 鎶婅礋鏁拌浆鎹负姝ｆ暟
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // 灏忎�?0F鐨勬暟闇�瑕佸湪鍓嶉潰琛�?0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    /**
     * 灏嗚〃绀�?16杩涘埗鍊肩殑瀛楃涓茶浆鎹负byte鏁扮粍锛�? 鍜宲ublic static String byteArr2HexStr(byte[] arrB)
     * 浜掍负鍙�嗙殑杞崲杩囩▼
     * 
     * @param strIn
     *            闇�瑕佽浆鎹㈢殑瀛楃涓�?
     * @return 杞崲鍚庣殑byte鏁扮�?
     * @throws Exception
     *             鏈柟娉曚笉澶勭悊浠讳綍寮傚父锛屾墍鏈夊紓甯稿叏閮ㄦ姏鍑�?
     * @author <a href="mailto:leo841001@163.com">LiGuoQing</a >
     */
    public static byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;

        // 涓や釜�?�楃琛ㄧず涓�涓瓧鑺傦紝鎵�浠ュ瓧鑺傛暟缁勯暱搴︽槸瀛楃涓查暱搴﹂櫎浠�?2
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

}