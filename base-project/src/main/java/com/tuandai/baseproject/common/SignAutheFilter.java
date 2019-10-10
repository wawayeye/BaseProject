package com.tuandai.baseproject.common;


import com.tuandai.baseproject.util.MDUtils;
import com.tuandai.baseproject.util.RequestCommon;
import net.sf.json.JSONObject;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 * SpringBoot使用拦截器实现签名认证(鉴权)
 * @WebFilter注解指定要被过滤的URL
 * 一个URL会被多个过滤器过滤时,还可以使用@Order(x)来指定过滤request的先后顺序,x数字越小越先过滤
 *
 * @author xiaoyong
 * @DATE 2019年3月25日 下午1:18:29
 */
@WebFilter(urlPatterns = { "/credit/sendCreditMes"})
public class SignAutheFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(SignAutheFilter.class);

    @Value("${ip.whiteList}")
    private String[] permittedIps;

    @Value("${niwo.secret}")
    private String secret;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        try {
            String authorization = request.getHeader("Authorization");
            logger.info("getted Authorization is ---> " + authorization);
            String[] info = authorization.split(",");

            // 获取客户端ip
            String ip = RequestCommon.getRealIpAddress(request);
            logger.info("getted ip is ---> " + ip);

			/*
			 * 读取请求体中的数据(字符串形式)
			 * 注:由于同一个流不能读取多次;如果在这里读取了请求体中的数据,那么@RequestBody中就不能读取到了
			 *    会抛出异常并提示getReader() has already been called for this request
			 * 解决办法:先将读取出来的流数据存起来作为一个常量属性.然后每次读的时候,都需要先将这个属性值写入,再读出.
			 *        即每次获取的其实是不同的流,但是获取到的数据都是一样的.
			 *        这里我们借助HttpServletRequestWrapper类来实现
			 *      注:此方法涉及到流的读写、耗性能;
			 */
            MyRequestWrapper mrw = new MyRequestWrapper(request);
            String bodyString = mrw.getBody();
            logger.info("getted requestbody data is ---> " + bodyString);
            String request_no = JSONObject.fromObject(bodyString).getString("request_no");

            int timestampIndex = info[0].indexOf("=") + 2;
            String timestamp = info[0].substring(timestampIndex, info[0].length() - 1);
            int signatureIndex = info[1].indexOf("=") + 2;
            String signature = info[1].substring(signatureIndex, info[1].length() - 1);
            String tmptString = MDUtils.MD5EncodeForHex(timestamp + secret + request_no, "UTF-8")
                    .toUpperCase();
            logger.info("getted ciphertext is ---> {}, correct ciphertext is ---> {}",
                    signature , tmptString);

            // 判断该ip是否合法
            boolean containIp = false;
            for (String string : permittedIps) {
                if (string.equals(ip)) {
                    containIp = true;
                    break;
                }
            }
            if(!containIp){
                response.sendError(Common.NO_USER_WHITE_CODE, Common.NO_USER_WHITE_MESSAGE);
            }
            // 再判断Authorization内容是否正确,进而判断是否最终放行
            boolean couldPass = containIp && tmptString.equals(signature);
            if (couldPass) {
                // 放行
                chain.doFilter(mrw, response);
                return;
            }
            response.sendError(Common.NO_USER_SIGN_CODE, Common.NO_USER_SIGN_MESSAGE);
        } catch (Exception e) {
            logger.error("AxbAuthenticationFilter -> " + e.getMessage(), e);
            response.sendError(Common.ERROR_CODE, Common.ERROR_MESSAGE);
        }
    }

    @Override
    public void destroy() {

    }

}

class MyRequestWrapper extends HttpServletRequestWrapper {

    private final String body;

    public String getBody() {
        return body;
    }

    public MyRequestWrapper(final HttpServletRequest request) throws IOException {
        super(request);
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        body = sb.toString();
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream(body.getBytes());
        return new ServletInputStream() {
            /*
             * 重写ServletInputStream的父类InputStream的方法
             */
            @Override
            public int read() throws IOException {
                return bais.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener listener) {
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

}

