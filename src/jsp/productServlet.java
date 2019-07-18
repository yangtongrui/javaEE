package jsp;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pool.C3P0Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class productServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            String sql = "select * from product";
            List<product> productList = qr.query(sql, new BeanListHandler<>(product.class));
            System.out.println(productList);
            req.setAttribute("productList",productList);
            req.getRequestDispatcher(req.getContextPath()+"/product_list.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
