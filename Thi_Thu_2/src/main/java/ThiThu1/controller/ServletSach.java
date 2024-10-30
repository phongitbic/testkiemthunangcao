package ThiThu1.controller;

import ThiThu1.entity.NhaXuatBan;
import ThiThu1.entity.Sach;
import ThiThu1.service.ServiceSach;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletSach", value = {
        "/sach/hien-thi",
        "/sach/view-them",
        "/sach/them",
        "/sach/xoa",
        "/sach/details"
})
public class ServletSach extends HttpServlet {
    ServiceSach serviceSach = new ServiceSach();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("vcl");
        String uri = request.getRequestURI();

        if (uri.contains("hien-thi")) {
            this.HienThi(request, response);
        } else if (uri.contains("view-them")) {
            this.ViewThem(request, response);
        }else if(uri.contains("xoa")){
            this.Xoa(request,response);
        }else if(uri.contains("details")){
            this.Details(request,response);
        }
    }

    private void Details(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        request.setAttribute("sachDetails",serviceSach.getByIdSach(id));
        List<NhaXuatBan> nhaXuatBanList = serviceSach.getListNhaXuatBan();
        request.setAttribute("nxbList", nhaXuatBanList);
        request.getRequestDispatcher("/details.jsp").forward(request,response);
    }

    private void Xoa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //tạo mới 1 đối tượng Sach
        Sach sach = new Sach();
        // truyền cho đối tượng sachs vừa tạo từ id trên bảng hiển thị
                                    // laySachBYID (id) trong đó id lấy từ file jsp
        sach = serviceSach.getByIdSach(Integer.valueOf(request.getParameter("idXoa")));

        //Gọi hàm xóa
        serviceSach.Xoa(sach);
        // xóa xong thì quay lại trang hiển thị
        response.sendRedirect("/sach/hien-thi");
    }

    private void ViewThem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhaXuatBan> nhaXuatBanList = serviceSach.getListNhaXuatBan();
        request.setAttribute("nxbList", nhaXuatBanList);
        request.getRequestDispatcher("/view-them.jsp").forward(request, response);
    }

    private void HienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sach> sachList = serviceSach.getListSach();
        request.setAttribute("sachList", sachList);
        request.getRequestDispatcher("/hienthi.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if(uri.contains("them")){
            this.Them(request,response);
        }
    }

    private void Them(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Sach sach = new Sach();

        sach.setMa(request.getParameter("ma"));
        sach.setTen(request.getParameter("ten"));
        sach.setSoTrang(Integer.parseInt(request.getParameter("soTrang")));
        sach.setDonGia(Long.parseLong(request.getParameter("donGia")));

        sach.setNhaXuatBan(serviceSach.getByIDNxb(Integer.valueOf(request.getParameter("nhaXuatBan"))));

        sach.setTrangThai(Integer.parseInt(request.getParameter("trangThai")));

        serviceSach.Them(sach);

        response.sendRedirect("/sach/hien-thi");

    }
}
