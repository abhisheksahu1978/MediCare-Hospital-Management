package com.demo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/patient")
public class PatientServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String ageInput = request.getParameter("age");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String disease = request.getParameter("disease");
        String doctor = request.getParameter("doctor");
        String date = request.getParameter("date");

        if (name == null || name.trim().isEmpty()
                || ageInput == null
                || gender == null || gender.isEmpty()
                || phone == null
                || disease == null || disease.trim().isEmpty()
                || doctor == null || doctor.isEmpty()
                || date == null || date.isEmpty()) {

            response.sendError(400, "Please enter all details.");
            return;
        }

        try {
            int age = Integer.parseInt(ageInput);

            if (age < 1 || age > 120
                    || !phone.matches("[0-9]{10}")) {
                response.sendError(400, "Invalid patient details.");
                return;
            }

            List<String> doctors = Arrays.asList(
                    "Dr. Sharma", "Dr. Verma",
                    "Dr. Singh", "Dr. Gupta");

            if (!doctors.contains(doctor)) {
                response.sendError(400, "Invalid doctor selection.");
                return;
            }

            request.setAttribute("name", name.trim());
            request.setAttribute("age", age);
            request.setAttribute("gender", gender);
            request.setAttribute("phone", phone);
            request.setAttribute("disease", disease.trim());
            request.setAttribute("doctor", doctor);
            request.setAttribute("date", date);

            List<String> departments = Arrays.asList(
                    "Cardiology", "Dermatology",
                    "General Medicine", "Orthopedics");

            List<String> doctorNames = Arrays.asList(
                    "Dr. Sharma", "Dr. Verma",
                    "Dr. Singh", "Dr. Gupta");

            int index = doctorNames.indexOf(doctor);

            request.setAttribute(
                    "department", departments.get(index));

            request.setAttribute("doctors", doctors);

            request.getRequestDispatcher("/result.jsp")
                    .forward(request, response);

        } catch (NumberFormatException e) {
            response.sendError(400, "Age must be a whole number.");
        }
    }
}