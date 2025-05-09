//
//package mvc.controller;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import java.io.IOException;
//import java.util.ArrayList;
//import mvc.model.Experience;
//
//public class ReservationListServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ArrayList<Experience> experiences = new ArrayList<>();
//
//        // 더미 데이터 예시
//        experiences.add(new Experience("Landscape & Cityscape", "./resources/img/exs01.jpg", "2025-06-05", 120, 3, 15, "Describe your forum category. Engage your audience and entice them to continue reading."));
//        experiences.add(new Experience("Nature & Wildlife", "./resources/img/exs02.jpg", "2025-05-15", 98, 3, 15, "Add your category description here. Be sure to write in an informative way that entices further reading."));
//        experiences.add(new Experience("Black & White", "./resources/img/체험02.jpg", "2025-05-09", 56, 3, 15, "Describe your forum category. Engage your audience and entice them to continue reading."));
//        experiences.add(new Experience("Macro Photography", "./resources/img/체험03.jpg", "2025-08-05", 42, 3, 15, "Add your category description here. Be sure to write in an informative way that entices further reading."));
//
//        // 2번째 섹션 카드 추가
//        experiences.add(new Experience("Landscape & Cityscape", "./resources/img/체험05.jpg", "2025-08-05", 120, 3, 15, "Describe your forum category. Engage your audience and entice them to continue reading."));
//        experiences.add(new Experience("Landscape & Cityscape", "./resources/img/체험03.jpg", "2025-08-05", 120, 3, 15, "Describe your forum category. Engage your audience and entice them to continue reading."));
//        experiences.add(new Experience("Landscape & Cityscape", "./resources/img/체험02.jpg", "2025-08-05", 120, 3, 15, "Describe your forum category. Engage your audience and entice them to continue reading."));
//
//        request.setAttribute("experiences", experiences);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/reservationList.jsp");
//        dispatcher.forward(request, response);
//    }
//}
