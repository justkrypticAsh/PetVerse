

<%@ page import="java.util.List" %>
<%@ page import="com.project.petverse.model.Pet" %>
<%@ page import="com.project.petverse.dao.AdoptionRequestDAO" %>
<%@ include file="navbar.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Home - PetVerse</title>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #ffecd2, #fcb69f);
            font-family: 'Poppins', sans-serif;
            animation: fadeIn 0.8s ease-in-out;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(15px); }
            to { opacity: 1; transform: translateY(0); }
        }

        .pet-card {
            border-radius: 20px;
            overflow: hidden;
            position: relative;
            background: rgba(255,255,255,0.90);
            backdrop-filter: blur(8px);
            border: 3px solid transparent;
            background-clip: padding-box;
            transition: .3s ease;
            box-shadow: 0 8px 25px rgba(0,0,0,0.15);
        }

        .pet-card:hover {
            transform: translateY(-10px);
            box-shadow: 0 12px 30px rgba(0,0,0,0.3);
        }

        .pet-img {
            width: 100%;
            height: 220px;
            object-fit: cover;
        }

        .badge-custom {
            background: #28a745;
            font-size: 14px;
            padding: 6px 10px;
            border-radius: 10px;
        }

        .badge-grey {
            background: grey;
            font-size: 14px;
            padding: 6px 10px;
            border-radius: 10px;
        }

        .title-heading {
            text-align: center;
            font-weight: 700;
            margin-top: 20px;
            font-size: 32px;
        }
    </style>
</head>

<body>

<%
    String adopted = request.getParameter("adopted");
    if("1".equals(adopted)) {
%>
    <script>
        Swal.fire("Success!", "You adopted this pet!", "success");
    </script>
<%
    } else if("already".equals(adopted)) {
%>
    <script>
        Swal.fire("Oops!", "This pet is already adopted.", "warning");
    </script>
<%
    }
%>

<%
    Integer userId = (Integer) session.getAttribute("userId");
    AdoptionRequestDAO adoptDao = new AdoptionRequestDAO();
%>

<h2 class="title-heading">🐶 Available Pets for Adoption</h2>

<div class="container mt-4">
    <div class="row">

        <%
            List<Pet> pets = (List<Pet>) request.getAttribute("pets");

            if (pets != null && !pets.isEmpty()) {
                for (Pet p : pets) {

                    boolean adoptedPet = adoptDao.isPetAdopted(p.getId());
                    boolean adoptedByUser = (userId != null) && adoptDao.isAdoptedByUser(p.getId(), userId);
        %>

        <div class="col-md-4 mb-4">
            <div class="pet-card">

                <img src="<%= p.getImageUrl() %>" class="pet-img">

                <div class="p-3">
                    <h4><%= p.getName() %></h4>
                    <p><strong>Age:</strong> <%= p.getAge() %> years</p>
                    <p><strong>Breed:</strong> <%= p.getBreed() %></p>

                    <% if (adoptedByUser) { %>

                        <span class="badge-custom">Adopted by You</span>
                        <button class="btn btn-secondary w-100 mt-2" disabled>Already Adopted</button>

                    <% } else if (adoptedPet) { %>

                        <span class="badge-grey">Already Adopted</span>
                        <button class="btn btn-secondary w-100 mt-2" disabled>Unavailable</button>

                    <% } else { %>

                        <button class="btn btn-success w-100"
                            onclick="confirmAdopt(<%= p.getId() %>)">Adopt Now</button>

                    <% } %>

                </div>
            </div>
        </div>

        <%
                }
            } else {
        %>

        <p class="text-center">No pets available.</p>

        <% } %>

    </div>
</div>

<script>
function confirmAdopt(id) {
    Swal.fire({
        title: "Confirm Adoption",
        text: "Do you want to adopt this pet?",
        icon: "question",
        showCancelButton: true,
        confirmButtonText: "Yes, Adopt!",
        cancelButtonText: "Cancel",
        confirmButtonColor: "#28a745"
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = "adopt?id=" + id;
        }
    });
}
</script>

</body>
</html>
