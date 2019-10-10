package web;

import http.HttpUtils;
import service.ParseService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowServlet extends HttpServlet {
    private static final String path = "http://web.juhe.cn:8080/finance/stock/szall";
    private static final String param = "?key=704283239dd829ffd38f1cc4538465d0&page=5&type=2";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _num = getInitParameter("_num");
        System.out.println(_num);
        System.out.println(path + param);
        try {
            HttpUtils utils = new HttpUtils();
            String json = utils.httpGet(path , param);
//            System.out.println(json);

            ParseService service = new ParseService();
            String data = service.getParseList(json);
            System.out.println(data);

            resp.getWriter().write(data);

//            PrintWriter out = resp.getWriter();
//            out.println("<table style='border=1px'>");
//            out.println("<tr>");
//            out.println("<td>symbol</td>");
//            out.println("<td>changepercent</td>");
//            out.println("<td>amount</td>");
//            out.println("<td>code</td>");
//            out.println("<td>buy</td>");
//            out.println("<td>sell</td>");
//            out.println("<td>ticktime</td>");
//            out.println("<td>pricechange</td>");
//            out.println("<td>settlement</td>");
//            out.println("<td>volume</td>");
//            out.println("<td>high</td>");
//            out.println("<td>trade</td>");
//            out.println("<td>low</td>");
//            out.println("<td>name</td>");
//            out.println("<td>open</td>");
//            out.println("</tr>");
//            for (MyBean bean1 : list){
//                out.println("<tr>");
//                out.println("<td>"+ bean1.getSymbol() +"<td>");
//                out.println("<td>"+ bean1.getChangepercent() +"<td>");
//                out.println("<td>"+ bean1.getAmount() +"<td>");
//                out.println("<td>"+ bean1.getCode() +"<td>");
//                out.println("<td>"+ bean1.getBuy() +"<td>");
//                out.println("<td>"+ bean1.getSell() +"<td>");
//                out.println("<td>"+ bean1.getTicktime() +"<td>");
//                out.println("<td>"+ bean1.getPricechange() +"<td>");
//                out.println("<td>"+ bean1.getSettlement() +"<td>");
//                out.println("<td>"+ bean1.getVolume() +"<td>");
//                out.println("<td>"+ bean1.getHigh() +"<td>");
//                out.println("<td>"+ bean1.getTrade() +"<td>");
//                out.println("<td>"+ bean1.getLow() +"<td>");
//                out.println("<td>"+ bean1.getName() +"<td>");
//                out.println("<td>"+ bean1.getOpen() +"<td>");
//                out.println("</tr>");
//            }
//            out.println("</table>");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
