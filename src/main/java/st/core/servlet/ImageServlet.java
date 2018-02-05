package st.core.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import st.core.session.SessionUtils;


public class ImageServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private int               width            = 60; // 楠岃瘉鐮佸浘鐗囩殑�?�藉害銆�?
    private int               height           = 20; // 楠岃瘉鐮佸浘鐗囩殑楂樺害銆�
    private int               codeCount        = 4;  // 楠岃瘉鐮佸瓧绗︿釜鏁�?
    private int               x                = 0;  // 楠岃瘉鐮佷腑瀛楃闂磋窛
    private int               fontHeight;            // 瀛椾綋楂樺害
    private int               codeY;

    // ,'L', 'O','l','o'
    // char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
    // 'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T',
    // 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
    // 'i', 'j', 'k', 'm', 'n', 'p', 'q',
    // 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4',
    // '5', '6', '7', '8', '9' };
    char[] codeSequence = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    @Override
    protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
        // doPost(arg0, arg1);
    }

    public void init() throws ServletException {
        // 浠巜eb.xml涓幏鍙栧垵濮嬩俊鎭�?
        String strWidth = this.getInitParameter("width");// 瀹藉�?
        String strHeight = this.getInitParameter("height");// 楂樺�?
        String strCodeCount = this.getInitParameter("codeCount"); // 瀛楃涓暟
        // 灏嗛厤缃殑淇℃伅杞崲鎴愭暟鍊�?
        try {
            if (strWidth != null && strWidth.length() != 0) {
                width = Integer.parseInt(strWidth);
            }
            if (strHeight != null && strHeight.length() != 0) {
                height = Integer.parseInt(strHeight);
            }
            if (strCodeCount != null && strCodeCount.length() != 0) {
                codeCount = Integer.parseInt(strCodeCount);
            }
        } catch (NumberFormatException e) {
        }
        x = width / (codeCount + 1);
        fontHeight = height;
        codeY = height;
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {
        // 瀹氫箟鍥惧儚buffer
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();
        // 灏嗗浘鍍忓～鍏呬负鐧借壊
        g.setColor(getRandColor(220, 250));
        g.fillRect(0, 0, width, height);
        // 鍒涘缓�?�椾綋锛屽瓧浣撶殑澶у皬搴旇鏍规嵁鍥剧墖鐨勯珮搴︽潵瀹氥��
        Font font = new Font("榛戜�?", Font.BOLD, fontHeight - 5);
        // 璁剧疆�?�椾綋銆�?
        g.setFont(font);
        // 鐢昏竟妗嗐��?
        // g.setColor(Color.pink);
        // g.drawRect(0, 0, width - 1, height - 1);
        // 闅忔�?浜х敓150鏉�?�共鎵扮嚎锛屼娇鍥捐薄涓殑璁よ瘉鐮佷笉鏄撹鍏跺畠绋嬪簭鎺㈡祴鍒般��
        /*
         * g.setColor(getRandColor(120, 200)); for (int i = 0; i < 150; i++) {
         * int x = random.nextInt(width); int y = random.nextInt(height); int xl
         * = random.nextInt(10); int yl = random.nextInt(10); g.drawLine(x,
         * y,x+xl,y+yl); }
         */
        // 闅忔�?浜х敓450涓共鎵扮偣锛屼娇鍥捐薄涓殑璁よ瘉鐮佷笉鏄撹鍏跺畠绋嬪簭鎺㈡祴鍒般��?
        g.setColor(getRandColor(120, 200));
        // 鍒涘缓涓�涓殢鏈烘暟鐢熸垚鍣ㄧ�?
        Random random = new Random();
        for (int i = 0; i < 550; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            g.drawOval(x, y, 0, 0);
        }

        // randomCode鐢ㄤ簬淇濆瓨闅忔�?浜х敓鐨勯獙璇佺爜锛屼互渚跨敤鎴风櫥褰曞悗杩涜楠岃瘉銆�
        StringBuffer randomCode = new StringBuffer();
        // 闅忔�?浜х敓codeCount鏁板瓧鐨勯獙璇佺爜銆�?
        for (int i = 0; i < codeCount; i++) {
            // 寰楀埌闅忔満浜х敓鐨勯獙璇佺爜鏁板瓧銆�?
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
            // 浜х敓闅忔�?鐨勯鑹插垎閲忔潵鏋勯�犻鑹插�硷紝杩欐牱杈撳嚭鐨勬瘡浣嶆暟�?�楃殑棰滆壊鍊奸兘灏嗕笉鍚屻��
            g.setColor(getRandColor(20, 130));
            // 鐢ㄩ殢鏈轰骇鐢熺殑棰滆壊灏嗛獙璇佺爜缁樺埗鍒板浘鍍忎腑銆�?
            g.drawString(strRand, (i + 1) * x - 7, codeY - 5);
            // 灏嗕骇鐢熺殑鍥涗釜闅忔満鏁扮粍鍚堝湪涓�璧枫��
            randomCode.append(strRand);
        }
        // 灏嗗洓浣嶆暟瀛楃殑楠岃瘉鐮佷繚�?�樺埌Session涓��
        // HttpSession session = req.getSession();
        // session.setAttribute("validateCode", randomCode.toString());
        SessionUtils.setValidateCode(req, randomCode.toString().toLowerCase());
        // 绂佹鍥惧儚缂撳瓨銆�?
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setContentType("image/jpeg");
        // 灏嗗浘鍍忚緭鍑哄埌Servlet杈撳嚭娴佷腑銆�
        ServletOutputStream sos = resp.getOutputStream();
        ImageIO.write(buffImg, "jpeg", sos);
        sos.close();
    }

    /**
     * 浜х敓闅忔�?棰滆�?
     * 
     * @param num1
     * @param num2
     * @return Color
     */
    public static Color getRandColor(int num1, int num2) {
        Random random = new Random();
        if (num1 > 255)
            num1 = 255;
        if (num2 > 255)
            num2 = 255;
        int r = num1 + random.nextInt(num2 - num1);
        int g = num1 + random.nextInt(num2 - num1);
        int b = num1 + random.nextInt(num2 - num1);
        return new Color(r, g, b);
    }

}
