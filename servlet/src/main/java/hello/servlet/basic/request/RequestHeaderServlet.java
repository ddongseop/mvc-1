package hello.servlet.basic.request;

import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
        printEtc(request);
    }

    private static void printStartLine(HttpServletRequest request) {
        System.out.println("--- REQUEST-LINE - start ---");
        System.out.println("request.getMethod() = " + request.getMethod());
        System.out.println("request.getProtocol() = " + request.getProtocol());
        System.out.println("request.getScheme() = " + request.getScheme());
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure());
        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();
    }

    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- Headers - start ---");
        request.getHeaderNames().asIterator().forEachRemaining((headerName) -> {
            System.out.println(headerName + ": " + request.getHeader(headerName));
        });
        System.out.println("--- Headers - end ---");
        System.out.println();
    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("--- Header ํธ์ ์กฐํ start ---");
        System.out.println("[Host ํธ์ ์กฐํ]");
        System.out.println("request.getServerName() = " + request.getServerName());
        System.out.println("request.getServerPort() = " + request.getServerPort());
        System.out.println();

        System.out.println("[Accept-Language ํธ์ ์กฐํ]");
        request.getLocales().asIterator().forEachRemaining((locale) -> {
            System.out.println("locale = " + locale);
        });
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();

        System.out.println("[Cookie ํธ์ ์กฐํ]");
        if (request.getCookies() != null) {
            Cookie[] var2 = request.getCookies();
            int var3 = var2.length;
            for(int var4 = 0; var4 < var3; ++var4) {
                Cookie cookie = var2[var4];
                PrintStream var10000 = System.out;
                String var10001 = cookie.getName();
                var10000.println(var10001 + ": " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content ํธ์ ์กฐํ]");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());
        System.out.println("--- Header ํธ์ ์กฐํ end ---");
        System.out.println();
    }

    private void printEtc(HttpServletRequest request) {
        System.out.println("--- ๊ธฐํ ์กฐํ start ---");
        System.out.println("[Remote ์?๋ณด]");
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
        System.out.println("request.getRemotePort() = " + request.getRemotePort());
        System.out.println();

        System.out.println("[Local ์?๋ณด]");
        System.out.println("request.getLocalName() = " + request.getLocalName());
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr());
        System.out.println("request.getLocalPort() = " + request.getLocalPort());
        System.out.println("--- ๊ธฐํ ์กฐํ end ---");
        System.out.println();
    }
}
