<%@ page import="java.util.List" %>
<%@ page import="com.project.petverse.model.AdoptionRequest" %>
<%@ include file="navbar.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <title>Adoption Requests - PetVerse</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        /* Fade-In Page */
body {
    animation: fadeIn 0.8s ease-in-out;
}

@keyframes fadeIn {
    from { opacity: 0; transform: translateY(20px); }
    to { opacity: 1; transform: translateY(0); }
}

/* Smooth Hover Scale for Buttons */
.btn {
    transition: transform 0.2s ease, box-shadow 0.3s ease;
}

.btn:hover {
    transform: scale(1.05);
    box-shadow: 0 8px 20px rgba(0,0,0,0.3);
}

/* Floating Pet Cards Animation */
.pet-card {
    transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.pet-card:hover {
    transform: translateY(-10px) scale(1.02);
    box-shadow: 0 12px 30px rgba(0,0,0,0.4);
}

/* Glow Effect on Hover */
.pet-card:hover .pet-img {
    filter: brightness(1.15);
}

/* Form card smooth pop */
.form-card, .card-bg {
    animation: cardPop 0.6s ease;
}

@keyframes cardPop {
    from { opacity: 0; transform: scale(0.9); }
    to { opacity: 1; transform: scale(1); }
}

/* Navbar Slide Animation */
.navbar {
    animation: slideDown 0.6s ease;
}

@keyframes slideDown {
    from { opacity: 0; transform: translateY(-20px); }
    to { opacity: 1; transform: translateY(0); }
}

/* Button Wave Ripple */
.btn:active {
    transform: scale(0.92);
    transition: transform 0.1s;
}

/* Table Row Hover Animation */
.table-hover tbody tr:hover {
    background-color: rgba(0,0,0,0.05);
    transform: scale(1.01);
    transition: 0.2s;
}

        body {
            background: linear-gradient(135deg, #c3cfe2, #cfd9df);
            font-family: 'Poppins', sans-serif;
        }

        .container {
            margin-top: 30px;
            background: rgba(255,255,255,0.7);
            backdrop-filter: blur(8px);
            padding: 25px;
            border-radius: 15px;
            box-shadow: 0 8px 25px rgba(0,0,0,0.2);
        }

        h2 {
            font-weight: 700;
        }
    </style>
</head>

<body>

<div class="container">
    <h2 class="mb-4">Adoption Requests</h2>

    <%
        List<AdoptionRequest> list = (List<AdoptionRequest>) request.getAttribute("requests");
        if (list != null && !list.isEmpty()) {
    %>

    <table class="table table-hover">
        <thead class="table-dark">
            <tr>
                <th>Pet Name</th>
                <th>User Name</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        </thead>

        <tbody>
            <% for (AdoptionRequest ar : list) { %>
            <tr>
                <td><%= ar.getPetName() %></td>
                <td><%= ar.getUserName() %></td>

                <td>
                    <% if (ar.getStatus().equals("Pending")) { %>
                        <span class="badge bg-warning text-dark">Pending</span>
                    <% } else if (ar.getStatus().equals("Approved")) { %>
                        <span class="badge bg-success">Approved</span>
                    <% } else { %>
                        <span class="badge bg-danger">Rejected</span>
                    <% } %>
                </td>

                <td>
                    <a href="#" class="btn btn-success btn-sm">Approve</a>
                    <a href="#" class="btn btn-danger btn-sm">Reject</a>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>

    <% } else { %>

    <p>No adoption requests yet.</p>

    <% } %>

</div>

</body>
</html>
