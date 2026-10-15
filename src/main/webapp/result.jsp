<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MediCare Patient Report</title>
</head>
<body>

    <h1>MediCare Hospital</h1>
    <h2>Patient Registration Successful!</h2>

    <hr>

    <h2>Patient Details</h2>

    <p>Patient Name: <c:out value="${name}"/></p>
    <p>Age: <c:out value="${age}"/></p>
    <p>Gender: <c:out value="${gender}"/></p>
    <p>Phone: <c:out value="${phone}"/></p>
    <p>Disease: <c:out value="${disease}"/></p>
    <p>Doctor: <c:out value="${doctor}"/></p>
    <p>Department: <c:out value="${department}"/></p>
    <p>Appointment Date: <c:out value="${date}"/></p>

    <hr>

    <h2>Patient Category</h2>

    <c:choose>
        <c:when test="${age < 18}">
            <p>Patient Category: Minor</p>
        </c:when>

        <c:otherwise>
            <p>Patient Category: Adult</p>
        </c:otherwise>
    </c:choose>

    <hr>

    <h2>Appointment Status</h2>

    <c:if test="${not empty name}">
        <p>Your appointment request has been received.</p>
    </c:if>

    <hr>

    <h2>Available Doctors</h2>

    <ul>
        <c:forEach var="doc" items="${doctors}">
            <li><c:out value="${doc}"/></li>
        </c:forEach>
    </ul>

    <a href="index.html">Register Another Patient</a>

</body>
</html>